package com.foodordering.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.foodordering.model.FoodItem;
import com.foodordering.model.Restaurant;

@Service
public class FoodService {

    private final List<FoodItem> foodItems = new ArrayList<>();

    private final Restaurant restaurant;

    public FoodService(Restaurant restaurant) {

        this.restaurant = restaurant;

        foodItems.add(new FoodItem(1, "Pizza", 250));
        foodItems.add(new FoodItem(2, "Burger", 150));
        foodItems.add(new FoodItem(3, "Pasta", 200));
        foodItems.add(new FoodItem(4, "Sandwich", 100));
    }

    public void displayRestaurant() {
        restaurant.displayRestaurant();
    }

    public void displayFoodItems() {

        System.out.println("\nAvailable Food Items");
        System.out.println("--------------------");

        for (FoodItem food : foodItems) {
            System.out.println(food);
        }
    }

    public FoodItem getFoodItem(int id) {

        for (FoodItem food : foodItems) {
            if (food.getFoodId() == id) {
                return food;
            }
        }

        return null;
    }
}