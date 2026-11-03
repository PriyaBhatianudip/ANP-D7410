package com.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student 
{
	private int studentId;
	private String name;
	private String course;
	
	
	public void display()
	{
		System.out.println("Student Id : "+studentId);
		System.out.println("Student Name : "+name);
		System.out.println("Course : "+course);
	}
}
