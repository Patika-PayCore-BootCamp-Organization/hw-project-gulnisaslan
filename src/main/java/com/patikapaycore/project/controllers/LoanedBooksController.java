package com.patikapaycore.project.controllers;

import com.patikapaycore.project.models.entities.LoanedBook;
import com.patikapaycore.project.services.abstracts.LoanedBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "/api/loanedbooks")
@RequiredArgsConstructor
public class LoanedBooksController {

    @Autowired
    private final LoanedBookService loanedBookService;

    @GetMapping("/getall")
    public List<LoanedBook> getAllLoanedBooks(){
        return this.loanedBookService.getAllLoanedBooks();
    }

}
