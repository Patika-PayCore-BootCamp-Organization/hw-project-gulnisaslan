package com.patikapaycore.project.models.dtos;

import com.patikapaycore.project.models.entities.Role;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserResponseDto {

    private Integer id;
    private String firstname;
    private String surname;
    private  String username;
    private String email;
    private String password;
    private Date birthDate;
    private String phoneNumber;

    List<Role> roles;
}
