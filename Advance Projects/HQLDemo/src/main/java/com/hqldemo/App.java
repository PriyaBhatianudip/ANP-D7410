package com.hqldemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hqldemo.dao.StudentDao;
import com.hqldemo.entity.Department;
import com.hqldemo.entity.Student;
import com.hqldemo.util.HibernateUtil;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	Transaction tx = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            tx = session.beginTransaction();
//
//            // Avoid duplicate seed data when this class is run more than once.
//            Long count = session.createQuery("select count(s) from Student s", Long.class)
//                    .getSingleResult();
//            if (count > 0) {
//                System.out.println("Seed data already exists. No new records inserted.");
//                tx.commit();
//                return;
//            }
//
////            set up departments
//            Department computer = new Department("Computer Science");
//            Department business = new Department("Business");
//            Department data = new Department("Data Analytics");
//            session.persist(computer);
//            session.persist(business);
//            session.persist(data);
////
////            set up student records
//            session.persist(new Student("Aarav", 21, 88, "Delhi", computer));
//            session.persist(new Student("Diya", 22, 76, "Noida", computer));
//            session.persist(new Student("Kabir", 20, 91, "Gurgaon", data));
//            session.persist(new Student("Meera", 23, 67, "Delhi", business));
//            session.persist(new Student("Ishaan", 21, 54, "Noida", computer));
//            session.persist(new Student("Anaya", 22, 82, "Gurgaon", data));
//            session.persist(new Student("Reyansh", 24, 39, "Delhi", business));
//            session.persist(new Student("Sara", 20, 73, "Jaipur", business));
//            tx.commit();
//            System.out.println("Sample departments and students inserted successfully.");
//        
        
        	StudentDao sdao = new StudentDao();
//        	List<Student> records = sdao.getRecords();
        	
//        	for(Student s: records)
//        	{
//        		System.out.println("Student id : "+s.getStudentid());
//        		System.out.println("Name : "+s.getStudentname());
//        		System.out.println("Age : "+s.getAge());
////        		System.out.println("Department id "+s.getDepartment().getDeptname());
//        	}
        	
        	sdao.getStudentMarks();
//        } catch (Exception e) {
//            if (tx != null && tx.isActive()) tx.rollback();
//            e.printStackTrace();
//        } finally {
//            HibernateUtil.shutdown();
//        }
    }
}
