package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Fixed annotation
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String contact;

    // Default Constructor
    public Hotel() {}

    // Parameterized Constructor
    public Hotel(String name, String location, String contact) {
        this.name = name;
        this.location = location;
        this.contact = contact;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    // toString() method for debugging
    @Override
    public String toString() {
        return "Hotel [id=" + id + ", name=" + name + ", location=" + location + ", contact=" + contact + "]";
    }
}
