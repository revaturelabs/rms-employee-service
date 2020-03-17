package com.revature.rms.employee;

import com.revature.rms.employee.entities.Department;
import com.revature.rms.employee.entities.Employee;
import com.revature.rms.employee.entities.ResourceMetadata;
import com.revature.rms.employee.entities.Title;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@EnableEurekaClient
@SpringBootApplication
public class AppConfig implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);

	public static void main(String[] args) {
		SpringApplication.run(AppConfig.class, args);
	}

	private EmployeeRepository employeeRepo;

	@Autowired
	public AppConfig(EmployeeRepository repo) {
		this.employeeRepo = repo;
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("INIT DATA SOURCE");

		LocalDateTime now = LocalDateTime.now();
		ResourceMetadata metadata = new ResourceMetadata(1, now, 1, now, 1);

		Employee ceo = new Employee("Ashwin", "Bharath", "ashwin.bharath@revature.com", null, Title.CEO, Department.EXECUTIVE, metadata);
		Employee cto = new Employee("Ravi", "Singh", "ravi.singh@revature.com", ceo, Title.CTO, Department.TRAINING, metadata);
		Employee vpTech = new Employee("Saravanan", "Regunath", "saravanan.regunath@revature.com", cto, Title.VP_OF_TECH, Department.TRAINING, metadata);
		Employee mngrTech = new Employee("Steven", "Kelsey", "steven.kelsey@revature.com", vpTech, Title.MANAGER_OF_TECH, Department.TRAINING, metadata);
//		Employee leadTrainer1 = new Employee("August", "Duet", "august.duet@revature.com", mngrTech, Title.LEAD_TRAINER, Department.TRAINING, metadata);
		Employee srTrainer1 = new Employee("Wezley", "Singleton", "wezley.singleton@revature.com", mngrTech, Title.SENIOR_TRAINER, Department.TRAINING, metadata);
//		Employee trainer1 = new Employee("Robert", "Connell", "robert.connell@revature.com", mngrTech, Title.TRAINER, Department.TRAINING, metadata);

		employeeRepo.save(ceo).block();
		employeeRepo.save(cto).block();
		employeeRepo.save(vpTech).block();
		employeeRepo.save(mngrTech).block();
//		employeeRepo.save(leadTrainer1).block();
		employeeRepo.save(srTrainer1).block();
//		employeeRepo.save(trainer1).block();

		System.out.println("DATA SOURCE INIT COMPLETE");

	}

}
