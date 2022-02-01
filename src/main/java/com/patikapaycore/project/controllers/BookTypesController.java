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
@RequiredArgsConstructor
public class BookTypesController {
    @Autowired
    private final BookTypeService bookTypeService;

    @GetMapping("/getallbooktype")
    public List<BookType> getAllBookType(){
        return  this.bookTypeService.getAllBookType();
    }
    @GetMapping("/{id}")
    public BookType getByBookTypeId(@PathVariable @Min(1) Integer id){
        return this.bookTypeService.getByBookId(id);

    }
    @PostMapping("/create")
    public BookType addBookType(@Valid @RequestBody BookType bookType){
        return  this.bookTypeService.addBookType(bookType);
    }
    @PutMapping("/update")
    public void updateBookType(@Valid @RequestBody BookType bookType){
       this.bookTypeService.updateBookType(bookType);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteBookType(Integer id){
        this.bookTypeService.deleteBookType(id);
        return true;
    }



}

