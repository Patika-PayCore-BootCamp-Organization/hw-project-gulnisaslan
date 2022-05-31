package com.patikapaycore.project.models.mapper.request;

import com.patikapaycore.project.models.dtos.request.BookRequestDto;
import com.patikapaycore.project.models.entities.Book;

import com.patikapaycore.project.models.entities.BookType;
import com.patikapaycore.project.models.entities.Writer;
import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookRequestMapper {
    BookTypeRequestMapper BOOK_TYPE_REQUEST_MAPPER= Mappers.getMapper(BookTypeRequestMapper.class);


    BookRequestDto map(Book book);





}
