package com.patikapaycore.project.models.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="writers")
public class Writer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;


    @NotNull(message = "Writer name cannot be null")
    @Column(name="writer_name")
    private  String writerName;

    @NotNull(message = "Writer surname cannot be null")
    @Column(name="writer_surname")
    private String writerSurname;


    @JsonIgnore
    @JsonBackReference
    @OneToMany(mappedBy = "writer")
    private List<Book> books;






}
