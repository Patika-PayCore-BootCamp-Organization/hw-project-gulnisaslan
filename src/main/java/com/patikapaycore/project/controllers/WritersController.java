package com.patikapaycore.project.controllers;

import com.patikapaycore.project.models.entities.Writer;
import com.patikapaycore.project.services.abstracts.WriterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(name = "/api/writers")
public class WritersController {

    @Autowired
    private WriterService writerService;

    @GetMapping(name ="/getall")
    public List<Writer> getAll(){
        return this.writerService.getAllWriter();
    }
    @GetMapping(name ="/{id}")
    public Writer getById(@PathVariable Integer id){
        return  this.writerService.getByWriterId(id);
    }

    @PostMapping(name ="/create")
    public Writer addWriter(@Valid @RequestBody Writer writer){
      return  this.writerService.addWriter(writer);
    }

    @PutMapping(name ="/update")
    public void updateWriter(@Valid @RequestBody Writer writer){
        this.writerService.updateWriter(writer);
    }

    @DeleteMapping(name ="/delete/{id}")
    public boolean deleteWriter(Integer id){
        this.writerService.deleteWriter(id);
        return true;
    }





}
