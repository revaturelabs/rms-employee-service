package com.revature.rms.employee.controllers;

import com.revature.rms.core.controllers.ResourceController;
import com.revature.rms.employee.entities.Employee;
import com.revature.rms.employee.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController extends ResourceController<Employee> {

    public EmployeeController(EmployeeService service) {
        super(service);
    }

}
