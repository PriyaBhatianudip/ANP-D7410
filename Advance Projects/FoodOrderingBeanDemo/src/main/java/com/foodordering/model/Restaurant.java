package com.foodordering.model;

public class Restaurant {

    private String restaurantName;
    private String location;

    public Restaurant(String restaurantName, String location) {
        this.restaurantName = restaurantName;
        this.location = location;
    }

    public void displayRestaurant() {
        System.out.println("Restaurant: " + restaurantName);
        System.out.println("Location: " + location);
    }
}