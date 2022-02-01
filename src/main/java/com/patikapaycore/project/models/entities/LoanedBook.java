package com.patikapaycore.project.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name="loaned_book")
public class LoanedBook implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private Integer userId;

    @NotBlank
    private Integer bookId;

    @NotBlank
    private LocalDate LoanedDate = LocalDate.now();

    @NotBlank
    private LocalDate returnDat = LocalDate.now().plusDays(30);




}
