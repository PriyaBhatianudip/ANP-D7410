package com.employeecomm.entity;


import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "pending_registrations")
public class PendingRegistration {

    @Id
    private String registrationId;

    private String employeeId;
    private String employeeName;
    private String email;
    private String department;
    private String designation;

    private Double salary;

    private LocalDate joiningDate;

    private String otpHash;

    private LocalDateTime expiryTime;

    private int attempts;

   
}