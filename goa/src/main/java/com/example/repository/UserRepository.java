package com.example.repository;

import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    // Custom query method to find user by email
    User findByEmail(String email);
}



