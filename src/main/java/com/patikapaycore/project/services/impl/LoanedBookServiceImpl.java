package com.patikapaycore.project.services.impl;

import com.patikapaycore.project.models.dtos.response.BookResponseDto;
import com.patikapaycore.project.models.entities.LoanedBook;
import com.patikapaycore.project.models.entities.User;
import com.patikapaycore.project.controllers.repositories.LoanedBookRepository;
import com.patikapaycore.project.services.abstracts.BookService;
import com.patikapaycore.project.services.abstracts.LoanedBookService;
import com.patikapaycore.project.services.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanedBookServiceImpl implements LoanedBookService {
    private final LoanedBookRepository loanedBookRepository;
    private final BookService bookService;
    private  final UserService userService;
    @Autowired
    public LoanedBookServiceImpl(LoanedBookRepository loanedBookRepository, BookService bookService, UserService userService) {
        this.loanedBookRepository = loanedBookRepository;
        this.bookService = bookService;
        this.userService = userService;
    }

    @Override
    public List<LoanedBook> getAllLoanedBooks() {
        return this.loanedBookRepository.findAll();
    }

    @Override
    public LoanedBook getByLoanedBookId(Integer id) {

        return   this.loanedBookRepository.getById(id);
    }

    @Override
    public LoanedBook addLoanedBook(Integer userId,Integer bookId) {
        User byUserId = userService.getByUserId(userId);
        BookResponseDto byBookId = bookService.getByBookId(bookId);

       LoanedBook loanedBook = null;
       loanedBook.setBook(byBookId);
       loanedBook.setUser(byUserId);
        return this.loanedBookRepository.save(loanedBook);
    }

    @Override
    public void updateLoanedBook(LoanedBook loanedBook) {
        this.loanedBookRepository.save(loanedBook);
    }

    @Override
    public boolean deleteLoanedBook(Integer id) {
        LoanedBook byId = this.loanedBookRepository.getById(id);
      this.loanedBookRepository.delete(byId);
      return true;
    }

}

