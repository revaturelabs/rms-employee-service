package com.revature.rms.employee.controllers;

import com.revature.rms.core.controllers.AutoController;
import com.revature.rms.employee.entities.Employee;
import com.revature.rms.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController extends AutoController<Employee> {

    @Autowired
    public EmployeeController(EmployeeService service) {
        super(service);
    }

}
