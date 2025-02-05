package com.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roleId; // Primary Key

    @NotBlank(message = "Role Name is required")
    @Size(max = 50, message = "Role Name must be at most 50 characters")
    @Column(name = "role_name", length = 50, unique = true)
    private String roleName; // Role Name (e.g., User, Admin)

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserRole> userRoles; // One Role → Many UserRoles

    // Constructors
    public Role() {}

    public Role(String roleName) {
        this.roleName = roleName;
    }

    // Getters and Setters
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public String toString() {
        return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
    }
}
