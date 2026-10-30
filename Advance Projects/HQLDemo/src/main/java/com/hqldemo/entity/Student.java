package com.hqldemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
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
@Table(name="students")
//@NamedQuery(name="Student.findByCity",
//query="from Student s left join fetch s.department where s.city= :city")

@NamedQueries({
	@NamedQuery(name="Student.findByCity",
			query="from Student s left join fetch s.department where s.city= :city"),
	@NamedQuery(name="Student.findByAge",
	query="from Student s left join fetch s.department where s.age >= :age"),
	@NamedQuery(name="Student.findByName",
	query="from Student s left join fetch s.department where s.studentname= :sname")
})
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long studentid;
	
	@Column(nullable = false)
	private String studentname;
	private int age;
	private double marks;
	private String city;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="deptid")
	private Department department;

	public Student(String studentname, int age, double marks, String city, Department department) {
		this.studentname = studentname;
		this.age = age;
		this.marks = marks;
		this.city = city;
		this.department = department;
	}

	@Override
	public String toString() {
		return "studentid=" + studentid + ", studentname=" + studentname + ", age=" + age + ", marks=" + marks
				+ ", city=" + city +", "+ department;
	}


	
}
