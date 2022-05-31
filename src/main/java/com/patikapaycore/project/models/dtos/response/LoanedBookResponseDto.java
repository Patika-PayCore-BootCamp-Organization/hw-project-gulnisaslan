package com.patikapaycore.project.models.dtos.response;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
public class LoanedBookResponseDto {

     private  String userFullName;
     private  String bookName;
     private LocalDate loanedDate;
     private  LocalDate returnDate;


}
