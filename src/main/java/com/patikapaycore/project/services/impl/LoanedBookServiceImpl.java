package com.patikapaycore.project.services.impl;

import com.patikapaycore.project.models.entities.LoanedBook;
import com.patikapaycore.project.repositories.LoanedBookRepository;
import com.patikapaycore.project.services.abstracts.LoanedBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanedBookServiceImpl implements LoanedBookService {

    private final LoanedBookRepository loanedBookRepository;
    @Override
    public List<LoanedBook> getAllLoanedBooks() {
        return this.loanedBookRepository.findAll();
    }

    @Override
    public LoanedBook getByLoanedBookId(Integer id) {
      return   this.loanedBookRepository.getById(id);
    }

    @Override
    public LoanedBook addLoanedBook(LoanedBook loanedBook) {
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

