package com.patikapaycore.project.controllers.repositories;

import com.patikapaycore.project.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUsername(String username);
    boolean existsByUsername(String username);
    void deleteByUsername(String username);
}
