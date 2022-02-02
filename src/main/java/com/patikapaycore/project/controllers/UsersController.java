package com.patikapaycore.project.controllers;

import com.patikapaycore.project.models.entities.User;
import com.patikapaycore.project.services.abstracts.UserService;
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
@RequestMapping(name = "/api/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/getalluser")
    public List<User> getAll(){
        return this.userService.getAllUsers();
    }

    @GetMapping(value = "/getbyuserid/{id}")
    public User getById(@PathVariable @Min(1) @Param("{id}") Integer id){
        return this.userService.getByUserId(id);
    }

    @PostMapping(value = "/createuser")
    public User add(@Valid @RequestBody   User user){
        return this.userService.addUser(user);
    }

    @PutMapping(value = "/updateuser")
    public void update(@Valid @RequestBody User user){
        this.userService.updateUser(user);
    }

    @DeleteMapping(value = "/deleteuser/{id}")
    public boolean delete(@PathVariable @Min(1) @Param("{id}") Integer id){
        this.userService.deleteUser(id);
        return true;
    }

}
