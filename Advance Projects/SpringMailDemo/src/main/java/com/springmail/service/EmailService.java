package com.springmail.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String senderEmail;

    public void sendEmail(String to, String subject, String body) {

        SimpleMailMessage message = new SimpleMailMessage();
        System.out.println("Sending mail to "+to);
        message.setFrom(senderEmail);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
        System.out.println("Mail sent successfully!!");
    }

    public void sendWelcomeEmail(String name, String email) {

        String subject = "Welcome to Our Organization";

        String body = "Dear " + name + ",\n\n"
                + "Welcome to our organization!\n"
                + "Your employee registration is successful.\n\n"
                + "Regards,\nHR Department";

        sendEmail(email, subject, body);
    }

    public void sendUpdateEmail(String name, String email) {

        String subject = "Employee Details Updated";

        String body = "Dear " + name + ",\n\n"
                + "Your employee details have been updated successfully.";

        sendEmail(email, subject, body);
    }
}