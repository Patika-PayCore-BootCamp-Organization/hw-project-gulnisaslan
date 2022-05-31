package com.patikapaycore.project.models.mapper.response;

import com.patikapaycore.project.models.dtos.response.BookResponseDto;
import com.patikapaycore.project.models.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "Spring")
public interface BookResponseMapper {

    BookResponseMapper BOOK_RESPONSE_MAPPER = Mappers.getMapper(BookResponseMapper.class);


    BookResponseDto map(Book book);

}

