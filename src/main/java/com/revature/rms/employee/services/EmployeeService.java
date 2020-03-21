package com.revature.rms.employee.services;

import com.revature.rms.core.services.ResourceService;
import com.revature.rms.employee.repos.EmployeeRepository;
import com.revature.rms.employee.entities.Employee;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService extends ResourceService<Employee> {

    public EmployeeService(EmployeeRepository repo, ReactiveMongoTemplate template) {
        super(repo, template);
    }

}
