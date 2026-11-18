
package com.springmail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.springmail.entity.Employee;
import com.springmail.model.EmailRequest;
import com.springmail.service.EmailService;
import com.springmail.service.EmployeeService;

@Controller
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private EmployeeService empService;

    // Display email form
    @GetMapping({"", "/"})
    public String showEmailForm(Model model) {

        model.addAttribute(
            "emailRequest",
            new EmailRequest()
        );

        return "email-form";
    }

    // Send email
    @PostMapping("/send")
    public String sendEmail(
            @ModelAttribute("emailRequest")
            EmailRequest request,
            Model model) {

        try {

            emailService.sendEmail(request);

            model.addAttribute(
                "success",
                "Email sent successfully!"
            );

        } catch (Exception e) {

            e.printStackTrace();

            model.addAttribute(
                "error",
                "Unable to send email: " + e.getMessage()
            );
        }

        model.addAttribute(
            "emailRequest",
            new EmailRequest()
        );

        return "email-form";
    }

    // Send emails to all employees
    @PostMapping("/sendMails")
    @ResponseBody
    public String sendEmails() {

        try {

            List<Employee> emplist =
                empService.getAllEmployees();

            emailService.sendMails(emplist);

            return "Mails sent successfully!";

        } catch (Exception e) {

            e.printStackTrace();

            return "Unable to send mails: "
                    + e.getMessage();
        }
    }

    // Send emails using Excel data
    @PostMapping("/sendMailsexcel")
    @ResponseBody
    public String sendEmailstoMultiple(
            @RequestParam("file") MultipartFile file) {

        try {

            String msg =
                emailService.sendMailsUsingExcelData(file);

            return "Emails processed successfully! " + msg;

        } catch (Exception e) {

            e.printStackTrace();

            return "Unable to process emails: "
                    + e.getMessage();
        }
    }
}
