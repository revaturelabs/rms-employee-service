package com.revature.rms.employee;

import com.revature.rms.employee.dtos.EmployeeResource;
import com.revature.rms.employee.dtos.NewEmployeeRequest;
import com.revature.rms.employee.entities.Department;
import com.revature.rms.employee.entities.Employee;
import com.revature.rms.employee.entities.ResourceMetadata;
import com.revature.rms.employee.entities.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepository repo) {
        employeeRepo = repo;
    }

    public Flux<EmployeeResource> getAllEmployees() {
        return this.employeeRepo.findAll().map(EmployeeResource::new);
    }

    public Flux<EmployeeResource> getEmployeesByField(String field, String[] values) {

        Flux<EmployeeResource> result = Flux.empty();

        switch (field) {

            case "id":
                result = getEmployeesByIds(values);
                break;

            case "department":
                Department dept = Department.findByName(values[0]);
                result = this.employeeRepo.findEmployeesByDepartment(dept).map(EmployeeResource::new);
                break;

            case "title":
                Title title = Title.findByName(values[0]);
                result = this.employeeRepo.findEmployeesByTitle(title).map(EmployeeResource::new);
                break;

            default:
                throw new RuntimeException("Invalid field provided!");

        }

        return result;

    }

    public Mono<EmployeeResource> saveNewEmployee(NewEmployeeRequest newEmpResource) {

        LocalDateTime now = LocalDateTime.now();

        Employee newEmp = new Employee(newEmpResource);
        ResourceMetadata metadata = new ResourceMetadata(1, now, 1, now, 1);
        newEmp.setMetadata(metadata);

        return this.employeeRepo.save(newEmp).map(EmployeeResource::new);

    }

    protected Flux<EmployeeResource> getEmployeesByIds(String[] ids) {
        Collection<String> id = Arrays.asList(ids);
        return this.employeeRepo.findAllById(id).map(EmployeeResource::new);
    }

    protected Flux<EmployeeResource> getEmployeesByDepartment(String deptString) {
        Department dept = Department.findByName(deptString);
        return this.employeeRepo.findEmployeesByDepartment(dept).map(EmployeeResource::new);
    }

    protected Flux<EmployeeResource> getEmployeesByTitle(String titleString) {
        Title title = Title.findByName(titleString);
        return this.employeeRepo.findEmployeesByTitle(title).map(EmployeeResource::new);
    }

}
