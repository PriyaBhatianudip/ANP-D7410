package com.hqldemo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="departments")
public class Department 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long deptid;
	
	public Department(String deptname)
	{
		this.deptname = deptname;
	}

	@Column(nullable = false, unique = true)
	private String deptname;
	
	@OneToMany(mappedBy = "department")
	private List<Student> students = new ArrayList<>();

	@Override
	public String toString() 
	{
		return "deptid=" + deptid + ", deptname=" + deptname;
	}
	
}
