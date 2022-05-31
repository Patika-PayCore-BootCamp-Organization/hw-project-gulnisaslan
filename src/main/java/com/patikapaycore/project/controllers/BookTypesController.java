package com.patikapaycore.project.controllers;

import com.patikapaycore.project.models.dtos.request.BookTypeRequestDto;
import com.patikapaycore.project.models.entities.Book;
import com.patikapaycore.project.models.entities.BookType;
import com.patikapaycore.project.services.abstracts.BookTypeService;
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
@RestController
@RequestMapping( "/api/booktypes")
public class BookTypesController {

    @Autowired
    private  BookTypeService bookTypeService;

    @GetMapping(value ="/getallbooktype")
    public List<BookType> getAllBookType(){
        return  this.bookTypeService.getAllBookType();
    }
    @GetMapping(value ="/getbybooktypeid/{id}")
    public BookType getByBookTypeId(@PathVariable @Min(1) @Param("{id}") Integer id){
        return this.bookTypeService.getByBookId(id);

    }

    @PostMapping(value ="/createbooktype")
    public BookType addBookType(@Valid @RequestBody BookTypeRequestDto bookType){
        return  this.bookTypeService.addBookType(bookType);
    }
    @PutMapping(value ="/updatebooktype")
    public void updateBookType(@Valid @RequestBody BookType bookType){
       this.bookTypeService.updateBookType(bookType);
    }

    @DeleteMapping(value ="/deletebooktype/{id}")
    public boolean deleteBookType(@PathVariable @Min((1)) @Param("{id}") Integer id){
        this.bookTypeService.deleteBookType(id);
        return true;
    }



}

