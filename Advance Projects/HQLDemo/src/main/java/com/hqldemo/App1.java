package com.hqldemo;

import java.util.List;

import com.hqldemo.dao.StudentDao;
import com.hqldemo.entity.Student;

public class App1 {
	public static void main(String[] args) 
	{
		StudentDao dao=new StudentDao();
		
		dao.getName_City();
		
		List<Student> records = dao.getRecords();
    	
    	for(Student s: records)
    	{
    		System.out.println("Student id : "+s.getStudentid());
    		System.out.println("Name : "+s.getStudentname());
    		System.out.println("Age : "+s.getAge());
    		System.out.println("Department id "+s.getDepartment().getDeptid());
    		System.out.println("Department Name : "+s.getDepartment().getDeptname());
    	}
    	
	}
}
