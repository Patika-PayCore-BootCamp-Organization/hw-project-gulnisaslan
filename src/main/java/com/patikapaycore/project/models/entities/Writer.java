package com.patikapaycore.project.models.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name="writer")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Writer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Writer name cannot be null")
    private  String name;
    @NotNull(message = "Writer surname cannot be null")
    private String surname;

//    @JsonBackReference
//    @OneToMany(mappedBy = "writer",cascade = CascadeType.MERGE)
//    List<Book> books;





}
