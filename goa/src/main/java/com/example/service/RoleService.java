package com.example.service;

import com.example.entity.Role;
import com.example.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    // Create a new role only if it does not exist
    public Role createRole(String roleName) {
        Optional<Role> existingRole = roleRepository.findByRoleName(roleName);
        if (existingRole.isPresent()) {
            throw new IllegalArgumentException("Role already exists");
        }
        Role role = new Role(roleName);
        return roleRepository.save(role);
    }

    // Fetch role by name
    public Optional<Role> getRoleByName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}

