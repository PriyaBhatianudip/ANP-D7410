package com.example.entities;

import java.util.List;

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
public class Seller 
{
    private int sellerId;
    private String sellerName;
    private String companyName;
    private long phone;
    private List<String> productList;   
}
