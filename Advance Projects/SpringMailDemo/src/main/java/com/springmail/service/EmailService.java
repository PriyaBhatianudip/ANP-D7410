package com.springmail.service;


import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springmail.entity.Employee;
import com.springmail.entity.Recipient;
import com.springmail.model.EmailRequest;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String senderEmail;
    
    @Autowired
    private ExcelService excelService;
    

    public void sendEmail(EmailRequest request) {

        SimpleMailMessage message = new SimpleMailMessage();
        System.out.println("Sending mail to "+request.getTo());
        message.setFrom(senderEmail);
        message.setTo(request.getTo());
        message.setSubject(request.getSubject());
        message.setText(request.getMessage());

        mailSender.send(message);
        System.out.println("Mail sent successfully!!");
    }

    public void sendWelcomeEmail(String name, String email) {

        String subject = "Welcome to Our Organization";

        String body = "Dear " + name + ",\n\n"
                + "Welcome to our organization!\n"
                + "Your employee registration is successful.\n\n"
                + "Regards,\nHR Department";
        
        EmailRequest request = new EmailRequest(email, subject, body);
        sendEmail(request);
    }

    public void sendWelcomeEmailAttachment(String name, String email) 
    		throws MessagingException {

        String subject = "Welcome to Our Organization";

        String body = "Dear " + name + ",\n\n"
                + "Welcome to our organization!\n"
                + "Your employee registration is successful.\n\n"
                + "Regards,\nHR Department";

//        file to attach
        FileSystemResource file = new FileSystemResource(
        		new File("E:\\file.pdf"));
        
        MimeMessage mm = mailSender.createMimeMessage(); 
        
        MimeMessageHelper message = 
        		new MimeMessageHelper(mm,true);
        message.setTo(email);
        message.setSubject(subject);
        message.setText(body);
        message.addAttachment("ThinkEdges Private Limited BDE WFH.pdf", file);
        mailSender.send(mm);
        System.out.println("Mail with attachment sent successfully!!");
    }

    
    public void sendUpdateEmail(String name, String email) {

        String subject = "Employee Details Updated";

        String body = "Dear " + name + ",\n\n"
                + "Your employee details have been updated successfully.";

        EmailRequest request = new EmailRequest(email, subject, body);
        sendEmail(request);
    }
    
    
    public void sendMails(List<Employee> data)
    {
    	SimpleMailMessage message = new SimpleMailMessage();
    	
    	message.setTo(data.get(0).getEmail(),
    			data.get(1).getEmail(), 
    			data.get(2).getEmail());
    	
    	message.setCc(data.get(3).getEmail());
    	message.setBcc(data.get(4).getEmail());
    	
    	
    	message.setSubject("Information Panel");
    	message.setText("Welcome to Information Panel!!");
    	
    	mailSender.send(message);
    	System.out.println("Mail Sent Successfully!!");
    	
    	
    }
    
    public void sendMultipleMails(String emails[])
    {
    	SimpleMailMessage message = new SimpleMailMessage();
    	
    	message.setTo(emails);
    	
    	message.setSubject("Information Panel");
    	message.setText("Welcome to Information Panel!!");
    	
    	mailSender.send(message);
    	System.out.println("Mail Sent Successfully!!");   	
    }
    
    
    public String sendMailsUsingExcelData(MultipartFile file)
    {
    	String msg="Sent Mail Successfully to ";
    	try 
    	{
			List<Recipient> recipients = 
					excelService.readExcelFile(file);
		
			for(Recipient r : recipients)
			{
				sendWelcomeEmail(r.getName(), r.getEmail());
				msg+="\n->"+r.getEmail();
			}
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return msg;
    }
}