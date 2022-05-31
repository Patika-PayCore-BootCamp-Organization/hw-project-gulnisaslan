package com.patikapaycore.project.models.mapper.request;

import com.patikapaycore.project.models.dtos.request.BookTypeRequestDto;
import com.patikapaycore.project.models.entities.BookType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookTypeRequestMapper {

   BookTypeRequestMapper BOOK_TYPE_REQUEST_MAPPER = Mappers.getMapper(BookTypeRequestMapper.class);

    BookType ToDto(BookTypeRequestDto bookTypeRequestDto);

    BookTypeRequestDto ToEntity(BookType bookType);


}
