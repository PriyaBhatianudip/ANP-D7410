package com.employeemgt;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.employeemgt.entities.Employee;

/**
 * Hello world!
 */
public class App 
{
    public static void main(String[] args) {
       SessionFactory sf = new Configuration()
    		   .configure("hibernate.cfg.xml").buildSessionFactory();
       
       System.out.println("Session Factory Initialized...");
       
       Session session = sf.openSession();
       System.out.println("Session is Active!!");
       
       Transaction tr= session.beginTransaction();
//       
//       Employee emp=new Employee();
//       emp.setName("mm");
//       emp.setCity("Delhi");
//       emp.setSalary(56000);
//       
//       // to save the record
//       Object id= session.save(emp);
//       System.out.println("Object : "+id);
//       tr.commit();
//       System.out.println("Employee record saved successfully!!");
       
//       to find the record 
//       Employee e = session.get(Employee.class, 1);
//       System.out.println("Employee record : "+e);
       
//       update operation
//       Employee e = session.find(Employee.class, 1);
//       if(e!=null)
//       {
////    	   set new salary
//    	   e.setSalary(90000);
//       }
       
//       delete operation
       Employee e = session.find(Employee.class, 1);
       if(e!=null) 
    	   session.remove(e);
       tr.commit();
       
       session.close();
    }
}
