package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_roles") // Junction Table
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Many UserRoles → One User

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role; // Many UserRoles → One Role

    // Constructors
    public UserRole() {}

    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

//    @Override
//    public String toString() {
//        return "UserRole [id=" + id + ", user=" + user.getUsername() + ", role=" + role.getRoleName() + "]";
//    }
}
