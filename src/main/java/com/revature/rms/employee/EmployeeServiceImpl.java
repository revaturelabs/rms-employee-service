package com.revature.rms.employee;

import com.revature.rms.employee.dtos.EmployeeResource;
import com.revature.rms.employee.dtos.GetEmployeeByFieldRequest;
import com.revature.rms.employee.dtos.NewEmployeeRequest;
import com.revature.rms.employee.entities.Department;
import com.revature.rms.employee.entities.Employee;
import com.revature.rms.employee.entities.ResourceMetadata;
import com.revature.rms.employee.entities.Title;
import com.revature.rms.employee.exceptions.EnumMappingException;
import com.revature.rms.employee.exceptions.InvalidRequestException;
import com.revature.rms.employee.exceptions.ResourceNotFoundException;
import com.revature.rms.employee.exceptions.ResourcePersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;

// TODO document class and methods

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repo) {
        employeeRepo = repo;
    }

    public Flux<EmployeeResource> getAllEmployees() {
        return this.employeeRepo.findAll().map(EmployeeResource::new);
    }

    public Flux<EmployeeResource> getEmployeesByField(GetEmployeeByFieldRequest request) {

        if (request == null || request.getField() == null || request.getValues() == null
            || request.getField().isEmpty() || request.getValues().length == 0)
        {
            throw new InvalidRequestException("Invalid request object provided.");
        }


        Flux<EmployeeResource> result = Flux.empty();

        switch (request.getField().toLowerCase()) {

            case "id":
                result = getEmployeesByIds(request.getValues());
                break;

            case "email":
                result = getEmployeeByEmail(request.getValues()[0]).flux();
                break;

            case "department":
                result = getEmployeesByDepartment(request.getValues()[0]);
                break;

            case "title":
                result = getEmployeesByTitle(request.getValues()[0]);
                break;

        }

        return result.switchIfEmpty(Mono.error(new ResourceNotFoundException("No resources found with provided field data.")));

    }

    public Mono<EmployeeResource> saveNewEmployee(NewEmployeeRequest request) {

        LocalDateTime creationDT = LocalDateTime.now();
        ResourceMetadata metadata = new ResourceMetadata(1, creationDT, 1, creationDT, 1);

        Employee newEmp = new Employee()
            .setFirstName(request.getFirstName())
            .setLastName(request.getLastName())
            .setEmail(request.getEmail())
            .setManagerId(request.getManagerId())
            .setTitle(Title.findByName(request.getTitle()))
            .setDepartment(Department.findByName(request.getDepartment()))
            .setMetadata(metadata);

        return employeeRepo.save(newEmp)
                           .switchIfEmpty(Mono.error(new ResourcePersistenceException("Could not persist employee.")))
                           .map(EmployeeResource::new);

    }

    // TODO implement EmployeeServiceImpl.updateEmployee
    public Mono<Void> updateEmployee(EmployeeResource updatedEmp) {
        return null;
    }

    // TODO implement EmployeeServiceImpl.deactivateEmployeeById
    public Mono<Void> deactivateEmployeeById(String id) {
        return null;
    }

    private Flux<EmployeeResource> getEmployeesByIds(String... ids) {
        Collection<String> id = Arrays.asList(ids);
        return this.employeeRepo.findAllById(id).map(EmployeeResource::new);
    }

    private Flux<EmployeeResource> getEmployeesByDepartment(String deptString) {

        Department dept = null;

        try {
            dept = Department.findByName(deptString);
        } catch (EnumMappingException e) {
            throw new InvalidRequestException(e);
        }

        return this.employeeRepo.findEmployeesByDepartment(dept).map(EmployeeResource::new);
    }

    private Flux<EmployeeResource> getEmployeesByTitle(String titleString) {

        Title title = null;

        try {
            title = Title.findByName(titleString);
        } catch (EnumMappingException e) {
            throw new InvalidRequestException(e);
        }

        return this.employeeRepo.findEmployeesByTitle(title).map(EmployeeResource::new);
    }

    private Mono<EmployeeResource> getEmployeeByEmail(String email) {
        return this.employeeRepo.findEmployeeByEmail(email).map(EmployeeResource::new);
    }

}
