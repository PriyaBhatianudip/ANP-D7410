package com.ecommerce.dao;

import com.ecommerce.entity.Product;
import com.ecommerce.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductDAO 
{
    public void save(Product product) 
    {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            tx = session.beginTransaction();
            session.persist(product);
            tx.commit();
        } catch (RuntimeException ex) {
            if (tx != null && tx.isActive()) tx.rollback();
            throw ex;
        }
    }

    public Product findById(Long id) 
    {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            return session.get(Product.class, id);
        }
    }

    public List<Product> findAll() 
    {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            return session.createQuery("from Product", Product.class).list();
        }
    }
    public void update(Product product)
    {
    	Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            tx = session.beginTransaction();
            session.merge(product);
            tx.commit();
            System.out.println("Product Updated Successfully!!");
        } catch (RuntimeException ex) {
            if (tx != null && tx.isActive()) tx.rollback();
            throw ex;
        }
    }
}
