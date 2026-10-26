package com.training.hql.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private int age;
    private double marks;
    private String city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    public Student() {}

    public Student(String name, int age, double marks, String city, Department department) {
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.city = city;
        this.department = department;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getMarks() { return marks; }
    public String getCity() { return city; }
    public Department getDepartment() { return department; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setMarks(double marks) { this.marks = marks; }
    public void setCity(String city) { this.city = city; }
    public void setDepartment(Department department) { this.department = department; }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', age=" + age +
                ", marks=" + marks + ", city='" + city + "'}";
    }
}
