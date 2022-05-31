package com.patikapaycore.project.models.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name="books")
public class Book {

    @Id

    @Column(name = "id")
    private  Integer id;

//    @NotNull
//    @Column(name = "book_type_id")
//    private Integer bookTypeId;
//
//    @NotNull
//    @Column(name = "writer_id")
//    private Integer writerId;

    @NotNull(message="Book name cannot be null.")
    @Column(name = "book_name")
    private String bookName;


    @NotNull
    @Column(name = "isbn_no")
    private String isbnNo;

    @Column(name = "book_description")
    private  String bookDescription;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY, targetEntity = BookType.class)
    @JoinColumn(name = "book_type_id",referencedColumnName = "id")
    private BookType bookType;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY, targetEntity = Writer.class)
    @JoinColumn(name = "writer_id",referencedColumnName = "id")
    private Writer writer;

    @JsonIgnore
    @OneToMany(mappedBy = "book",cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    private List<LoanedBook> loanedBooks;


}



