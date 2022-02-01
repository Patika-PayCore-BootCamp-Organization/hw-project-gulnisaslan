package com.patikapaycore.project.repositories;

import com.patikapaycore.project.models.entities.BookType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookTypeRepository extends JpaRepository<BookType,Integer> {
}
