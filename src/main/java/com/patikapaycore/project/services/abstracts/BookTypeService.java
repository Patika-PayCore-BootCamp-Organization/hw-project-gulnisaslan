package com.patikapaycore.project.services.abstracts;

import com.patikapaycore.project.models.entities.BookType;

import java.util.List;

public interface BookTypeService {

    List<BookType> getAllBookType();

    BookType getByBookId(Integer id);

    BookType addBookType(BookType bookType);

    void updateBookType(BookType bookType);

    boolean deleteBookType(Integer id);

}


