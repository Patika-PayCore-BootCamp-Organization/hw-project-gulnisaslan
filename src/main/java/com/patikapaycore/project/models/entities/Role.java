package com.patikapaycore.project.models.entities;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Data
@Entity
@Table(name="roles")

public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="role_name")
    private String role_name;
    @Override
    public String getAuthority() {
        return role_name;
    }
}
