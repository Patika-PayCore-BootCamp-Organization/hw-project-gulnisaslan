package com.patikapaycore.project.controllers;

import com.patikapaycore.project.models.dtos.BookDto;
import com.patikapaycore.project.models.entities.Book;
import com.patikapaycore.project.models.mappers.BookMapper;
import com.patikapaycore.project.services.abstracts.BookService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;


@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BooksController {


    private final BookService bookService;
    private static  final BookMapper BOOK_MAPPER = Mappers.getMapper(BookMapper.class);



    @GetMapping(value ="/getallbooks")
   public List<BookDto> getAllBooks(){
        List<Book> allBooks = this.bookService.getAllBooks();
     return allBooks.stream().map(BOOK_MAPPER::toDto).collect(Collectors.toList());



    }
    //return allPassengers.stream().map(PASSENGER_MAPPER::toDto).collect(Collectors.toList());


   @GetMapping (value ="/getbybookid/{id}")
   public Book getByBookId(@PathVariable @Min(1) @Param("{id}") Integer id){
       return this.bookService.getByBookId(id);
   }

   @PostMapping(value = "/addBook")
   public Book addBook(Book book){
        return  this.bookService.addBook(book);
   }

    @PutMapping(value ="/updatebook",consumes ={"application/json"})
    public void updateBook(@Valid @RequestBody Book book){
       this.bookService.updateBook(book);

    }
    @DeleteMapping(value ="/deletebook/{id}")
    public boolean deleteBook(@PathVariable @Min(1) @Param("{id}") Integer id){
       this.bookService.deleteBook(id);
       return true;
    }


}
