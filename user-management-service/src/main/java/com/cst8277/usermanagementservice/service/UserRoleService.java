package com.cst8277.usermanagementservice.service;


import com.cst8277.usermanagementservice.entity.Role;

import com.cst8277.usermanagementservice.entity.UserRole;

import com.cst8277.usermanagementservice.entity.UserRoleId;
import com.cst8277.usermanagementservice.repository.UserRoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    public List<UserRole> findByIdCustom(UUID user_id) {
        return userRoleRepository.findByIdCustom(user_id);
    }

    @Transactional
    public UserRole saveUserRole(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    public List<UserRole> findAll() {
        return userRoleRepository.findAll();
    }

    @Transactional
    public UserRole deleteUserRole(UUID user_id, UUID role_id) {
        UserRoleId userRoleId = new UserRoleId(user_id, role_id);
        UserRole userRole = new UserRole(userRoleId);
        userRoleRepository.delete(userRole);
        return userRole;
    }
}


