package com.employeecomm.service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employeecomm.entity.Employee;
import com.employeecomm.entity.PendingRegistration;
import com.employeecomm.repository.EmployeeRepository;
import com.employeecomm.repository.PendingRegistrationRepository;


@Service
public class OtpService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PendingRegistrationRepository pendingRepository;

    @Autowired
    private EmailService emailService;

    private final BCryptPasswordEncoder encoder =
            new BCryptPasswordEncoder();

    private final SecureRandom random = new SecureRandom();

    // Generate and send OTP
    public String startRegistration(Employee employee) {

        String otp = String.format("%06d",
                random.nextInt(1000000));

        PendingRegistration pending =
                new PendingRegistration();

        String registrationId =
                UUID.randomUUID().toString();

        pending.setRegistrationId(registrationId);
        pending.setEmployeeId(employee.getEmployeeId());
        pending.setEmployeeName(employee.getEmployeeName());
        pending.setEmail(employee.getEmail());
        pending.setDepartment(employee.getDepartment());
        pending.setDesignation(employee.getDesignation());
        pending.setSalary(employee.getSalary());
        pending.setJoiningDate(employee.getJoiningDate());

        pending.setOtpHash(encoder.encode(otp));

        pending.setExpiryTime(
                LocalDateTime.now().plusMinutes(5));

        pending.setAttempts(0);

        pendingRepository.save(pending);

        try {
            emailService.sendOtp(employee.getEmail(), otp);
        }
        catch (RuntimeException e) {
        	e.printStackTrace();
            pendingRepository.delete(pending);
            throw e;
        }

        return registrationId;
    }

    // Verify OTP and save employee
    @Transactional
    public String verifyOtp(String registrationId, String otp) {

        PendingRegistration pending =
                pendingRepository.findById(registrationId)
                .orElse(null);

        if (pending == null) {
            return "NOT_FOUND";
        }

        if (LocalDateTime.now().isAfter(
                pending.getExpiryTime())) {

            pendingRepository.delete(pending);
            return "EXPIRED";
        }

        if (pending.getAttempts() >= 5) {
            pendingRepository.delete(pending);
            return "MAX_ATTEMPTS";
        }

        if (!encoder.matches(otp, pending.getOtpHash())) {

            pending.setAttempts(pending.getAttempts() + 1);

            pendingRepository.save(pending);

            return "INVALID";
        }

        // Check again before inserting
        if (employeeRepository.existsById(
                pending.getEmployeeId())) {
            pendingRepository.delete(pending);
            return "DUPLICATE";
        }

        if (employeeRepository.existsByEmail(
                pending.getEmail())) {
            pendingRepository.delete(pending);
            return "DUPLICATE";
        }

        Employee employee = new Employee();

        employee.setEmployeeId(pending.getEmployeeId());
        employee.setEmployeeName(pending.getEmployeeName());
        employee.setEmail(pending.getEmail());
        employee.setDepartment(pending.getDepartment());
        employee.setDesignation(pending.getDesignation());
        employee.setSalary(pending.getSalary());
        employee.setJoiningDate(pending.getJoiningDate());

        employeeRepository.save(employee);

        pendingRepository.delete(pending);

        return "SUCCESS";
    }
}
