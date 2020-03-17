package com.revature.rms.employee.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.revature.rms.employee.entities.Employee;
import com.revature.rms.employee.entities.ResourceMetadata;

import java.util.Objects;

// TODO add JSR-303 annotations

public class EmployeeResource {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String managerId;
    private String title;
    private String department;
    private ResourceMetadata metadata;

    public EmployeeResource() {
        super();
    }

    public EmployeeResource(String id) {
        this.id = id;
    }

    public EmployeeResource(Employee employee) {

        this.id = employee.getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.email = employee.getEmail();
        this.title = employee.getTitle().toString();
        this.department = employee.getDepartment().toString();
        this.metadata = employee.getMetadata();

        if (employee.getManagerId() != null && !employee.getManagerId().isEmpty()) {
            this.managerId = employee.getManagerId();
        }

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

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public ResourceMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(ResourceMetadata metadata) {
        this.metadata = metadata;
    }

    @JsonIgnore
    public Employee getEmployeeEntity() {
        return new Employee(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeResource that = (EmployeeResource) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(email, that.email) &&
                Objects.equals(managerId, that.managerId) &&
                Objects.equals(title, that.title) &&
                Objects.equals(department, that.department) &&
                Objects.equals(metadata, that.metadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, managerId, title, department, metadata);
    }

    @Override
    public String toString() {
        return "EmployeeResource{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", manager=" + managerId +
                ", title='" + title + '\'' +
                ", department='" + department + '\'' +
                ", metadata=" + metadata +
                '}';
    }

}
