package com.patikapaycore.project.controllers;

import com.patikapaycore.project.models.entities.Writer;
import com.patikapaycore.project.services.abstracts.WriterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
@RequestMapping(name = "/api/writers")
public class WritersController {

    @Autowired
    private WriterService writerService;


    @GetMapping(value ="getallwriter")
    public List<Writer> getAll(){
        return this.writerService.getAllWriter();
    }
    @GetMapping(value ="/getbywriterid/{id}")
    public Writer getById(@PathVariable @Min(1) @Param("{id}") Integer id){

        return  this.writerService.getByWriterId(id);
    }

    @PostMapping(value ="/createwriter")
    public Writer addWriter(@Valid @RequestBody Writer writer){
      return  this.writerService.addWriter(writer);
    }

    @PutMapping(value ="/updatewriter")
    public void updateWriter(@Valid @RequestBody Writer writer){
        this.writerService.updateWriter(writer);
    }

    @DeleteMapping(value ="/deletewriter/{id}")
    public boolean deleteWriter(@PathVariable @Min(1) @Param("{id}") Integer id){
        this.writerService.deleteWriter(id);
        return true;
    }





}
