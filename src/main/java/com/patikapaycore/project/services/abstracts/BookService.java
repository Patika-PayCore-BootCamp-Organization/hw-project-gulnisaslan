package com.patikapaycore.project.services.abstracts;

import com.patikapaycore.project.models.entities.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book getByBookId(Integer id);

    Book addBook(Book book);

    void updateBook(Book book);

    boolean deleteBook(Integer id);

}
