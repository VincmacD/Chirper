package com.cst8277.usermanagementservice.controller;

import com.cst8277.usermanagementservice.entity.User;
import com.cst8277.usermanagementservice.handler.CustomErrorResponse;
import com.cst8277.usermanagementservice.handler.CustomException;
import com.cst8277.usermanagementservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/api/v1/ums/users")
public class UserController {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    //Add user
    @PostMapping("/")
    public ResponseEntity<Object> saveUser(@RequestBody User user) {
        LOGGER.info("User add: {}", user);
        User user2 = userService.saveUser(user);
        CustomErrorResponse response = new CustomErrorResponse
                (Integer.toString(HttpStatus.OK.value()), user2, "User successfully added");
        return ResponseEntity.ok(response);    }

    //Find user by name
    @GetMapping("/name/{name}")
    public User findByName(@PathVariable("name") String name){
        LOGGER.info("User find: {}", name);
        return userService.findByName(name);
    }
    //Find user by user Id

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> findByIdCustom(@PathVariable("id") String id) {
        LOGGER.info("User find: {}", id);
        UUID userId;
        try {
            userId = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "Invalid user UUID");
        }
        User user = userService.findByIdCustom(userId);
        if (user == null) {
            throw new CustomException(HttpStatus.NOT_FOUND, "User not found or doesn't exist");
        }
        CustomErrorResponse response = new CustomErrorResponse
                (Integer.toString(HttpStatus.OK.value()), user, "User successfully retrieved");
        return ResponseEntity.ok(response);
    }

    //Find all users
    @GetMapping("/")
    public ResponseEntity<Object> findAll(){
        LOGGER.info("Find all users");
        List<User> users = userService.findAllUsers();
        CustomErrorResponse response = new CustomErrorResponse
                (Integer.toString(HttpStatus.OK.value()), users, "All users successfully retrieved");
        return ResponseEntity.ok(response);
    }
    //Delete user
    @DeleteMapping("/delete/{id}")
    public Optional<User> deleteById(@PathVariable("id") UUID id) {
        LOGGER.info("User delete: {}", id);
        return userService.deleteById(id);
    }
    @PutMapping("/update/{id}")
    public Optional<User> updateUser(@PathVariable("id") UUID id, @RequestBody User updatedUser) {
        LOGGER.info("User updated: {}", id);
        return userService.updateUser(id, updatedUser);
    }
}
