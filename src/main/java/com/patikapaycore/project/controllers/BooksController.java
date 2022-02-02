package com.patikapaycore.project.controllers;

import com.patikapaycore.project.models.entities.Book;
import com.patikapaycore.project.services.abstracts.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.validation.Valid;
import javax.validation.constraints.Min;
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

   @GetMapping (value ="/getbybookid/{id}")
   public Book getByBookId(@PathVariable @Min(1) @Param("{id}") Integer id){
       return this.bookService.getByBookId(id);
   }
   @PostMapping(value = "/addBook", consumes = {"application/json"})
   public Book addBook(Book book){
        return  this.bookService.addBook(book);
   }

    @PutMapping(value ="/updatebook")
    public void updateBook(@Valid @RequestBody Book book){
       this.bookService.updateBook(book);

    }
    @DeleteMapping(value ="/deletebook/{id}")
    public boolean deleteBook(@PathVariable @Min(1) @Param("{id}") Integer id){
       this.bookService.deleteBook(id);
       return true;
    }
}
