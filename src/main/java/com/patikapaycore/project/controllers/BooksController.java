package com.patikapaycore.project.controllers;

import com.patikapaycore.project.models.entities.Book;
import com.patikapaycore.project.services.abstracts.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;


@Validated

@RestController
@RequestMapping("/api/books")
public class BooksController {


    private final BookService bookService;

    @Autowired
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping(value ="/getallbooks")
   public List<Book> getAllBooks(){
      return null;// bookService.getAllBooks();
    }
    //return allPassengers.stream().map(PASSENGER_MAPPER::toDto).collect(Collectors.toList());


   @GetMapping (value ="/getbybookid/{id}")
   public Book getByBookId(@PathVariable @Min(1) @Param("{id}") Integer id){
       return null;// this.bookService.getByBookId(id);
   }

   @PostMapping(value = "/addBook")
   public Book addBook(Book book){
        return null;//  this.bookService.addBook(book);
   }

    @PutMapping(value ="/updatebook",consumes ={"application/json"})
    public void updateBook(@Valid @RequestBody Book book){
      // this.bookService.updateBook(book);

    }
    @DeleteMapping(value ="/deletebook/{id}")
    public boolean deleteBook(@PathVariable @Min(1) @Param("{id}") Integer id){
       ///this.bookService.deleteBook(id);
       return true;
    }


}
