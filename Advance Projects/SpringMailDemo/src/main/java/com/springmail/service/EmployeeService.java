package com.springmail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import com.springmail.entity.Employee;
import com.springmail.repository.EmployeeRepository;

import jakarta.mail.MessagingException;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private EmailService emailService;

    public Employee addEmployee(Employee employee) {

        Employee savedEmployee = repository.save(employee);

        try {
        	System.out.println("Sending mail to new employee...");
            emailService.sendWelcomeEmailAttachment(
                    savedEmployee.getName(),
                    savedEmployee.getEmail());
        }
        catch (MailException e) {
            System.out.println("Welcome email failed: " + e.getMessage());
        } catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return savedEmployee;
    }

    public Employee updateEmployee(int id, Employee employee) {

        Employee existing = repository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Employee not found"));

//        Employee ee = repository.findById(id).
//        		orElseThrow(()-> 
//        		new RuntimeException("Employee Id Not Found!!"));
        
        existing.setName(employee.getName());
        existing.setEmail(employee.getEmail());
        existing.setDepartment(employee.getDepartment());

        Employee updated = repository.save(existing);

        try {
            emailService.sendUpdateEmail(
                    updated.getName(),
                    updated.getEmail());
        }
        catch (MailException e) {
            System.out.println("Update email failed: " + e.getMessage());
        }

        return updated;
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployee(int id) {

        return repository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Employee not found"));
    }

    public void deleteEmployee(int id) {

        if (!repository.existsById(id)) {
            throw new RuntimeException("Employee not found");
        }

        repository.deleteById(id);
    }
}