package com.patikapaycore.project.services.impl;

import com.patikapaycore.project.models.entities.Role;
import com.patikapaycore.project.repositories.RoleRepository;
import com.patikapaycore.project.services.abstracts.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private  final RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return  this.roleRepository.findAll();
    }

    @Override
    public Role getById(Integer id) {
        return this.roleRepository.getById(id);
    }

    @Override
    public Role addRole(Role role) {
        return this.roleRepository.save(role);
    }

    @Override
    public void updateRole(Role role) {
        this.roleRepository.save(role);
    }

    @Override
    public boolean deleteRole(Integer id) {
        Role byId = this.roleRepository.getById(id);
        roleRepository.delete(byId);

        return true;
    }
}
