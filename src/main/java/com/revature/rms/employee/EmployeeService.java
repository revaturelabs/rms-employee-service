package com.revature.rms.employee;

import com.revature.rms.employee.dtos.EmployeeResource;
import com.revature.rms.employee.dtos.GetEmployeeByFieldRequest;
import com.revature.rms.employee.dtos.NewEmployeeRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {

    Flux<EmployeeResource> getAllEmployees();
    Flux<EmployeeResource> getEmployeesByField(GetEmployeeByFieldRequest request);
    Mono<EmployeeResource> saveNewEmployee(NewEmployeeRequest request);
    Mono<Void> updateEmployee(EmployeeResource updatedEmp);
    Mono<Void> deactivateEmployeeById(String id);

}
