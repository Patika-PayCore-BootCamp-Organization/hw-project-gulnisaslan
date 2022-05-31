package com.patikapaycore.project.controllers;

import com.patikapaycore.project.models.entities.User;
import com.patikapaycore.project.services.abstracts.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;


@Validated
@RestController

@RequestMapping( "/api/users")
public class UsersController {
    private final UserService userService;


    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/getalluser")
    public List<User> getAll(){
        return this.userService.getAllUsers();

    }
//return allPassengers.stream().map(PASSENGER_MAPPER::toDto).collect(Collectors.toList());
    @GetMapping(value = "/getbyuserid/{id}")
    public User getById(@PathVariable @Min(1) @Param("{id}") Integer id){
        return this.userService.getByUserId(id);
    }

    @PostMapping(value = "/createuser",consumes ={"application/json"})
    public User add(@Valid @RequestBody   User user){
        return this.userService.addUser(user);
    }

    @PutMapping(value = "/updateuser",consumes ={"application/json"})
    public void update(@Valid @RequestBody User user){
        this.userService.updateUser(user);
    }

    @DeleteMapping(value = "/deleteuser/{id}")
    public boolean delete(@PathVariable @Min(1) @Param("{id}") Integer id){
        this.userService.deleteUser(id);
        return true;
    }

}
