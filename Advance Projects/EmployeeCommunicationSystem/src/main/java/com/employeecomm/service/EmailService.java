package com.employeecomm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendOtp(String email, String otp) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(email);
        message.setSubject("Employee Registration - OTP Verification");

        message.setText(
            "Dear Employee,\n\n" +
            "Your OTP for employee registration is: " + otp +
            "\n\nThis OTP is valid for 5 minutes." +
            "\n\nPlease do not share this OTP with anyone."
        );

        mailSender.send(message);
    }
}