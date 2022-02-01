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

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="books")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Integer id;

    @NotNull
    @Column(name="book_type_id")
    private Integer bookTypeId;
    @NotNull
    @Column(name = "writer_id")
    private Integer writerId;

    @NotNull
    @Column(name="name")
    private String name;

    @NotNull
    @Column(name = "isbn_no")
    private String isbnNo;

    @Column(name= "description")
    private  String description;

//    @JsonManagedReference
//    @ManyToOne(cascade = CascadeType.MERGE)
//    private BookType bookType;
//
//    @JsonManagedReference
//    @ManyToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name="writer_id")
//    private Writer writer;


}



