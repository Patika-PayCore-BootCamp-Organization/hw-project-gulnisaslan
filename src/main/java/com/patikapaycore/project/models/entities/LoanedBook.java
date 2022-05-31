package com.patikapaycore.project.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.patikapaycore.project.models.dtos.response.BookResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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
public class LoanedBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

//    @NotNull
//    @Column(name = "user_id")
//    private Integer userId;

//    @NotNull
//    @Column(name = "book_id")
//    private Integer bookId;

   @NotNull
   @Column(name = "loaned_date")
   @DateTimeFormat(pattern = "dd/MM/yyyy")
   private LocalDate loanedDate = LocalDate.now();

   @NotNull
   @Column(name = "return_date")
   private LocalDate returnDate = LocalDate.now().plusDays(30);



   @JsonIgnore
   @ManyToOne(cascade = CascadeType.MERGE,fetch =FetchType.LAZY,targetEntity = User.class)
   @JoinColumn(name = "user_id")
   private User user;

   @JsonIgnore
   @ManyToOne(cascade = CascadeType.MERGE,fetch =FetchType.LAZY,targetEntity = Book.class)
    @JoinColumn(name = "book_id")
    private  Book book;

public void setBook(BookResponseDto byBookId) {
}

public void setUser(User byUserId) {
}

}

