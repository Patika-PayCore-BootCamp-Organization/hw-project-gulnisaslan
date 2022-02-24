package com.patikapaycore.project.services.abstracts;

import com.patikapaycore.project.models.entities.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    Role getById(Integer id);
    Role addRole(Role role);
    void  updateRole(Role role);
    boolean deleteRole(Integer id);
}
