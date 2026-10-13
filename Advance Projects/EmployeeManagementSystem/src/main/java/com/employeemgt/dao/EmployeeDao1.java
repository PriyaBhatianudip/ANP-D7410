package com.employeemgt.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.employeemgt.entity.Employee;
import com.employeemgt.util.DBConnection;

public class EmployeeDao1 
{
	Connection con;
	CallableStatement cs;
	
	public EmployeeDao1() 
	{
		con=DBConnection.getConnection();
	}
	
//	get single record from the database
	public Employee getRecordById(int eid)
	{
		String query ="{call getEmployeeRecord(?)}";  // in parameter only
		
		try
		{
			cs= con.prepareCall(query);
			cs.setInt(1, eid);
			ResultSet rs = cs.executeQuery();
			Employee emp=new Employee();
			if(rs.next())
			{
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setAge(rs.getInt(3));
				emp.setCity(rs.getString(4));
				emp.setSalary(rs.getFloat(5));
			}
			return emp;
		}catch(SQLException se)
		{
			se.printStackTrace();
		}
		return null;
	}
	
	public void addEmployee(Employee emp)
	{
		String query = "{call addEmployeeRecord(?,?,?,?,?,?)}";
		
		try
		{
			cs= con.prepareCall(query);
			cs.setInt(1, emp.getId());
			cs.setString(2, emp.getName());
			cs.setInt(3, emp.getAge());
			cs.setString(4, emp.getCity());
			cs.setFloat(5, emp.getSalary());
			cs.setInt(6, emp.getDeptId());
			
//			for insert update or delete
			cs.execute();
			System.out.println("Record Added Successfully!!");
			
		}catch(SQLException se)
		{
			se.printStackTrace();
		}
	}
	
	public List<Employee> getAllEmployees()
	{
		String query = "{call getAllRecords()}";
		
		List<Employee> emplist =new ArrayList<Employee>();
		
		try 
		{
			cs= con.prepareCall(query);
			emplist = new ArrayList<Employee>();
			ResultSet rs = cs.executeQuery();
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
	
//	delete operation which will return the deleted record as well
	
	public Employee deleteEmployee(int eid)
	{
		String query = "{call deleteEmployee(?,?,?,?,?)}";
		
		Employee emp=null;
		
		try 
		{
			cs= con.prepareCall(query);
			cs.setInt(1, eid);
			
//			register out parameter(used for receiving values from out parameter)
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.INTEGER);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.FLOAT);
			
			cs.execute();
			
			emp=new Employee();
//			storing values in emp object from cs object
			emp.setId(eid);
			emp.setName(cs.getString(2));
			emp.setAge(cs.getInt(3));
			emp.setCity(cs.getString(4));
			emp.setSalary(cs.getFloat(5));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}
	
//	first it will update the record
//	second it will return the updated record from the employee table
//	third it will also return the relevant department record
	
	public void updateDeptSalary(int empid, int deptid, float salary)
	{
		String query = "{call updateEmployee(?,?,?)}";
		
		try {
			cs = con.prepareCall(query);
			cs.setInt(1, empid);
			cs.setInt(2, deptid);
			cs.setFloat(3, salary);
			
//			here execute method will return true if the query is running successfully
			boolean hasResult = cs.execute();
			
			int index=1;
			while(true)
			{
				ResultSet rs = cs.getResultSet();
				// getResultSet() will return the result set at 
//				current cursor position
				
				if(index==1)
				{
					System.out.println("Updated Record");
					if(rs.next())
					{
						System.out.println("Employee Id : "+rs.getInt(1));
						System.out.println("Employee Name : "+rs.getString(2));
						System.out.println("Age : "+rs.getInt(3));
						System.out.println("City : "+rs.getString(4));
						System.out.println("Salary : "+rs.getFloat(5));
						
					}
					else
					{
						System.out.println("Employee not found!!");
					}
				}
				else if(index==2)
				{
					System.out.println("Department Details : ");
					while(rs.next())
					{
						System.out.println("Department Id : "+rs.getInt(1));
						System.out.println("Department Name : "+rs.getString(2));
						System.out.println("Manager Name : "+rs.getString(3));
					}
				}
				
				index++;
				hasResult = cs.getMoreResults();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void main(String[] args) {
		EmployeeDao1 edao1=new EmployeeDao1();
		
		edao1.updateDeptSalary(110, 201, 67000);
	
	}
}


