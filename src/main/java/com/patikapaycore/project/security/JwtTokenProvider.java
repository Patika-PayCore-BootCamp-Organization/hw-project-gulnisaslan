package com.patikapaycore.project.security;

import com.patikapaycore.project.exception.CustomJwtException;
import com.patikapaycore.project.models.entities.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Component
public class JwtTokenProvider {

    @Value("${security.jwt.token.secret-key:secret-key}")
    private String secretKey;
    @Value("${security.jwt.token.expire-length}")
    private long validityInMilliseconds=1000*60*60*24;

    @Autowired
    private MyUserDetails myUserDetails;

    @PostConstruct
    protected void init(){
        secretKey= Base64
                .getEncoder()
                .encodeToString(secretKey.getBytes());
    }

    public  String createToken(String username, List<Role> roles){
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("auth",roles.stream().map(s->new SimpleGrantedAuthority(s.getAuthority())));

        Date date = new Date();
        Date validity = new Date(date.getTime() + validityInMilliseconds);

        return  Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(date)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256,secretKey)
                .compact();

    }

    public Authentication getAuthentication(String token){
      UserDetails userDetails= myUserDetails.loadUserByUsername(getUsername(token));
      return new UsernamePasswordAuthenticationToken(userDetails,"",userDetails.getAuthorities());
    }

    public String getUsername(String token){
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody().getSubject();
    }
    public String resolveToken(HttpServletRequest httpServletRequest){
        String bearerToken = httpServletRequest.getHeader("Authorization");
        if(bearerToken != null && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7);
        }
        return null;
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException exceptions) {
            throw new CustomJwtException("Expired or invalid JWT Token", HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}






