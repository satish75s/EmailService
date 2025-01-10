package com.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.email.service.EmailService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title="Email Service", version="v1.0", description="Demo Application")) 
//@EnableScheduling
public class EmailServiceApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(EmailServiceApplication.class, args);
	}
	
	//@Scheduled(fixedRate=5000)
	public void testJob() {
		
		System.out.println("testing cron tab");
	}
	
    


}
