package com.revature.rms.employee;

import com.revature.rms.employee.entities.Department;
import com.revature.rms.employee.entities.Employee;
import com.revature.rms.employee.entities.Title;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {

    Flux<Employee> findEmployeesByDepartment(Department dept);
    Flux<Employee> findEmployeesByTitle(Title title);
    Mono<Employee> findEmployeeByEmail(String email);

}
