package com.email.test;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    // Runs every 5 seconds (fixed rate)
	//@Scheduled(fixedRate = 5000)
    public void performTask() {
        System.out.println("Task performed at fixed rate of 5 seconds.");
    }
}