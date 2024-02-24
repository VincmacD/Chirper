package com.cst8277.usermanagementservice.service;

import com.cst8277.usermanagementservice.entity.User;
import com.cst8277.usermanagementservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findByIdCustom(UUID id) {
        return userRepository.findByIdCustom(id);
    }

    @Transactional
    public Optional<User> deleteById(UUID id) {
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(userRepository::delete);
        return user;
    }

    @Transactional
    public Optional<User> updateUser(UUID id, @RequestBody User updatedUser) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            // Update the user fields with the values from the updatedUser
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            // Save the updated user
            userRepository.save(user);
        }
        return existingUser;
    }
}
