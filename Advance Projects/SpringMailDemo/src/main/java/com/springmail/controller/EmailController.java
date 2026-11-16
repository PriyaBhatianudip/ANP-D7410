package com.springmail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.springmail.entity.Employee;
import com.springmail.entity.Recipient;
import com.springmail.service.EmailService;
import com.springmail.service.EmployeeService;
import com.springmail.service.ExcelService;

//http://abc.com/folder/universal-url/methodurl

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private EmployeeService empService;
   
    
    @PostMapping("/send")
    public String sendEmail(
            @RequestParam String to,
            @RequestParam String subject,
            @RequestParam String body) {

        emailService.sendEmail(to, subject, body);

        return "Email sent successfully!";
    }
    
    @PostMapping("/sendMails")
    public String sendEmails()
    {
    	List<Employee> emplist = empService.getAllEmployees();
    	
    	emailService.sendMails(emplist);
    	
    	return "Mails sent Successfully!!";
    }
    
    @PostMapping("/sendMailsexcel")
    public String sendEmailstoMultiple(@RequestParam("file") MultipartFile file)
    {
    	String msg="";
    	try 
    	{
			msg = emailService.sendMailsUsingExcelData(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return "Emails Processed Successfully!!"+msg;
    }
}