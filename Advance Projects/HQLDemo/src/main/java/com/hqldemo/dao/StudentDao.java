package com.hqldemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.hqldemo.entity.Student;
import com.hqldemo.util.HibernateUtil;

public class StudentDao 
{
	SessionFactory sf;
	
	public StudentDao() 
	{
		sf= HibernateUtil.getSessionFactory();
	}
	
	public List<Student> getRecords()
	{
		Session session = sf.openSession();
		
		String hql = "from Student s join fetch s.department";
		
		Query<Student> records = session.createQuery(hql, Student.class);
		
		List<Student> students = records.list();
		
//		List<Student> students1 = session.createQuery(hql, Student.class).list();
		
		session.close();
		return students;
//		return session.createQuery(hql, Student.class).list();
	}
	
//	get selected columns
	public void getStudentMarks()
	{
		Session session = sf.openSession();
		String hql = "select s.studentid, s.studentname, s.marks "
				+ "from Student s";		
		List<Object[]> results = session.createQuery(hql,Object[].class)
				.getResultList();
		
//		to print/get individual values
		System.out.println("Student Marks Records");
		for(Object[] row: results) 
		{
			Long id = (Long) row[0];
			String name = (String) row[1];
			Double marks = (Double) row[2];
			System.out.println(id+"\t"+name+"\t"+marks);
		}
		
		session.close();
	}
	
	public void getName_City()
	{
//		2. Display only student names and cities.
		String hql = "select s.studentname, s.city from Student s";
		
		Session session= sf.openSession();
		List<Object[]> results = session.createQuery(hql, Object[].class).getResultList();
		
		System.out.println("Name\tCity");
		for(Object[] row: results)
			System.out.println(row[0]+"\t"+row[1]);
		
		session.close();
		
	}
//	3. Display students who scored more than n(75).
//	4. Display students whose marks are between 60 and 85.
}
