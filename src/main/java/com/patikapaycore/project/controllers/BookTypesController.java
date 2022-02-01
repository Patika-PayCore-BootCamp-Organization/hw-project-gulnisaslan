package com.patikapaycore.project.controllers;

import com.patikapaycore.project.models.entities.Book;
import com.patikapaycore.project.models.entities.BookType;
import com.patikapaycore.project.services.abstracts.BookTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping(name = "/api/booktypes")
public class BookTypesController {

    @Autowired
    private  BookTypeService bookTypeService;

    @GetMapping(name ="/getallbooktype")
    public List<BookType> getAllBookType(){
        return  this.bookTypeService.getAllBookType();
    }
    @GetMapping(name ="/{id}")
    public BookType getById(@PathVariable Integer id){
        return this.bookTypeService.getByBookId(id);

    }
    @PostMapping(name ="/create")
    public BookType addBookType(@Valid @RequestBody BookType bookType){
        return  this.bookTypeService.addBookType(bookType);
    }
    @PutMapping(name ="/update")
    public void updateBookType(@Valid @RequestBody BookType bookType){
       this.bookTypeService.updateBookType(bookType);
    }

    @DeleteMapping(name ="/delete/{id}")
    public boolean deleteBookType(Integer id){
        this.bookTypeService.deleteBookType(id);
        return true;
    }



}

