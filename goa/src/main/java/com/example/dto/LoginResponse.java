package com.example.dto;

public class LoginResponse {
    private Integer id;
    private String name;
    private String email;
    private String token;

    public LoginResponse(Integer integer, String name, String email, String token) {
        this.id = integer;
        this.name = name;
        this.email = email;
        this.token = token;
    }

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
}
