package com.patikapaycore.project.services.abstracts;

import com.patikapaycore.project.models.dtos.request.BookRequestDto;
import com.patikapaycore.project.models.dtos.response.BookResponseDto;
import com.patikapaycore.project.models.entities.Book;

import java.util.List;

public interface BookService {
    List<BookResponseDto> getAllBooks();

    BookResponseDto getByBookId(Integer id);

    BookResponseDto addBook(BookRequestDto bookRequestDto);

    void updateBook(BookRequestDto bookRequestDto);

    boolean deleteBook(Integer id);

}
