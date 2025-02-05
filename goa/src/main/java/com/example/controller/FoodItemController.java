package com.example.controller;

import com.example.entity.FoodItem;
import com.example.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    // API endpoint for searching food items by name
    @GetMapping("/search-food")
    public List<FoodItem> searchFood(@RequestParam String name) {
        return foodItemService.searchFoodItems(name);
    }
}
