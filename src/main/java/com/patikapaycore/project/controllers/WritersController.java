package com.patikapaycore.project.controllers;

import com.patikapaycore.project.models.entities.Writer;
import com.patikapaycore.project.services.abstracts.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
@RequestMapping( "/api/writers")
public class WritersController {


    private final WriterService writerService;

    @Autowired
    public WritersController(WriterService writerService) {
        this.writerService = writerService;
    }


    @GetMapping(value ="getallwriter")
    public List<Writer> getAll(){
        return this.writerService.getAllWriter();
    }
    @GetMapping(value ="/getbywriterid/{id}")
    public Writer getById(@PathVariable @Min(1) @Param("{id}") Integer id){

        return  this.writerService.getByWriterId(id);
    }

    @PostMapping(value ="/createwriter",consumes ={"application/json"})
    public Writer addWriter(@Valid @RequestBody Writer writer){
      return  this.writerService.addWriter(writer);
    }

    @PutMapping(value ="/updatewriter",consumes ={"application/json"})
    public void updateWriter(@Valid @RequestBody Writer writer){
        this.writerService.updateWriter(writer);
    }

    @DeleteMapping(value ="/deletewriter/{id}")
    public boolean deleteWriter(@PathVariable @Min(1) @Param("{id}") Integer id){
        this.writerService.deleteWriter(id);
        return true;
    }





}
