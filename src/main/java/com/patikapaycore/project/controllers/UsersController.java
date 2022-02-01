package com.patikapaycore.project.controllers;

import com.patikapaycore.project.models.entities.User;
import com.patikapaycore.project.services.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Validated
@RestController
@RequestMapping(name = "/api/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping(name = "/getAll")
    public List<User> getAll(){
        return this.userService.getAllUsers();
    }

    @GetMapping(name = "/{id}")
    public User getById(@PathVariable Integer id){
        return this.userService.getByUserId(id);
    }

    @PostMapping(name = "/create")
    public User add(@Valid @RequestBody User user){
        return this.userService.addUser(user);
    }

    @PutMapping(name = "/update")
    public void update(@Valid @RequestBody User user){
        this.userService.updateUser(user);
    }

    @DeleteMapping(name = "/delete/{id}")
    public boolean delete(@PathVariable  Integer id){
        this.userService.deleteUser(id);
        return true;
    }

}
