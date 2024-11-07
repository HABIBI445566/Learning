package com.zahimuslim.Spring_boot_learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.zahimuslim.Spring_boot_learning"})
public class SpringBootLearningApplication {
	public static void main(String[] args) {
		//Will remove everything and beginning of the new project Done Deleting everything
		SpringApplication.run(SpringBootLearningApplication.class, args);
	}
}
