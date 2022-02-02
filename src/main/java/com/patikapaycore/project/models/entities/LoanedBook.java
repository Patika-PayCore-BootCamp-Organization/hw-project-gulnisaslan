package com.patikapaycore.project.models.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name="loaned_books")
public class LoanedBook implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    //ToDo: to was used, with Hibernate mapping in tables
//    @NotNull
//    @Column(name="user_id")
//    private Integer userId;
//
//    @NotNull
//    @Column(name="book_id")
//    private Integer bookId;

   @NotNull
   @Column(name="loaned_book")
    private LocalDate LoanedDate = LocalDate.now();

   @NotNull
   @Column(name="return_date")
    private LocalDate returnDate = LocalDate.now().plusDays(30);

    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="user_id")
    private User user;

    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="book_id")
    private Book book;


}
