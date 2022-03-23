package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartSpringBoot {

	public static void main(String[] args) 
	{   
		//START SPRING APPLICATION
		SpringApplication.run(StartSpringBoot.class, args);
		
		//ADD CODE
		System.out.println("SPRING BOOT FRAMEWORK STARTED");
	}
}
