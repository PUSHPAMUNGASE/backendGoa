package com.example.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Set;


@Entity
@Table(name = "food_items")
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FoodType type;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToMany(mappedBy = "foodItems")
    private Set<Restaurant> restaurants;

    // Default Constructor
    public FoodItem() {}

    // Parameterized Constructor
    public FoodItem(String name, FoodType type, BigDecimal price, Set<Restaurant> restaurants) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.restaurants = restaurants;
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

    public FoodType getType() {
        return type;
    }

    public void setType(FoodType type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(Set<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    // toString() method for debugging
    @Override
    public String toString() {
        return "FoodItem [id=" + id + ", name=" + name + ", type=" + type + ", price=" + price + "]";
    }
}
