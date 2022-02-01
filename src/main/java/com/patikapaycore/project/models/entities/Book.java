package com.patikapaycore.project.models.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @NotBlank
    private Integer bookTypeId;

    @NotBlank
    private Integer writerId;

    @NotBlank
    private String name;

    @NotBlank
    private String isbnNo;

    @NotBlank
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



