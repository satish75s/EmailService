package com.email.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.email.dto.EmailRequest;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	
	@Value("${spring.mail.username}")
	String emailIdFrom;
	 @Autowired
	    private JavaMailSender mailSender;

	    public String sendSimpleEmail(EmailRequest request) {
	        try {
	            MimeMessage message = mailSender.createMimeMessage();
	            MimeMessageHelper helper = new MimeMessageHelper(message);
	            helper.setFrom(emailIdFrom);
	            helper.setTo(request.getToEMail());
	            helper.setSubject(request.getSubject());
	            helper.setText(request.getMessageBody());

	            mailSender.send(message);
	            
	        } catch (MessagingException | MailException e) {
	            e.printStackTrace();  
	        }
	        return "email successfully sent to : " + request.getToEMail();
	    }
	    public void sendHtmlEmail(String to, String subject, String htmlContent) {
	        try {
	            MimeMessage message = mailSender.createMimeMessage();
	            MimeMessageHelper helper = new MimeMessageHelper(message, true);  // 'true' indicates multipart
	            helper.setFrom(emailIdFrom);
	            helper.setTo(to);
	            helper.setSubject(subject);
	            helper.setText(htmlContent, true);  // true indicates that the content is HTML

	            mailSender.send(message);
	        } catch (MessagingException | MailException e) {
	            e.printStackTrace();  // Log the exception
	        }
	    }
	    public String  sendEmailWithAttachment(EmailRequest request) {
	        try {
	            MimeMessage message = mailSender.createMimeMessage();
	            MimeMessageHelper helper = new MimeMessageHelper(message, true);  // true for multipart message
	            helper.setFrom(emailIdFrom);
	            helper.setTo(request.getToEMail());
	            helper.setSubject(request.getSubject());
	            helper.setText(request.getMessageBody());
	            FileSystemResource file = new FileSystemResource(new File(request.getAttachment()));
	            helper.addAttachment(file.getFilename(), file);  // Add attachment
             
	            mailSender.send(message);
	            return "Mail sent successfully with attachment " + file.getFilename();
	        } catch (MessagingException | MailException e) {
	            e.printStackTrace();  // Log the exception
	        }
	       return null;
	    }

}
