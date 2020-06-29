package com.revature.rms.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EmployeeMicroserviceConfig {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMicroserviceConfig.class, args);
	}

}
