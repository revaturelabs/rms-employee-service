package com.revature.rms.employee;

import com.revature.rms.employee.dtos.EmployeeResource;
import com.revature.rms.employee.dtos.NewEmployeeRequest;
import com.revature.rms.employee.entities.Department;
import com.revature.rms.employee.entities.Employee;
import com.revature.rms.employee.entities.ResourceMetadata;
import com.revature.rms.employee.entities.Title;
import com.revature.rms.employee.exceptions.EnumMappingException;
import com.revature.rms.employee.exceptions.InvalidRequestException;
import com.revature.rms.employee.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

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

    public Flux<EmployeeResource> getEmployeesByField(String field, String[] values) {

        Flux<EmployeeResource> result = Flux.empty();

        switch (field) {

            case "id":
                result = getEmployeesByIds(values);
                break;

            case "department":
                result = getEmployeesByDepartment(values[0]);
                break;

            case "title":
                result = getEmployeesByTitle(values[0]);
                break;

        }

        result.collectList().flatMap(list -> {

            if (list.isEmpty()) {
                return Mono.error(new ResourceNotFoundException("No resources found with provided field data."));
            }

            return Mono.just(list);

        });

        return result;

    }

    public Mono<EmployeeResource> saveNewEmployee(NewEmployeeRequest newEmpResource) {

        LocalDateTime now = LocalDateTime.now();

        Employee newEmp = new Employee(newEmpResource);
        ResourceMetadata metadata = new ResourceMetadata(1, now, 1, now, 1);
        newEmp.setMetadata(metadata);

        return this.employeeRepo.save(newEmp).map(EmployeeResource::new);

    }

    // TODO implement EmployeeServiceImpl.updateEmployee
    public Mono<Void> updateEmployee(EmployeeResource updatedEmp) {
        return null;
    }

    // TODO implement EmployeeServiceImpl.deactivateEmployeeById
    public Mono<Void> deactivateEmployeeById(String id) {
        return null;
    }

    private Flux<EmployeeResource> getEmployeesByIds(String[] ids) {
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

}
