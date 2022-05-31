package com.patikapaycore.project.services.impl;

import com.patikapaycore.project.models.entities.Writer;
import com.patikapaycore.project.controllers.repositories.WriterRepository;
import com.patikapaycore.project.services.abstracts.WriterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WriterServiceImpl implements WriterService {

    private final WriterRepository writerRepository;

    public WriterServiceImpl(WriterRepository writerRepository) {
        this.writerRepository = writerRepository;
    }

    @Override
    public List<Writer> getAllWriter() {
        return this.writerRepository.findAll();
    }

    @Override
    public Writer getByWriterId(Integer id) {
        return this.writerRepository.getById(id);
    }

    @Override
    public Writer addWriter(Writer writer) {
        return this.writerRepository.save(writer);
    }

    @Override
    public void updateWriter(Writer writer) {
         this.writerRepository.save(writer);
    }

    @Override
    public boolean deleteWriter(Integer id) {
        Writer byId = this.writerRepository.getById(id);
        this.writerRepository.delete(byId);
        return true;
    }

}
