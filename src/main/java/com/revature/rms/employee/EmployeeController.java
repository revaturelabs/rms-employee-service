package com.revature.rms.employee;

import com.revature.rms.employee.dtos.EmployeeResource;
import com.revature.rms.employee.dtos.ErrorResponse;
import com.revature.rms.employee.dtos.GetEmployeeByFieldRequest;
import com.revature.rms.employee.dtos.NewEmployeeRequest;
import com.revature.rms.employee.exceptions.InvalidRequestException;
import com.revature.rms.employee.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

// TODO document class and methods

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeServiceImpl employeeService;

    @Autowired
    public EmployeeController(EmployeeServiceImpl service) {
        this.employeeService = service;
    }

    @GetMapping
    public Flux<EmployeeResource> getAllEmployees() {
        return this.employeeService.getAllEmployees();
    }

    @GetMapping(value = "/field")
    public Flux<EmployeeResource> getEmployeesByField(@RequestBody @Valid GetEmployeeByFieldRequest request) {
        return this.employeeService.getEmployeesByField(request);
    }

    @PostMapping
    public Mono<EmployeeResource> saveNewEmployee(@RequestBody @Valid NewEmployeeRequest newEmployee) {
        return this.employeeService.saveNewEmployee(newEmployee);
    }

    @PatchMapping
    public Mono<Void> updateEmployee(@RequestBody @Valid EmployeeResource updatedEmployee) {
        return this.employeeService.updateEmployee(updatedEmployee);
    }

    @DeleteMapping(value = "/{id}")
    public Mono<Void> deactivateEmployeeById(@PathVariable String id) {
        return this.employeeService.deactivateEmployeeById(id);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Mono<ErrorResponse> handleResourceNotFound(ResourceNotFoundException e) {
        return Mono.just(new ErrorResponse(404, e.getMessage()));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Mono<ErrorResponse> handleInvalidRequest(InvalidRequestException e) {
        return Mono.just(new ErrorResponse(400, e.getMessage()));
    }

}
