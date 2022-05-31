package com.patikapaycore.project.models.mapper.response;


import com.patikapaycore.project.models.dtos.response.BookTypeResponseDto;
import com.patikapaycore.project.models.entities.BookType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "Spring")
public interface BookTypeResponseMapper {

    BookTypeResponseMapper BOOK_TYPE_RESPONSE_MAPPER = Mappers.getMapper(BookTypeResponseMapper.class);

    BookTypeResponseDto map(BookType bookType);

}

