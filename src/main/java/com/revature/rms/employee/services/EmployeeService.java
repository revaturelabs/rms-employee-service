package com.revature.rms.employee.services;

import com.revature.rms.core.services.ResourceService;
import com.revature.rms.employee.documents.Department;
import com.revature.rms.employee.repos.EmployeeRepository;
import com.revature.rms.employee.documents.Employee;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService extends ResourceService<Employee> {

    private final EmployeeRepository employeeRepo;

    public EmployeeService(EmployeeRepository repo, ReactiveMongoTemplate template) {
        super(repo, template, Employee.class);
        this.employeeRepo = repo;
    }

    public Flux<Employee> findEmployeesByDepartment(String dept) {
        return employeeRepo.findEmployeesByDepartment(Department.findByName(dept));
    }

    public Flux<Employee> findEmployeesByManagerId(String managerId) {
        return employeeRepo.findEmployeesByManagerId(managerId);
    }

    public Mono<Employee> findEmployeeByEmail(String email) {
        return employeeRepo.findEmployeeByEmail(email);
    }

}
