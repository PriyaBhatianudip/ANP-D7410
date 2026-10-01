package com.example;

import com.example.dao.ProductDao;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) 
    {
        ProductDao dao =new ProductDao();
        dao.showProducts();

    }
}
