package com.ecommerce;

import com.ecommerce.dao.ProductDAO;
import com.ecommerce.entity.Category;
import com.ecommerce.entity.Product;
import com.ecommerce.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class ProductMenu {

    private static final Scanner sc = new Scanner(System.in);
    private static final ProductDAO dao = new ProductDAO();

    public static void menu() 
    {
        int choice;

        do {
            System.out.println("\n===== PRODUCT MENU =====");
            System.out.println("1. Add Product");
            System.out.println("2. View Product by ID");
            System.out.println("3. View All Products");
            System.out.println("4. Update Product");
//            System.out.println("5. Delete Product");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = readInt();

            try {
                switch (choice) {
                    case 1 -> addProduct();
                    case 2 -> viewProduct();
                    case 3 -> viewAllProducts();
                    case 4 -> updateProduct();
//                    case 5 -> deleteProduct();
                    case 0 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice.");
                }
            } catch (RuntimeException ex) {
                System.out.println("Operation failed: " + ex.getMessage());
            }

        } while (choice != 0);

        sc.close();
        HibernateUtil.shutdown();
    }

    private static int readInt() 
    {
        while (!sc.hasNextInt()) 
        {
            System.out.print("Please enter a valid integer: ");
            sc.next();
        }
        int value = sc.nextInt();
        sc.nextLine();
        return value;
    }

    private static BigDecimal readPrice() {
        while (true) 
        {
            System.out.print("Enter price: ");
            try 
            {
                BigDecimal price = new BigDecimal(sc.nextLine().trim());
                if (price.signum() >= 0) 
                {
                    return price;
                }
            } catch (NumberFormatException ignored) {
                // Ask again below.
            }
            System.out.println("Enter a valid non-negative price.");
        }
    }

    private static void addProduct() {
        System.out.print("Enter product name: ");
        String name = sc.nextLine().trim();

        BigDecimal price = readPrice();

        System.out.print("Enter stock quantity: ");
        int stock = readInt();

        if (name.isEmpty() || stock < 0) {
            System.out.println("Name cannot be empty and stock cannot be negative.");
            return;
        }

        System.out.print("Enter existing category ID: ");
        long categoryId = readInt();

        Transaction tx = null;

        try (Session session =
                 HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            Category category =
                    session.get(Category.class, categoryId);

            if (category == null) {
                System.out.println("Category not found. Add a category first.");
                tx.rollback();
                return;
            }

            Product product = new Product(name, price, stock);
            product.setCategory(category);

            session.persist(product);
            tx.commit();

            System.out.println("Product added. ID: "
                    + product.getProductId());

        } catch (RuntimeException ex) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw ex;
        }
    }

    private static void viewProduct() {
        System.out.print("Enter product ID: ");
        long id = readInt();

        Product product = dao.findById(id);

        if (product != null) {
            System.out.println(product);
            System.out.println("Category: "
                    + product.getCategory().getCategoryName());
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void viewAllProducts() {
        List<Product> products = dao.findAll();

        if (products.isEmpty()) {
            System.out.println("No products found.");
            return;
        }

        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static void updateProduct() {
        System.out.print("Enter product ID to update: ");
        long id = readInt();

        Product product = dao.findById(id);

        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.print("Enter new product name: ");
        String name = sc.nextLine().trim();

        BigDecimal price = readPrice();

        System.out.print("Enter new stock quantity: ");
        int stock = readInt();

        if (name.isEmpty() || stock < 0) {
            System.out.println("Name cannot be empty and stock cannot be negative.");
            return;
        }

        product.setProductName(name);
        product.setPrice(price);
        product.setStock(stock);

        dao.update(product);
    }

    
}
