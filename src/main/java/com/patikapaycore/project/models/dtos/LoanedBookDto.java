package com.patikapaycore.project.models.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LoanedBookDto {
    private  String firstname;
    private String surname;
    private String email;
    private String typeName;
    private String name;
    private LocalDate loanedDate;
    private LocalDate returnDate;
}
