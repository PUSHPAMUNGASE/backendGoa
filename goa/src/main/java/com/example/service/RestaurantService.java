package com.example.service;

import com.example.entity.Restaurant;
import com.example.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    // Get all restaurants
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    // Get restaurant by ID
    public Optional<Restaurant> getRestaurantById(int id) {
        return restaurantRepository.findById(id);
    }

    // Add a new restaurant
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    // Update an existing restaurant
    public Restaurant updateRestaurant(int id, Restaurant updatedRestaurant) {
        return restaurantRepository.findById(id)
            .map(restaurant -> {
                restaurant.setName(updatedRestaurant.getName());
                restaurant.setLocation(updatedRestaurant.getLocation());
                restaurant.setContact(updatedRestaurant.getContact());
                restaurant.setFoodItems(updatedRestaurant.getFoodItems());
                return restaurantRepository.save(restaurant);
            })
            .orElseThrow(() -> new RuntimeException("Restaurant not found with ID: " + id));
    }

    // Delete a restaurant
    public void deleteRestaurant(int id) {
        restaurantRepository.deleteById(id);
    }

    // Search restaurants by keyword (name or location)
    public List<Restaurant> searchRestaurants(String keyword) {
        return restaurantRepository.searchRestaurants(keyword);
    }
}
