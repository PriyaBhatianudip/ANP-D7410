package com.ecommerce.dto;

public record ProductDto(
        int productId,
        String productName,
        double price,
        String categoryName
) {
}