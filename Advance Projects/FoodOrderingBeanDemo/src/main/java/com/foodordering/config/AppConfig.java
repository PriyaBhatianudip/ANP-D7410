package com.foodordering.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.foodordering.model.Restaurant;

@Configuration
@ComponentScan(basePackages = "com.foodapp")
public class AppConfig {

    @Bean
    public Restaurant restaurant() {

        return new Restaurant(
            "Food Paradise",
            "Gurugram"
        );
    }
}