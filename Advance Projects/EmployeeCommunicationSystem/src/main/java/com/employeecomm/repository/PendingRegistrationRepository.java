package com.employeecomm.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.employeecomm.entity.PendingRegistration;


public interface PendingRegistrationRepository
        extends JpaRepository<PendingRegistration, String> {

    boolean existsByEmployeeId(String employeeId);

    boolean existsByEmail(String email);
}
