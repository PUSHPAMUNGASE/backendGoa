package com.example.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "password_reset_tokens")
public class PasswordResetToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary Key

    @Column(nullable = false, unique = true)
    private String token; // Unique Reset Token

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false) // Foreign Key to 'users' table
    private User user; // Foreign Key to User Table

    @Column(nullable = false)
    private LocalDateTime expiryDate; // Token Expiry Time

    // Constructors
    public PasswordResetToken() {}

    public PasswordResetToken(User user) {
        this.token = UUID.randomUUID().toString(); // Generate Unique Token
        this.user = user;
        this.expiryDate = LocalDateTime.now().plusMinutes(30); // Expires in 30 mins
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }
}
