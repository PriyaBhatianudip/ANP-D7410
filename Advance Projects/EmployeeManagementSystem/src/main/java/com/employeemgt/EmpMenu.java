package com.employeemgt;

import java.util.List;
import java.util.Scanner;

import com.employeemgt.dao.EmployeeDao;
import com.employeemgt.entity.Employee;

public class EmpMenu 
{
	EmployeeDao dao;
	Scanner sc;
//	constructor
	public EmpMenu() 
	{
		dao=new EmployeeDao();
		sc=new Scanner(System.in);
	}
	
	
	
	public void showRecords()
	{
		List<Employee> allEmployees = dao.getAllEmployees();
		
		for(Employee e: allEmployees)
		{
			System.out.println(e);
		}
		
	}
	
	public void addEmployeeRecord()
	{
		Employee e=new Employee();
//		code to get values from user and set them in employee object
		
		int status = dao.addEmployee(e);
		if(status>0) System.out.println("Record Added Successfully!!");
		else System.out.println("Unable to add Record!!");
	}
	
	public void  updateEmployee()
	{
		
	}
	
	public void deleteEmployee()
	{
		
	}
	
	public void showEmployee()
	{
		
	}
	
	public void showEmployeeCount()
	{
		
	}
	
	public void menu()
	{
		
	}
}
