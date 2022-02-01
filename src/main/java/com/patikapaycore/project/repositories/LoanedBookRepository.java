package com.patikapaycore.project.repositories;

import com.patikapaycore.project.models.entities.LoanedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanedBookRepository extends JpaRepository<LoanedBook,Integer> {
}