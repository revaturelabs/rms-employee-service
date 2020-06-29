package com.revature.rms.employee.repos;

import com.revature.rms.employee.documents.Department;
import com.revature.rms.employee.documents.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {

    Flux<Employee> findEmployeesByDepartment(Department department);
    Flux<Employee> findEmployeesByManagerId(String managerId);
    Mono<Employee> findEmployeeByEmail(String email);

}
