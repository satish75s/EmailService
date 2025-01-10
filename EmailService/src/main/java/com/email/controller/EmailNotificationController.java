package com.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.email.dto.EmailRequest;
import com.email.service.EmailService;

import jakarta.mail.MessagingException;

@RestController
public class EmailNotificationController {

    @Autowired
    private EmailService service;

    @PostMapping("/sendEmail")
    public String sendTextEmail(@RequestBody EmailRequest request) {
        return service.sendSimpleEmail(request);
    }
    
    @PostMapping("/sendHtmlContent")
    public void sendEmailWithAttachment(@RequestParam("to") String to, @RequestParam("subject") String subject, @RequestParam("htmlContent") String htmlContent) throws MessagingException {
         service.sendHtmlEmail(to, subject, htmlContent);
    }
    

    @PostMapping("/sendAttachment")
    public String sendEmailWithAttachment(@RequestBody EmailRequest request) throws MessagingException {
        return service.sendEmailWithAttachment(request);
    }
}
