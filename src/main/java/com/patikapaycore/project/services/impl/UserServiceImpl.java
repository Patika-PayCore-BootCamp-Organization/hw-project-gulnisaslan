package com.patikapaycore.project.services.impl;

import com.patikapaycore.project.models.entities.User;
import com.patikapaycore.project.controllers.repositories.UserRepository;
import com.patikapaycore.project.services.abstracts.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final  UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User getByUserId(Integer id) {
        return this.userRepository.getById(id);
    }

    @Override
    public User addUser(User user) {

        return this.userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        this.userRepository.save(user);
    }

    @Override
    public boolean deleteUser(Integer id) {
        User byId = this.userRepository.getById(id);
        this.userRepository.delete(byId);
        return true;
    }

    @Override
    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public boolean existsByUsername(String username) {

        return this.userRepository.existsByUsername(username);
    }

    @Override
    public void deleteByUsername(String username) {
        this.userRepository.deleteByUsername(username);

    }


}
