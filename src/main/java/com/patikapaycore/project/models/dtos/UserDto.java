package com.patikapaycore.project.models.dtos;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class UserDto {

    private String firstname;
    private String surname;
    private  String username;
    private String email;
    private String password;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date birthDate;
    private String phoneNumber;

}
