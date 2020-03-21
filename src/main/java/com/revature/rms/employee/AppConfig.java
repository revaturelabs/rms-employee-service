package com.revature.rms.employee;

import com.revature.rms.core.models.ResourceMetadata;
import com.revature.rms.employee.entities.Department;
import com.revature.rms.employee.entities.Employee;
import com.revature.rms.employee.entities.Title;
import com.revature.rms.employee.repos.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

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

		ResourceMetadata metadata = new ResourceMetadata("5e70e8e8d798ce32e0ce9b64", "5e70e8e8d798ce32e0ce9b64");

		Employee ceo = new Employee("Ashwin", "Bharath", "ashwin.bharath@revature.com", null, Title.CEO, Department.EXECUTIVE, metadata);
		employeeRepo.save(ceo).block();

		Employee cto = new Employee("Ravi", "Singh", "ravi.singh@revature.com", ceo.getId(), Title.CTO, Department.TRAINING, metadata);
		employeeRepo.save(cto).block();

		Employee vpTech = new Employee("Saravanan", "Regunath", "saravanan.regunath@revature.com", cto.getId(), Title.VP_OF_TECH, Department.TRAINING, metadata);
		employeeRepo.save(vpTech).block();

		Employee mngrTech = new Employee("Steven", "Kelsey", "steven.kelsey@revature.com", vpTech.getId(), Title.MANAGER_OF_TECH, Department.TRAINING, metadata);
		employeeRepo.save(mngrTech).block();

		Employee leadTrainer1 = new Employee("August", "Duet", "august.duet@revature.com", mngrTech.getId(), Title.LEAD_TRAINER, Department.TRAINING, metadata);
		employeeRepo.save(leadTrainer1).block();

		Employee srTrainer1 = new Employee("Wezley", "Singleton", "wezley.singleton@revature.com", mngrTech.getId(), Title.SENIOR_TRAINER, Department.TRAINING, metadata);
		employeeRepo.save(srTrainer1).block();

		Employee trainer1 = new Employee("Robert", "Connell", "robert.connell@revature.com", mngrTech.getId(), Title.TRAINER, Department.TRAINING, metadata);
		employeeRepo.save(trainer1).block();

		System.out.println("DATA SOURCE INIT COMPLETE");

	}

}
