package com.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
//@ToString(onlyExplicitlyIncluded = true)
@AllArgsConstructor
public class Department 
{
	private int deptId;
	private String deptName;
	private String manager;
	
	private UserDetails user;
	
	public Department(String deptName, String manager)
	{
		this.deptName=deptName;
		this.manager=manager;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", manager=" + manager+"]";
	}
	
	
}
