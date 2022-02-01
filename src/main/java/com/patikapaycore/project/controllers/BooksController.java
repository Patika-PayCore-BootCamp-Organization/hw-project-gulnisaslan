package com.patikapaycore.project.controllers;

import com.patikapaycore.project.models.entities.Book;
import com.patikapaycore.project.services.abstracts.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BooksController {


    @Autowired
    private  BookService bookService;

    @GetMapping(value ="/getallbooks")
   public List<Book> getAllBooks(){
       return this.bookService.getAllBooks();
   }

   @GetMapping (value ="/{id}")
   public Book getByBookId(@PathVariable  Integer id){
       return this.bookService.getByBookId(id);
   }

   @PostMapping(value ="/create")
    public Book addBook(@Valid @RequestBody Book book){
         return this.bookService.addBook(book);
    }
    @PutMapping(value ="/update")
    public void updateBook(@Valid @RequestBody Book book){
       this.bookService.updateBook(book);

    }
    @DeleteMapping(value ="/delete/{id}")
    public boolean deleteBook(@PathVariable Integer id){
       this.bookService.deleteBook(id);
       return true;
    }
}
