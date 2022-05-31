package com.patikapaycore.project.controllers.repositories;


import com.patikapaycore.project.models.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {



}










