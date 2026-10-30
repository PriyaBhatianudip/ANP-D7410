package com.hqldemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.hqldemo.entity.Student;
import com.hqldemo.util.HibernateUtil;

public class StudentDao1 
{
	public static SessionFactory sf = HibernateUtil.getSessionFactory();	
	public List<Student> getRecordsByCity(String city)
	{
		try(Session session= sf.openSession())
		{
			Query<Student> query = session.createNamedQuery("Student.findByCity",
					Student.class);
			query.setParameter("city", city);
			return query.list();
			
		}
	}
	
	public List<Student> getRecordsByName(String name)
	{
		try(Session session= sf.openSession())
		{
			Query<Student> query = session.createNamedQuery("Student.findByName",
					Student.class);
			query.setParameter("sname", name);
			return query.list();
			
		}
	}
	
//	native query
	public List<Student> getRecordsAge(int minage, int maxage)
	{
		try(Session session= sf.openSession())
		{
			String sql = "select s.* from students s left join departments d on s.deptid=d.deptid "
					+ "where s.age >=:minage and s.age<=:maxage";
			NativeQuery<Student> query = session.createNativeQuery(sql, Student.class);
			query.setParameter("minage", minage);
			query.setParameter("maxage", maxage);
			
			return query.list();
		}
	}
	public List<Student> getRecordsByAge(int age)
	{
		try(Session session= sf.openSession())
		{
			Query<Student> query = session.createNamedQuery("Student.findByAge",
					Student.class);
			query.setParameter("age", age);
			return query.list();
			
		}
	}
	public void printRecords(List<Student> records)
	{
		records.stream().forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		StudentDao1 sdao = new StudentDao1();
		System.out.println("--------------------By City----------------");
		List<Student> recordsByCity = sdao.getRecordsByCity("Delhi");
		sdao.printRecords(recordsByCity);
		
		System.out.println("--------------------By Age----------------");
		List<Student> recordsByAge = sdao.getRecordsByAge(21);
		sdao.printRecords(recordsByAge);
		
		System.out.println("--------------------By Name----------------");
		List<Student> recordsByName = sdao.getRecordsByName("Meera");
		sdao.printRecords(recordsByName);
		
		System.out.println("--------------------By Age Between----------------");
		List<Student> agebetween = sdao.getRecordsAge(21, 24);
		sdao.printRecords(agebetween);
		
	}
}
