package com.patikapaycore.project.models.mappers;


import com.patikapaycore.project.models.dtos.BookDto;
import com.patikapaycore.project.models.entities.Book;
import com.patikapaycore.project.models.entities.BookType;
import com.patikapaycore.project.models.entities.Writer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface BookMapper {


    BookDto toDto(Book book);

    Book toEntity(BookDto bookDto);

}
