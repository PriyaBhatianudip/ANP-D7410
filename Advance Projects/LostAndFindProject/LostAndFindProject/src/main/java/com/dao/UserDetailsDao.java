package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.UserDetails;

public class UserDetailsDao 
{
	SessionFactory sf;
	
	public UserDetailsDao() 
	{
		sf= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}
	
	public void saveUser(UserDetails user)
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
	
	public UserDetails getUserById(int userId)
	{
		UserDetails user=null;
		try
		{
			Session session = sf.openSession();
			user = session.get(UserDetails.class, userId);
			session.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return user;
	}
}
