package com.example.dto;

public class UserRegistrationRequest {
    private String name;
    private String email;
    private String plainPassword;
    private String confirmPassword;

    // Constructors
    public UserRegistrationRequest() {}

    public UserRegistrationRequest(String name, String email, String plainPassword, String confirmPassword) {
        this.name = name;
        this.email = email;
        this.plainPassword = plainPassword;
        this.confirmPassword = confirmPassword;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPlainPassword() {
        return plainPassword;
    }

    public void setPlainPassword(String plainPassword) {
        this.plainPassword = plainPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    // Validation for password matching
    public boolean isPasswordMatching() {
        return this.plainPassword != null && this.plainPassword.equals(this.confirmPassword);
    }
}
