package com.patikapaycore.project.services.abstracts;

import com.patikapaycore.project.models.entities.User;

import java.util.List;

public interface UserService {

        List<User> getAllUsers();

        User getByUserId(Integer id);

        User addUser(User user);

        void updateUser(User user);

        boolean deleteUser(Integer id);

        User findByUsername(String username);

        boolean existsByUsername(String username);

        void deleteByUsername(String username);


}
