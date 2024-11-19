package com.example.example.repo;

import com.example.example.entitiy.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> { // Change Long to String for userId
    UserEntity findByUsername(String username);
    UserEntity findByEmail(String email); // Optional: find by email if needed
}
