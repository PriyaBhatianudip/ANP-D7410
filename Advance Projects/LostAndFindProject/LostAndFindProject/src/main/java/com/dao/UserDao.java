package com.dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.User;

public class UserDao 
{
	SessionFactory sf;
	
	public UserDao() 
	{
		sf= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}
	
	public Object registerUser(User user)
	{
		Session session = sf.openSession();
		Transaction tx =session.beginTransaction();
		
		Object save = session.save(user);
		tx.commit();
		System.out.println("Save Status : "+save);
		
		session.close();
		return save;
	}
	public User getUser(int userid)
	{
		Session session = sf.openSession();
		
		User user = session.get(User.class, userid);
		
		session.close();
		return user;	
	}
	
	public void updateUser(int userid)
	{
		Session session = sf.openSession();
		User user = session.get(User.class, userid);
		if(user!=null)
		{
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter New Password : ");
			user.setPassword(sc.nextLine());
			
			System.out.println("Enter new Email id : ");
			user.setEmail(sc.nextLine());
			
			Transaction tx =session.beginTransaction();
			Object ob = session.save(user);
			System.out.println("User Updation "+ob);
			tx.commit();
		}
		
		session.close();		
	}
	
	public void deleteUser(int userId)
	{
		Session session = sf.openSession();
		User user = session.get(User.class, userId);
		if(user!=null)
		{
		Transaction tx =session.beginTransaction();
		System.out.println("Removing record now");
		session.remove(user);
		System.out.println("User Deleted successfully ");
		tx.commit();
		}
		session.close();		
	}
	
}
