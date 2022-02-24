package com.patikapaycore.project.repositories;

import com.patikapaycore.project.models.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
}
