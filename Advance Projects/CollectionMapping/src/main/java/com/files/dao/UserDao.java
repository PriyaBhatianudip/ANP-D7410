package com.files.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.files.entity.User;

public class UserDao 
{
SessionFactory sf;
	
	public UserDao() 
	{
		sf= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}
	
	public void saveUser(User user)
	{
		try
		{
			Session session = sf.openSession();
			Transaction tr= session.beginTransaction();
			
			Object status = session.save(user);
			tr.commit();
			System.out.println("Record Saved Successfully!!"+status);
			session.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public User getUserById(int userId)
	{
		User user=null;
		try
		{
			Session session = sf.openSession();
			user = session.get(User.class, userId);
			session.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return user;
	}
}
