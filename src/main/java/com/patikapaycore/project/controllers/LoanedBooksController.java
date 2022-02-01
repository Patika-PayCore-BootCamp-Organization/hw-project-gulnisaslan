package com.patikapaycore.project.controllers;

import com.patikapaycore.project.models.entities.LoanedBook;
import com.patikapaycore.project.services.abstracts.LoanedBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(name = "/api/loanedbooks")
public class LoanedBooksController {

    @Autowired
    private LoanedBookService loanedBookService;

    @GetMapping(name ="/getall")
    public List<LoanedBook> getAllLoanedBooks(){
        return this.loanedBookService.getAllLoanedBooks();
    }


    @GetMapping(name ="/{id}")
    public LoanedBook getById(@PathVariable Integer id){
        return this.loanedBookService.getByLoanedBookId(id);
    }

    @PostMapping(name ="/create")
    public LoanedBook addLonedBook(@Valid @RequestBody LoanedBook loanedBook){
        return this.loanedBookService.addLoanedBook(loanedBook);
    }

    @PutMapping(name ="/update")
    public void updateLoanedBook(@Valid @RequestBody LoanedBook loanedBook){
        this.loanedBookService.updateLoanedBook(loanedBook);
    }

    @DeleteMapping(name ="/delete/{id}")
    public boolean deleteLoanedBook(@PathVariable Integer id){
        this.loanedBookService.deleteLoanedBook(id);
        return true;
    }
}
