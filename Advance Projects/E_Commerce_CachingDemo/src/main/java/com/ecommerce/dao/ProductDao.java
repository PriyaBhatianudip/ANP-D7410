package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ecommerce.dto.ProductDto;
import com.ecommerce.entity.Product;
import com.ecommerce.util.HibernateUtil;

public class ProductDao {

    private SessionFactory factory =
            HibernateUtil.getFactory();

    public List<ProductDto> getAllProducts() {

        try (Session session = factory.openSession()) {

            List<Product> products =
                session.createQuery(
                    "SELECT p FROM Product p JOIN FETCH p.category",
                    Product.class
                ).getResultList();

            return products.stream()
                .map(p -> new ProductDto(
                    p.getProductId(),
                    p.getProductName(),
                    p.getPrice(),
                    p.getCategory().getCategoryName()
                ))
                .toList();
        }
    }
}