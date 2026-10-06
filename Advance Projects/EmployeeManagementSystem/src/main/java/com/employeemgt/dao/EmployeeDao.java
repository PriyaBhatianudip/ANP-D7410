package com.employeemgt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employeemgt.entity.Employee;
import com.employeemgt.util.DBConnection;

public class EmployeeDao 
{
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public EmployeeDao() 
	{
		con = DBConnection.getConnection();
	}
	
	public List<Employee> getAllEmployees()
	{
		String query = "select * from employees";
		List<Employee> emplist=null;
//		initialize prepared statement
		try 
		{
			ps= con.prepareStatement(query);
			emplist = new ArrayList<Employee>();
			rs = ps.executeQuery();
			while(rs.next())
			{
				Employee e = new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setAge(rs.getInt(3));
				e.setCity(rs.getString(4));
				e.setSalary(rs.getFloat(5));
				
				emplist.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emplist;
	}
	
	public int addEmployee(Employee emp)
	{
		String query = "insert into employees values(?,?,?,?,?)";
		int status=0;
		try 
		{
			ps= con.prepareStatement(query);
			
			ps.setInt(1, emp.getId());
			ps.setString(2, emp.getName());
			ps.setInt(3, emp.getAge());
			ps.setString(4, emp.getCity());
			ps.setFloat(5, emp.getSalary());
			
			status = ps.executeUpdate();
			System.out.println("Number of records inserted : "+status);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return status;
	}
	
	public int updateEmployee(Employee emp)
	{
		String query = "update employee set name=?, age=?, city=?, salary=? where empid=?";
		int status=0;
		try 
		{
			ps= con.prepareStatement(query);
			
			ps.setString(1, emp.getName());
			ps.setInt(2, emp.getAge());
			ps.setString(3, emp.getCity());
			ps.setFloat(4, emp.getSalary());
			ps.setInt(5, emp.getId());
			
			status= ps.executeUpdate();
			System.out.println("Number of records updated : "+status);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return status;
	}
	
	public int deleteEmployee(int empid)
	{
		String query = "delete from employee where empid=?";
		int status=0;
		try 
		{
			ps= con.prepareStatement(query);
			ps.setInt(1, empid);
			
			status = ps.executeUpdate();
			System.out.println("Number of records deleted : "+ status);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return status;
	}
	
	public Employee getEmployee(int empid)
	{
		String query = "select * from employees where empid=?";
		Employee e=null;
		try 
		{
			ps= con.prepareStatement(query);
			ps.setInt(1, empid);
			
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				e= new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setAge(rs.getInt(3));
				e.setCity(rs.getString(4));
				e.setSalary(rs.getFloat(5));
			}
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
		}
		return e;
	}
	
	public int countRecords()
	{
		String query = "select count(empid) from employees";
		int count=0;
		try 
		{
			ps= con.prepareStatement(query);
			
			rs= ps.executeQuery();
			if(rs.next())
			{
				count= rs.getInt(1);
			}
			System.out.println("Count of Employees : "+count);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return count;
	}
}
