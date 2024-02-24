package com.cst8277.usermanagementservice.controller;


import com.cst8277.usermanagementservice.entity.User;
import com.cst8277.usermanagementservice.entity.UserRole;
import com.cst8277.usermanagementservice.handler.CustomErrorResponse;
import com.cst8277.usermanagementservice.handler.CustomException;
import com.cst8277.usermanagementservice.service.UserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/ums/user-roles")
public class UserRoleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRoleController.class);

    @Autowired
    private UserRoleService userRoleService;

    @PostMapping("/")
    public UserRole saveUserRole(@RequestBody UserRole userRole) {
        LOGGER.info("UserRole add: {}", userRole);
        return userRoleService.saveUserRole(userRole);
    }

    @GetMapping("/")
    public List<UserRole> findAll(){
        LOGGER.info("UserRole List");
        return userRoleService.findAll();

    }
    @GetMapping("/id/{user_id}")
    public ResponseEntity<Object> findByIdCustom(@PathVariable("user_id") String user_id) {
        LOGGER.info("User find: {}", user_id);
        UUID userId;
        try {
            userId = UUID.fromString(user_id);
        } catch (IllegalArgumentException e) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "Invalid user UUID");
        }
        List<UserRole> userRole = userRoleService.findByIdCustom(userId);
        if (userRole != null &&  userRole.isEmpty()) {
            throw new CustomException(HttpStatus.NOT_FOUND, "User role's not found or doesn't exist");
        }
        CustomErrorResponse response = new CustomErrorResponse
                (Integer.toString(HttpStatus.OK.value()), userRole, "User role's successfully retrieved");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/id2/{user_id}")
    public List<UserRole> findByIdCustom2(@PathVariable("user_id") UUID user_id) {
        return userRoleService.findByIdCustom(user_id);
    }

    @DeleteMapping("/user/{user_id}/role/{role_id}")
    public UserRole deleteUserRole(@PathVariable("user_id") UUID user_id, @PathVariable("role_id") UUID role_id) {
        LOGGER.info("UserRole delete: user_id={}, role_id={}", user_id, role_id);
        return userRoleService.deleteUserRole(user_id, role_id);
    }
}

