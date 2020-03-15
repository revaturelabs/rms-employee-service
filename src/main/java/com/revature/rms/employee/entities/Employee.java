package com.revature.rms.employee.entities;

import com.revature.rms.employee.dtos.EmployeeResource;
import com.revature.rms.employee.dtos.NewEmployeeRequest;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Employee {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Title title;
    private Department department;
    private ResourceMetadata metadata;

    public Employee() {
        super();
    }

    public Employee(EmployeeResource empResource) {
        this.firstName = empResource.getFirstName();
        this.lastName = empResource.getLastName();
        this.email = empResource.getEmail();
        this.title = Title.findByName(empResource.getTitle());
        this.department = Department.findByName(empResource.getDepartment());
        this.metadata = empResource.getMetadata();
    }

    public Employee(NewEmployeeRequest newEmployee) {
        this.firstName = newEmployee.getFirstName();
        this.lastName = newEmployee.getLastName();
        this.email = newEmployee.getEmail();
        this.title = Title.findByName(newEmployee.getTitle());
        this.department = Department.findByName(newEmployee.getDepartment());
    }

    public Employee(String fn, String ln, String email, Title title, Department dept, ResourceMetadata metadata) {
        this.firstName = fn;
        this.lastName = ln;
        this.email = email;
        this.title = title;
        this.department = dept;
        this.metadata = metadata;
    }

    public Employee(String id, String fn, String ln, String email, Title title, Department dept, ResourceMetadata metadata) {
        this(fn, ln, email, title, dept, metadata);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public ResourceMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(ResourceMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(email, employee.email) &&
                title == employee.title &&
                department == employee.department &&
                Objects.equals(metadata, employee.metadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, title, department, metadata);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", title=" + title +
                ", department=" + department +
                ", metadata=" + metadata +
                '}';
    }

}
