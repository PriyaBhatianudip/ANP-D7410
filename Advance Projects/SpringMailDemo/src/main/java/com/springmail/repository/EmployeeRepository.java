package com.springmail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springmail.entity.Employee;

public interface EmployeeRepository
        extends JpaRepository<Employee, Integer> 
{

}