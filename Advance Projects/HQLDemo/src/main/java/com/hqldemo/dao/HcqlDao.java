package com.hqldemo.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hqldemo.entity.Student;
import com.hqldemo.util.HibernateUtil;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

public class HcqlDao 
{
	static SessionFactory sf = HibernateUtil.getSessionFactory();
//	get all records
	public static List<Student> getRecords()
	{
		try(Session session =sf.openSession())
		{
			CriteriaBuilder cb= session.getCriteriaBuilder();
			
			CriteriaQuery<Student> cq = cb.createQuery(Student.class);
			Root<Student> root = cq.from(Student.class);
			
			root.fetch("department", JoinType.INNER); 
			cq.select(root);
			
			return session.createQuery(cq).getResultList();
			
		}
	}
	
//	get a record based on an id/ city/salary
	public static List<Student> getRecordsById(int id)
	{
		try(Session session =sf.openSession())
		{
			CriteriaBuilder cb= session.getCriteriaBuilder();
			
			CriteriaQuery<Student> cq = cb.createQuery(Student.class);
			Root<Student> root = cq.from(Student.class);
			
			root.fetch("department", JoinType.INNER); 
			
			cq.select(root).where(cb.equal(root.get("studentid"), id));
			
			return session.createQuery(cq).getResultList();
			
		}
	}
	
//	get records with age >=30
	public static List<Student> getRecordsByAge(int age)
	{
		try(Session session =sf.openSession())
		{
			CriteriaBuilder cb= session.getCriteriaBuilder();
			
			CriteriaQuery<Student> cq = cb.createQuery(Student.class);
			Root<Student> root = cq.from(Student.class);
			
			root.fetch("department", JoinType.INNER); 
			
			cq.select(root).where(cb.ge(root.get("age"), age));
			
			return session.createQuery(cq).getResultList();
			
		}
	}
	
	public static List<Student> getRecordsByMarks(int min, int max)
	{
		try(Session session =sf.openSession())
		{
			CriteriaBuilder cb= session.getCriteriaBuilder();
			
			CriteriaQuery<Student> cq = cb.createQuery(Student.class);
			Root<Student> root = cq.from(Student.class);
			
			root.fetch("department", JoinType.INNER); 
			
			cq.select(root).where(cb.between(root.get("marks"), min, max));
			
			return session.createQuery(cq).getResultList();
		}
	}
//	find the names with the given prefix 
//	find records with age greater than 18 and marks greater than 60.
	
	public static List<Student> getRecordsAscName()
	{
		try(Session session =sf.openSession())
		{
			CriteriaBuilder cb= session.getCriteriaBuilder();
			
			CriteriaQuery<Student> cq = cb.createQuery(Student.class);
			Root<Student> root = cq.from(Student.class);
			
			root.fetch("department", JoinType.INNER); 
			
			cq.select(root).orderBy(cb.asc(root.get("studentname")));
			
			return session.createQuery(cq).getResultList();
		}
	}
	
//	sorting using multiple fields
	public static List<Student> sortMultiplfields()
	{
		try(Session session =sf.openSession())
		{
			CriteriaBuilder cb= session.getCriteriaBuilder();
			
			CriteriaQuery<Student> cq = cb.createQuery(Student.class);
			Root<Student> root = cq.from(Student.class);
			
			root.fetch("department", JoinType.INNER); 
			
			cq.select(root).orderBy(cb.asc(root.get("studentname")), 
					cb.desc(root.get("age")));
			
			return session.createQuery(cq).getResultList();
		}
	}
	
	public static List<Student> paginatedRecords(int pageno, int pagesize)
	{
		try(Session session =sf.openSession())
		{
			CriteriaBuilder cb= session.getCriteriaBuilder();
			
			CriteriaQuery<Student> cq = cb.createQuery(Student.class);
			Root<Student> root = cq.from(Student.class);
			
			root.fetch("department", JoinType.INNER); 
			
			cq.select(root).orderBy(cb.asc(root.get("studentid")));
			
			return session.createQuery(cq)
					.setFirstResult((pageno-1)*pagesize)
					.setMaxResults(pagesize)
					.getResultList();
		}
	}
	public static void printRecords(List<Student> records)
	{
		records.stream().forEach(System.out::println);
	}
	
	
	
	public static void main(String[] args) 
	{
		List<Student> records = getRecords();
		
		for(Student s:records) System.out.println(s);
		
//		System.out.println("---------------Record By Id ------------------------");
		
		Scanner sc=new Scanner(System.in);
//		
//		System.out.print("Enter student id : ");
//		List<Student> record = getRecordsById(sc.nextInt());
//		
//		for(Student s:record) System.out.println(s);
//		
//		System.out.println("---------------Records By Age ------------------------");
//		
//		System.out.print("Enter minimum age limit : ");
//		List<Student> record = getRecordsByAge(sc.nextInt());
//		record.stream().forEach(System.out::println);
//		
//		
//		System.out.println("---------------Records By Marks ------------------------");
//		System.out.println("Enter minimum and maximum marks : ");
//		List<Student> record = getRecordsByMarks(sc.nextInt(), sc.nextInt());
//		printRecords(record);
		
//		printRecords(getRecordsAscName());
//		printRecords(sortMultiplfields());
//		
		System.err.println("Page 1");
		printRecords(paginatedRecords(1, 4));
		
		System.err.println("Page 2");
		printRecords(paginatedRecords(2, 4));
		
		System.err.println("Page 3");
		printRecords(paginatedRecords(3, 4));
	}
}
