package com.example.service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;


@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    // Password encoding
    public String encodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    // User registration
    @Transactional
    public void registerUser(User user, String confirmPassword) {
        if (!user.getPlainPassword().equals(confirmPassword)) {
            throw new IllegalArgumentException("Passwords do not match");
        }

        // Encode the password and set it in the passwordHash field
        String encodedPassword = passwordEncoder.encode(user.getPlainPassword());
        user.setPasswordHash(encodedPassword);
        user.setPlainPassword(null); // Clear plain password for security

        // Save the user to the database
        userRepository.save(user);
    }

    // User login authentication
    public String login(String email, String plainPassword) {
        // Fetch user by email
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        // Check if password matches
        if (!passwordEncoder.matches(plainPassword, user.getPasswordHash())) {
            throw new BadCredentialsException("Invalid password for user: " + email);
        }

        return "Login successful for user: " + email;
    }
}
