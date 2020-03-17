package com.revature.rms.employee.services;

import com.revature.rms.employee.dtos.EmployeeResource;
import com.revature.rms.employee.dtos.GetEmployeeByFieldRequest;
import com.revature.rms.employee.dtos.NewEmployeeRequest;
import com.revature.rms.employee.entities.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {

    Flux<EmployeeResource> getAllEmployees();
    Flux<EmployeeResource> getEmployeesByField(GetEmployeeByFieldRequest request);
    Mono<EmployeeResource> saveNewEmployee(NewEmployeeRequest request);
    Mono<Void> updateEmployee(EmployeeResource updatedEmp);
    Mono<Employee> deactivateEmployeeById(String id);

}
