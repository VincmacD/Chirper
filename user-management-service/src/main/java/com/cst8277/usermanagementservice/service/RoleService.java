package com.cst8277.usermanagementservice.service;
import com.cst8277.usermanagementservice.entity.Role;
import com.cst8277.usermanagementservice.entity.User;
import com.cst8277.usermanagementservice.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    public Role findByIdCustom(UUID id) {
        return roleRepository.findByIdCustom(id);
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Transactional
    public Optional<Role> deleteById(UUID id) {
        Optional<Role> role = roleRepository.findById(id);
        role.ifPresent(roleRepository::delete);
        return role;
    }

    @Transactional
    public Optional<Role> updateRole(UUID id, @RequestBody Role updatedRole) {
        Optional<Role> existingRole = roleRepository.findById(id);
        if (existingRole.isPresent()) {
            Role role = existingRole.get();
            role.setName(updatedRole.getName());
            role.setDescription(updatedRole.getDescription());
            roleRepository.save(role);
        }
        return existingRole;
    }
}
