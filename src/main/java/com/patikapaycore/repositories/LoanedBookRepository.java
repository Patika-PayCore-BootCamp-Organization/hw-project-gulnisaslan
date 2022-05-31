package com.patikapaycore.project.controllers.repositories;

import com.patikapaycore.project.models.entities.LoanedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanedBookRepository extends JpaRepository<LoanedBook,Integer> {
    LoanedBook getByUser_Username(String username);
    LoanedBook getByBook_BookName(String bookName);


}
