package com.example.controller;

import com.example.entity.Restaurant;
import com.example.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
@CrossOrigin(origins = "http://localhost:3000") // Adjust frontend URL if needed
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    // Get all restaurants
    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        return ResponseEntity.ok(restaurantService.getAllRestaurants());
    }

    // Get restaurant by ID
    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable int id) {
        Optional<Restaurant> restaurant = restaurantService.getRestaurantById(id);
        return restaurant.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add a new restaurant
    @PostMapping
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) {
        return ResponseEntity.ok(restaurantService.addRestaurant(restaurant));
    }

    // Update restaurant by ID
    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable int id, @RequestBody Restaurant updatedRestaurant) {
        return ResponseEntity.ok(restaurantService.updateRestaurant(id, updatedRestaurant));
    }

    // Delete restaurant by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable int id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.noContent().build();
    }

    // Search restaurants by name or location
    @GetMapping("/search")
    public ResponseEntity<List<Restaurant>> searchRestaurants(@RequestParam String keyword) {
        return ResponseEntity.ok(restaurantService.searchRestaurants(keyword));
    }
}
