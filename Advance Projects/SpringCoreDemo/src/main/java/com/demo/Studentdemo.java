package com.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.demo")
public class Studentdemo 
{
	public static void main(String[] args) 
	{
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(Studentdemo.class);
		
		StudentManagement sm= context.getBean(StudentManagement.class);
		sm.display();
		
		context.close();
	}
}
