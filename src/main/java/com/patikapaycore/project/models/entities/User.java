package com.patikapaycore.project.models.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @NotNull(message = "Username can not be  null")
    @Column(name="first_name")
    private String firstname;

    @NotNull(message = "user surname can not be null")
    @Column(name="surname")
    private String surname;

    @Email
    @NotNull
    @Column(name="email",unique = true)
    private String email;

    @NotNull
    @Column(name="password")
    private String password ;

    @NotNull
    @Column(name="birth_date")
    private Date birthDate;

    @NotNull
    @Column(name="phone_number")
    private String phoneNumber;

    @JsonBackReference
    @OneToMany(mappedBy = "user",cascade = CascadeType.MERGE)
    List<LoanedBook> loanedBooks;




}
