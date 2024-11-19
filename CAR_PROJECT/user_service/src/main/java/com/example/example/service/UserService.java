package com.example.example.service;

import com.example.example.entitiy.UserEntity;
import com.example.example.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username); // Fetch user by username
    }

    public boolean validatePassword(String rawPassword, String hashedPassword) {
        return rawPassword.equals(hashedPassword); // Compare raw and hashed passwords
    }
    public boolean userExists(String username) {
        return userRepository.findByUsername(username) != null; // Returns true if user exists
    }

    // Method to save a new user
    public void saveUser(String username, String password, String address, String email, String roles) {
        UserEntity user = new UserEntity();
        user.setUserId(UUID.randomUUID().toString()); // Generate a unique userId
        user.setUsername(username);
        user.setPassword(password); // Hash the password before saving
        user.setAddress(address);
        user.setEmail(email);
        user.setRoles(roles); // Set roles (e.g., "ROLE_USER")
        userRepository.save(user);
    }


}
