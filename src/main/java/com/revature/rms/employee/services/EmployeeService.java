package com.revature.rms.employee.services;

import com.revature.rms.core.services.AutoService;
import com.revature.rms.employee.repos.EmployeeRepository;
import com.revature.rms.employee.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;

// TODO document class and methods

@Service
public class EmployeeService extends AutoService<Employee> {

    private ReactiveMongoTemplate mongoTemplate;

    @Autowired
    public EmployeeService(EmployeeRepository repo, ReactiveMongoTemplate template) {
        super(repo, template);
    }

}
