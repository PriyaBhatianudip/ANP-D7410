package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Item;

// Dao class is used for performing database, table specific operations.
public class ItemDao 
{
	SessionFactory sf;
	
	public ItemDao() 
	{
		sf= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}
	
	public void addItem(Item item)
	{
		Session session = sf.openSession();
		Transaction tx =session.beginTransaction();
		
		Object save = session.save(item);
		tx.commit();
		System.out.println("Save Status : "+save);
		
		session.close();
	}
	
}
