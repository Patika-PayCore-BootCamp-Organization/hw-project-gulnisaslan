package com.patikapaycore.project.services.abstracts;

import com.patikapaycore.project.models.entities.LoanedBook;

import java.util.List;

public interface LoanedBookService {

   List<LoanedBook> getAllLoanedBooks();

   LoanedBook getByLoanedBookId(Integer id);

   LoanedBook addLoanedBook(Integer userId,Integer bookId);

   void updateLoanedBook(LoanedBook loanedBook);

   boolean deleteLoanedBook(Integer id);


}
