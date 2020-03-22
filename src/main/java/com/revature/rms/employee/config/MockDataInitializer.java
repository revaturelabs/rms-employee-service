package com.revature.rms.employee.config;

import com.revature.rms.core.models.ResourceMetadata;
import com.revature.rms.employee.documents.Department;
import com.revature.rms.employee.documents.Employee;
import com.revature.rms.employee.documents.Title;
import com.revature.rms.employee.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
public class MockDataInitializer implements CommandLineRunner {

    private EmployeeRepository employeeRepo;

    @Autowired
    public MockDataInitializer(EmployeeRepository repo) {
        this.employeeRepo = repo;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("INIT DATA SOURCE");

        ResourceMetadata metadata = new ResourceMetadata("5e70e8e8d798ce32e0ce9b64", "5e70e8e8d798ce32e0ce9b64");

        Employee ceo = new Employee("5e768d0ef21b4b41fbbd3c50", "Ashwin", "Bharath", "ashwin.bharath@revature.com",
                Title.CEO, Department.EXECUTIVE, null, metadata);
        employeeRepo.save(ceo).block();

        Employee cto = new Employee("5e768d0ef21b4b41fbbd3c51", "Ravi", "Singh", "ravi.singh@revature.com", Title.CTO,
                Department.TRAINING, ceo.getId(), metadata);
        employeeRepo.save(cto).block();

        Employee cfo = new Employee("5e768d0ef21b4b41fbbd3c52", "Arjun", "Ganesan", "arjun.ganesan@revature.com",
                Title.CFO, Department.FINANCE, ceo.getId(), metadata);
        employeeRepo.save(cfo).block();

        Employee cso = new Employee("5e768d0ef21b4b41fbbd3c53", "Sriram", "Rajagopal", "sriram.rajagopal@revature.com",
                Title.CSO, Department.EXECUTIVE, ceo.getId(), metadata);
        employeeRepo.save(cso).block();

        Employee dirTech = new Employee("5e768d0ef21b4b41fbbd3c54", "Karan", "Dhirar", "karan.dhirar@revature.com",
                Title.DIRECTOR_OF_TECH, Department.TRAINING, cto.getId(), metadata);
        employeeRepo.save(dirTech).block();

        Employee vpTech = new Employee("5e768d0ef21b4b41fbbd3c55", "Saravanan", "Regunath", "saravanan.regunath@revature.com",
                Title.VP_OF_TECH, Department.TRAINING, cto.getId(), metadata);
        employeeRepo.save(vpTech).block();

        Employee dirHr = new Employee("5e768d0ef21b4b41fbbd3c56", "Carol", "Baxter", "carol.baxter@revature.com",
                Title.HR_DIRECTOR, Department.HR, cto.getId(), metadata);
        employeeRepo.save(dirHr).block();

        Employee mngrTech = new Employee("5e768d0ef21b4b41fbbd3c57", "Steven", "Kelsey", "steven.kelsey@revature.com",
                Title.MANAGER_OF_TECH, Department.TRAINING, vpTech.getId(), metadata);
        employeeRepo.save(mngrTech).block();

        Employee stgMngr = new Employee("5e768d0ef21b4b41fbbd3c58", "Julie", "Seals", "julie.seals@revature.com",
                Title.STAGING_MANAGER, Department.TRAINING, dirTech.getId(), metadata);
        employeeRepo.save(stgMngr).block();

        Employee hrMngr = new Employee("5e768d0ef21b4b41fbbd3c59", "Patricia", "Nevins", "patricia.nevins@revature.com",
                Title.HR_MNGR, Department.HR, dirHr.getId(), metadata);
        employeeRepo.save(hrMngr).block();

        Employee leadTrainer1 = new Employee("5e768d0ef21b4b41fbbd3c5a", "August", "Duet", "august.duet@revature.com",
                Title.LEAD_TRAINER, Department.TRAINING, mngrTech.getId(), metadata);
        employeeRepo.save(leadTrainer1).block();

        Employee leadTrainer2 = new Employee("5e768d0ef21b4b41fbbd3c5b", "Nickolas", "Jurczak", "nickolas.jurczak@revature.com",
                Title.LEAD_TRAINER, Department.TRAINING, mngrTech.getId(), metadata);
        employeeRepo.save(leadTrainer2).block();

        Employee srTrainer1 = new Employee("5e768d0ef21b4b41fbbd3c5c", "Mitchell", "Goshorn", "mitchell.goshorn@revature.com",
                Title.SENIOR_TRAINER, Department.TRAINING, mngrTech.getId(), metadata);
        employeeRepo.save(srTrainer1).block();

        Employee srTrainer2 = new Employee("5e768d0ef21b4b41fbbd3c5d", "Wezley", "Singleton", "wezley.singleton@revature.com",
                Title.SENIOR_TRAINER, Department.TRAINING, mngrTech.getId(), metadata);
        employeeRepo.save(srTrainer2).block();

        Employee srTrainer3 = new Employee("5e768d0ef21b4b41fbbd3c5e", "Jason", "Knighten", "jason.knighten@revature.com",
                Title.SENIOR_TRAINER, Department.TRAINING, mngrTech.getId(), metadata);
        employeeRepo.save(srTrainer3).block();

        Employee srTrainer4 = new Employee("5e768d0ef21b4b41fbbd3c5f", "Trevin", "Chester", "wezley.singleton@revature.com",
                Title.SENIOR_TRAINER, Department.TRAINING, mngrTech.getId(), metadata);
        employeeRepo.save(srTrainer4).block();
        Employee trainer1 = new Employee("5e768d0ef21b4b41fbbd3c60", "Robert", "Connell", "robert.connell@revature.com",
                Title.TRAINER, Department.TRAINING, mngrTech.getId(), metadata);
        employeeRepo.save(trainer1).block();

        Employee trainer2 = new Employee("5e768d0ef21b4b41fbbd3c61", "Jacob", "Davis", "jacob.davis@revature.com",
                Title.TRAINER, Department.TRAINING, mngrTech.getId(), metadata);
        employeeRepo.save(trainer2).block();

        Employee trainer3 = new Employee("5e768d0ef21b4b41fbbd3c62", "Marielle", "Noalesco", "marielle.noalesco@revature.com",
                Title.TRAINER, Department.TRAINING, mngrTech.getId(), metadata);
        employeeRepo.save(trainer3).block();

        Employee qcAnalyst1 = new Employee("5e768d0ef21b4b41fbbd3c63", "Jonathan", "Gworek", "jonathan.gworek@revature.com",
                Title.QUALITY_ANALYST, Department.TRAINING, dirTech.getId(), metadata);
        employeeRepo.save(qcAnalyst1).block();

        Employee hr1 = new Employee("5e768d0ef21b4b41fbbd3c64", "Desiree", "Saroniero", "desiree.saroniero@revature.com",
                Title.HR_SPECIALIST, Department.HR, hrMngr.getId(), metadata);
        employeeRepo.save(hr1).block();

        Employee dirEmp = new Employee("5e768d0ef21b4b41fbbd3c65", "Kyle", "Taylor", "kyle.taylor@revature.com",
                Title.DIRECTOR_EMP_ENGAGEMENT, Department.DELIVERY, cso.getId(), metadata);
        employeeRepo.save(dirEmp).block();

        Employee vpRec = new Employee("5e768d0ef21b4b41fbbd3c66", "Elsa", "Burns", "elsa.burns@revature.com",
                Title.VP_OF_RECRUITMENT, Department.RECRUITMENT, ceo.getId(), metadata);
        employeeRepo.save(vpRec).block();

        Employee assocDirRec = new Employee("5e768d0ef21b4b41fbbd3c67", "Adrian", "Nesbeth", "adrian.nesbeth@revature.com",
                Title.ASSOC_DIRECTOR_OF_RECRUIT, Department.RECRUITMENT, vpRec.getId(), metadata);
        employeeRepo.save(assocDirRec).block();

        Employee assocMentor = new Employee("5e768d0ef21b4b41fbbd3c68", "Katie", "Barakat", "katie.barakat@revature.com",
                Title.ASSOCIATE_MENTOR, Department.RECRUITMENT, assocDirRec.getId(), metadata);
        employeeRepo.save(assocMentor).block();


        System.out.println("DATA SOURCE INIT COMPLETE");

    }

}
