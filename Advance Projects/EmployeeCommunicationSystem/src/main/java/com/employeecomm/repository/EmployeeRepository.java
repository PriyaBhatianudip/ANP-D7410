package com.employeecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeecomm.entity.Employee;

public interface EmployeeRepository
        extends JpaRepository<Employee, String> {

    boolean existsByEmail(String email);
}