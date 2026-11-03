package com.demo;

import org.springframework.stereotype.Component;

import com.demo.entity.Student;

@Component
public class StudentRepository 
{
	public Student getStudent()
	{
		return new Student(101, "KK", "Java");
	}
}
