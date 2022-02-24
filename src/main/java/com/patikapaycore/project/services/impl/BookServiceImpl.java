package com.patikapaycore.project.services.impl;

import com.patikapaycore.project.models.entities.Book;
import com.patikapaycore.project.repositories.BookRepository;
import com.patikapaycore.project.services.abstracts.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private  final BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return this.bookRepository.findAll();

    }

    @Override
    public Book getByBookId(Integer id) {
        return this.bookRepository.getById(id);
    }

    @Override
    public Book addBook(Book book) {
        return this.bookRepository.save(book);
    }

    @Override
    public void updateBook(Book book) {

        this.bookRepository.save(book);

    }


    @Override
    public boolean deleteBook(Integer id) {

        Book byId = this.bookRepository.getById(id);
        this.bookRepository.delete(byId);
        return true;
    }
}

