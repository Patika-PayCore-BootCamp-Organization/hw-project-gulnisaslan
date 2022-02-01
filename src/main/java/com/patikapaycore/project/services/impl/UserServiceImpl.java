package com.patikapaycore.project.services.impl;

import com.patikapaycore.project.models.entities.User;
import com.patikapaycore.project.repositories.UserRepository;
import com.patikapaycore.project.services.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private  final UserRepository userRepository;

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
}
