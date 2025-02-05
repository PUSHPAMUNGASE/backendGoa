package com.example.service;

import com.example.entity.FoodItem;
import com.example.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FoodItemService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    // Method to search food items by name
    public List<FoodItem> searchFoodItems(String name) {
        return foodItemRepository.searchFoodItemsByName(name);
    }
}
