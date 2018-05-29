package com.howtodoinjava.example.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}
}




//http://localhost:8011/findEmployeeDetails/111
//http://localhost:8011/actuator
//http://localhost:8011/health


//https://www.foreach.be/blog/how-to-visualise-spring-boot-actuator-health-indicators-in-spring-boot-admin
//https://github.com/codecentric/spring-boot-admin
