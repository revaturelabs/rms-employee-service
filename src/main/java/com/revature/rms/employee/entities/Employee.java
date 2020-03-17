package com.revature.rms.employee.entities;

import com.revature.rms.employee.dtos.EmployeeResource;
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
    private String managerId;
    private Title title;
    private Department department;
    private ResourceMetadata metadata;

    public Employee() {
        super();
    }

    public Employee(EmployeeResource resource) {
        this.id = resource.getId();
        this.firstName = resource.getFirstName();
        this.lastName = resource.getLastName();
        this.email = resource.getEmail();
        this.managerId = resource.getManagerId();
        this.title = Title.findByName(resource.getTitle());
        this.department = Department.findByName(resource.getDepartment());
        this.metadata = resource.getMetadata();
    }

    public Employee(String fn, String ln, String email, String mngr, Title title, Department dept, ResourceMetadata metadata) {
        this.firstName = fn;
        this.lastName = ln;
        this.email = email;
        this.managerId = mngr;
        this.title = title;
        this.department = dept;
        this.metadata = metadata;
    }

    public Employee(String id, String fn, String ln, String email, String mngr, Title title, Department dept, ResourceMetadata metadata) {
        this(fn, ln, email, mngr, title, dept, metadata);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Employee setId(String id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Employee setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Employee setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Employee setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getManagerId() {
        return managerId;
    }

    public Employee setManagerId(String managerId) {
        this.managerId = managerId;
        return this;
    }

    public Title getTitle() {
        return title;
    }

    public Employee setTitle(Title title) {
        this.title = title;
        return this;
    }

    public Department getDepartment() {
        return department;
    }

    public Employee setDepartment(Department department) {
        this.department = department;
        return this;
    }

    public ResourceMetadata getMetadata() {
        return metadata;
    }

    public Employee setMetadata(ResourceMetadata metadata) {
        this.metadata = metadata;
        return this;
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
                Objects.equals(managerId, employee.managerId) &&
                department == employee.department &&
                Objects.equals(metadata, employee.metadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, title, managerId, department, metadata);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", title=" + title +
                ", manager='" + managerId + '\'' +
                ", department=" + department +
                ", metadata=" + metadata +
                '}';
    }

}
