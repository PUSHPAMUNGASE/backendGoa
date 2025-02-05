package com.example.repository;

import com.example.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    // Search restaurants by name or location
    @Query("SELECT r FROM Restaurant r WHERE LOWER(r.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(r.location) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Restaurant> searchRestaurants(@Param("keyword") String keyword);
}
