package com.patikapaycore.project.services.impl;

import com.patikapaycore.project.models.dtos.request.BookRequestDto;
import com.patikapaycore.project.models.dtos.response.BookResponseDto;
import com.patikapaycore.project.models.entities.Book;
import com.patikapaycore.project.controllers.repositories.BookRepository;
import com.patikapaycore.project.models.mapper.request.BookRequestMapper;
import com.patikapaycore.project.models.mapper.response.BookResponseMapper;
import com.patikapaycore.project.services.abstracts.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BookServiceImpl implements BookService {

    private  final BookRepository bookRepository;
    
    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    @Override
    public List<BookResponseDto> getAllBooks() {
       // bookResponseMapper.map(BookResponseDto.class);
        return null;/*this.bookRepository.findAll()*/


    }

   // @Override
    // public Book getByBookId(Integer id) {
    //     return this.bookRepository.getById(id);
    // }

    // @Override
    // public Book addBook(Book book) {
    //     return this.bookRepository.save(book);
    // }

    // @Override
    // public void updateBook(Book book) {

    //     this.bookRepository.save(book);

    //}


    @Override
    public boolean deleteBook(Integer id) {

        Book byId = this.bookRepository.getById(id);
        this.bookRepository.delete(byId);
        return true;
    }

    @Override
    public BookResponseDto getByBookId(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BookResponseDto addBook(BookRequestDto bookRequestDto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateBook(BookRequestDto bookRequestDto) {
        // TODO Auto-generated method stub
        
    }
}

