package com.patikapaycore.project.controllers;

import com.patikapaycore.project.models.entities.LoanedBook;
import com.patikapaycore.project.services.abstracts.LoanedBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;


@RestController
@RequestMapping(name = "/api/loanedbooks")
public class LoanedBooksController {

    @Autowired
    private LoanedBookService loanedBookService;

    @GetMapping(value ="/getallloanedbook")
    public List<LoanedBook> getAllLoanedBooks(){
        return this.loanedBookService.getAllLoanedBooks();
    }


    @GetMapping(value ="getbyloanedid/{id}")
    public LoanedBook getById(@PathVariable @Min(1) @Param("{id}") Integer id){
        return this.loanedBookService.getByLoanedBookId(id);
    }

    @PostMapping(value ="/createloanedbook")
    public LoanedBook addLonedBook(@Valid @RequestBody LoanedBook loanedBook){
        return this.loanedBookService.addLoanedBook(loanedBook);
    }

    @PutMapping(value ="/updateloanedbook")
    public void updateLoanedBook(@Valid @RequestBody LoanedBook loanedBook){
        this.loanedBookService.updateLoanedBook(loanedBook);
    }

    @DeleteMapping(value ="/deleteloanedbook/{id}")
    public boolean deleteLoanedBook(@PathVariable @Min(1) @Param("{id}") Integer id){
        this.loanedBookService.deleteLoanedBook(id);
        return true;
    }
}
