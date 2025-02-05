package com.example.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String contact;

    @ManyToMany
    @JoinTable(
        name = "food_restaurant",
        joinColumns = @JoinColumn(name = "restaurant_id"),
        inverseJoinColumns = @JoinColumn(name = "food_id")
    )
    private Set<FoodItem> foodItems;

    // Default Constructor
    public Restaurant() {}

    // Parameterized Constructor
    public Restaurant(String name, String location, String contact, Set<FoodItem> foodItems) {
        this.name = name;
        this.location = location;
        this.contact = contact;
        this.foodItems = foodItems;
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

    public Set<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(Set<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }

    // toString() method for debugging
    @Override
    public String toString() {
        return "Restaurant [id=" + id + ", name=" + name + ", location=" + location + ", contact=" + contact + "]";
    }
}
