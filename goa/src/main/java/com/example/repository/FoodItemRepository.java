package com.example.repository;

import com.example.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface FoodItemRepository extends JpaRepository<FoodItem, Integer> {

    // Custom query to search food items by name
    @Query("SELECT f FROM FoodItem f WHERE f.name LIKE %?1%")
    List<FoodItem> searchFoodItemsByName(String name);
}
