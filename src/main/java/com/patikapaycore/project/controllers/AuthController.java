package com.patikapaycore.project.controllers;


import com.patikapaycore.project.models.dtos.LoginDto;
import com.patikapaycore.project.models.dtos.UserDto;
import com.patikapaycore.project.models.mappers.UserMapper;
import com.patikapaycore.project.services.abstracts.AuthService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@Valid
@RequestMapping("api/auth/")
public class AuthController {

    private  final AuthService authService;
    private final UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginDto loginDto){
        return this.authService.signIn(loginDto.getUsername(),loginDto.getPassword());
    }

    @PostMapping( "/signup")
    public  String signup( @RequestBody@Validated UserDto user){
        return  this.authService.signUp(USER_MAPPER.modelToEntity(user));
    }
    @DeleteMapping("/{username}")
    public String delete(@PathVariable String username){
        this.authService.deleteUser(username);
        return username;
    }




}
