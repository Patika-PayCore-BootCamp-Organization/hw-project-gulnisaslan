package com.patikapaycore.project.services.impl;

import com.patikapaycore.project.models.entities.BookType;
import com.patikapaycore.project.repositories.BookTypeRepository;
import com.patikapaycore.project.services.abstracts.BookTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookTypeServiceImpl implements BookTypeService {
    @Autowired
    private final BookTypeRepository bookTypeRepository;

    @Override
    public List<BookType> getAllBookType() {
        return this.bookTypeRepository.findAll();
    }

    @Override
    public BookType getByBookId(Integer id) {
        return this.bookTypeRepository.getById(id);
    }

    @Override
    public BookType addBookType(BookType bookType) {
        return this.bookTypeRepository.save(bookType);
    }

    @Override
    public void updateBookType(BookType bookType) {

        this.bookTypeRepository.save(bookType);
    }

    @Override
    public boolean deleteBookType(Integer id) {

        BookType byId = this.bookTypeRepository.getById(id);
        this.bookTypeRepository.delete(byId);
        return true;
    }


}
