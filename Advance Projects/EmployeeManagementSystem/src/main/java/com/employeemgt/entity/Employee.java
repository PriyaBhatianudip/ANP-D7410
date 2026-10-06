package com.employeemgt.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter  // to get the value of variables
@Setter   // to save/set the value of a variable
@ToString  // when object is printed, then it returns a string
// conaining all the values of this object
@NoArgsConstructor   // for default constructor
@AllArgsConstructor  // for all parameter constructor
public class Employee 
{
	private int id;
	private String name;
	private int age;
	private String city;
	private float salary;
	
}
