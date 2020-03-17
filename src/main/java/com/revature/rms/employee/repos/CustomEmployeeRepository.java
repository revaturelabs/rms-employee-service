package com.revature.rms.employee.repos;

import com.revature.rms.employee.entities.Employee;
import reactor.core.publisher.Mono;

public interface CustomEmployeeRepository {
    Mono<Employee> deactivateUserById(String id);
}
