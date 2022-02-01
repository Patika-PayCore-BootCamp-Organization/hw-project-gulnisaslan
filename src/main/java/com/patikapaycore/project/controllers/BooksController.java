package com.patikapaycore.project.controllers;

import com.patikapaycore.project.models.entities.Book;
import com.patikapaycore.project.services.abstracts.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BooksController {

    @Autowired
    private final BookService bookService;

    @GetMapping("/getallbooks")
   public List<Book> getAllBooks(){
       return this.bookService.getAllBooks();
   }

   @GetMapping ("/{id}")
   public Book getByBookId(@PathVariable  Integer id){
       return this.bookService.getByBookId(id);
   }

   @PostMapping("/create")
    public Book addBook(@Valid @RequestBody Book book){
         return this.bookService.addBook(book);
    }
    @PutMapping("/update")
    public void updateBook(@Valid @RequestBody Book book){
       this.bookService.updateBook(book);

    }
    @DeleteMapping("/delete/{id}")
    public boolean deleteBook(@PathVariable Integer id){
       this.bookService.deleteBook(id);
       return true;
    }
}
