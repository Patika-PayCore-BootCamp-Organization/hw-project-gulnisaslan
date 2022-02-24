package com.patikapaycore.project.services.impl;

import com.patikapaycore.project.exception.CustomJwtException;

import com.patikapaycore.project.models.entities.User;

import com.patikapaycore.project.security.JwtTokenProvider;
import com.patikapaycore.project.services.abstracts.AuthService;
import com.patikapaycore.project.services.abstracts.RoleService;
import com.patikapaycore.project.services.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private  final UserService userService;

    private  final RoleService roleService;

    private final JwtTokenProvider jwtTokenProvider;

    private  final AuthenticationManager authenticationManager;

    private  final PasswordEncoder passwordEncoder;


    @Override
    public String signIn(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
            return jwtTokenProvider.createToken(username,userService.findByUsername(username).getRoles());
        }catch (AuthenticationException  exception){
            throw  new CustomJwtException("Invalid Username/Password supplied ", HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public String signUp(User user) {
        if (!userService.existsByUsername(user.getUsername())) {
             user.setPassword(passwordEncoder.encode(user.getPassword()));
             user.setRoles(Collections.singletonList(roleService.getById(2)));
             userService.addUser(user);
             return jwtTokenProvider.createToken(user.getUsername(),user.getRoles());
        }
        else{
            throw  new CustomJwtException("Username already in use",HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public void deleteUser(String username) {
       if (!userService.existsByUsername(username)){
           userService.deleteByUsername(username);
       }
       else{
           throw  new CustomJwtException("Username is not found",HttpStatus.NOT_FOUND);
       }
    }

    @Override
    public User searchUser(String username) {
        User byUsername = this.userService.findByUsername(username);
        if (byUsername == null)
            throw new CustomJwtException("The User doen't exists",HttpStatus.NOT_FOUND);

        
        return null;
    }

    @Override
    public User whoAmI(HttpServletRequest httpServletRequest) {
        return this.userService.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(httpServletRequest)));
    }

    @Override
    public String refresh(String username) {
        return jwtTokenProvider.createToken(username,userService.findByUsername(username).getRoles());
    }
}
