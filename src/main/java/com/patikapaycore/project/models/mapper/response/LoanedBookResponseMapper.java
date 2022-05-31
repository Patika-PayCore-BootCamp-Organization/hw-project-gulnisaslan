package com.patikapaycore.project.models.mapper.response;

import com.patikapaycore.project.models.dtos.response.LoanedBookResponseDto;
import com.patikapaycore.project.models.entities.Book;
import com.patikapaycore.project.models.entities.LoanedBook;
import com.patikapaycore.project.models.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "Spring")
public interface LoanedBookResponseMapper {
    LoanedBookResponseMapper BOOK_RESPONSE_MAPPER = Mappers.getMapper(LoanedBookResponseMapper.class);

    LoanedBookResponseDto map(Book book, User user, LoanedBook loanedBook);

}
