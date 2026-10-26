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
		
		String hql = "from Student s";
		
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
}
