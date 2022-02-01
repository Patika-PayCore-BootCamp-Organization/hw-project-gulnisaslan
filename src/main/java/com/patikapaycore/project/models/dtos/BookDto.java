package com.patikapaycore.project.models.dtos;

import lombok.Data;

@Data
public class BookDto {

    private  String typeName;
    private String writerName;
    private String writerSurname;
    private String name;
    private String isbnNo;
    private String description;


}
