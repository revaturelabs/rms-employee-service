package com.revature.rms.employee.controllers;

import com.revature.rms.core.controllers.ResourceController;
import com.revature.rms.core.exceptions.NoImplementationException;
import com.revature.rms.core.models.Resource;
import com.revature.rms.employee.documents.Employee;
import com.revature.rms.employee.services.EmployeeService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/employees")
public class EmployeeController extends ResourceController<Employee> {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService service) {
        super(service);
        this.employeeService = service;
    }

    @GetMapping(value="/department/{dept}")
    public Flux<Employee> getEmployeesByDepartment(@PathVariable String dept) {
        return employeeService.findEmployeesByDepartment(dept);
    }

    @GetMapping(value="/managerId/{managerId}")
    public Flux<Employee> getEmployeesByManagerId(@PathVariable String managerId) {
        return employeeService.findEmployeesByManagerId(managerId);
    }

}
