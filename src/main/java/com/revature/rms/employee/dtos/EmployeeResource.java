package com.revature.rms.employee.dtos;

import com.revature.rms.employee.entities.Department;
import com.revature.rms.employee.entities.ResourceMetadata;
import com.revature.rms.employee.entities.Title;

public class EmployeeDTO {
    
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Title title;
    private Department department;
    private ResourceMetadata metadata;

    public EmployeeDTO(String fn, String ln, String email, Title title, Department dept, ResourceMetadata metadata) {
        this.firstName = fn;
        this.lastName = ln;
        this.email = email;
        this.title = title;
        this.department = dept;
        this.metadata = metadata;
    }

    public EmployeeDTO(Integer id, String fn, String ln, String email, Title title, Department dept, ResourceMetadata metadata) {
        this.id = id;
        this.firstName = fn;
        this.lastName = ln;
        this.email = email;
        this.title = title;
        this.department = dept;
        this.metadata = metadata;
    }


}
