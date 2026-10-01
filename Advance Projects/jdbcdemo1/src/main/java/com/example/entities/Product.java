package com.example.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor 
@ToString 
public class Product 
{
    private int productId;
    private String productName;
    private float costPrice;
    private float sellingPrice;
    private int qty;
}
