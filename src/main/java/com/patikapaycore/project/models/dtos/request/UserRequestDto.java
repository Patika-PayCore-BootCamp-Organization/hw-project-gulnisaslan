package com.patikapaycore.project.models.dtos.request;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Data
public class UserRequestDto {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private Date birthDate;
    private String phoneNumber;
}
