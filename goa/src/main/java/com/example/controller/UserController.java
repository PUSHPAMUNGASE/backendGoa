


package com.example.controller;

import com.example.dto.UserRegistrationRequest;
import com.example.entity.User;
import com.example.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    // User Registration Endpoint
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationRequest registrationRequest) {
        try {
            // Log the registration request for debugging
            System.out.println("Received registration request: " + registrationRequest);

            // Check if passwords match
            if (!registrationRequest.getPlainPassword().equals(registrationRequest.getConfirmPassword())) {
                throw new IllegalArgumentException("Passwords do not match");
            }

            // Convert DTO to User entity
            User user = new User();
            user.setName(registrationRequest.getName());
            user.setEmail(registrationRequest.getEmail());
            user.setPlainPassword(registrationRequest.getPlainPassword()); // Set the plain password for hashing

            // Register the user
            userService.registerUser(user, registrationRequest.getConfirmPassword());

            return ResponseEntity.ok("User registered successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage()); // Return error if passwords don't match
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred during registration");
        }
    }

    // User Login Endpoint
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        try {
            String email = user.getEmail();
            String password = user.getPlainPassword(); 

            String loginMessage = userService.login(email, password);
            Map<String, Object> response = Map.of(
                "message", loginMessage,
                "user", user
            );

            return ResponseEntity.ok(response);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(401).body(Map.of("message", ex.getMessage()));
        } catch (Exception ex) {
            return ResponseEntity.status(500).body(Map.of("message", "An error occurred during login"));
        }
    }
}

