package com.patikapaycore.project.security;

import com.patikapaycore.project.models.dtos.UserResponseDto;
import com.patikapaycore.project.models.entities.User;
import com.patikapaycore.project.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class  MyUserDetails implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User byUsername = userRepository.findByUsername(username);
        if (byUsername == null) {
            throw  new UsernameNotFoundException("User "+ username +" not found");
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(byUsername.getPassword())
                .authorities(byUsername.getRoles())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
   }
}
