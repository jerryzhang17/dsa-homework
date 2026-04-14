package edu.brooklyn.cisc3130.taskboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
@SpringBootConfiguration - Marks this as a Spring configuration class
@EnableAutoConfiguration - Enables Spring Boot's auto-configuration
@ComponentScan - Scans for Spring components in the package
*/
public class CampusTaskboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampusTaskboardApplication.class, args);
	}

}
