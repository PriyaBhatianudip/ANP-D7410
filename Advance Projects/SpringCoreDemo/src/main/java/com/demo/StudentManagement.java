package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentManagement 
{
	@Autowired
	private StudentService service;
	
	public void display()
	{
		System.out.println("Welcome to Student Management Sytsem");
		service.showDetails();
	}
}
