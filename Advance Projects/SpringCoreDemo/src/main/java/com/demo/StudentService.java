package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.entity.Student;

@Component
public class StudentService 
{
	@Autowired
	private StudentRepository repository;
	
	public void showDetails()
	{
		Student student = repository.getStudent();
		student.display();
	}
}
