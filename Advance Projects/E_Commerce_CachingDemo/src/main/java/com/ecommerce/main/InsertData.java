package com.ecommerce.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ecommerce.entity.Category;
import com.ecommerce.entity.Product;
import com.ecommerce.util.HibernateUtil;

public class InsertData {

    public static void main(String[] args) {

        SessionFactory factory =
                HibernateUtil.getFactory();

        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        Category electronics = new Category("Electronics");
        Category clothing = new Category("Clothing");
        Category books = new Category("Books");
        Category appliances = new Category("Home Appliances");

        session.persist(electronics);
        session.persist(clothing);
        session.persist(books);
        session.persist(appliances);

        session.persist(new Product("Laptop", 65000, electronics));
        session.persist(new Product("Mobile", 25000, electronics));
        session.persist(new Product("Headphones", 2500, electronics));

        session.persist(new Product("T-Shirt", 799, clothing));
        session.persist(new Product("Jeans", 1499, clothing));

        session.persist(new Product("Java Book", 599, books));

        session.persist(new Product("Mixer Grinder", 3500, appliances));

        tx.commit();

        session.close();

        HibernateUtil.shutdown();

        System.out.println("Sample data inserted successfully!");
    }
}