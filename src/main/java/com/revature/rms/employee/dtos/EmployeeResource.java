package com.revature.rms.employee.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.revature.rms.employee.entities.Employee;
import com.revature.rms.employee.entities.ResourceMetadata;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class EmployeeResource {

    @NotEmpty
    private String id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String email;

    @NotEmpty
    private String title;

    @NotEmpty
    private String department;

    @NotEmpty
    private String managerId;

    private ResourceMetadata metadata;

    public EmployeeResource() {
        super();
    }

    public EmployeeResource(Employee employee) {

        this.id = employee.getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.email = employee.getEmail();
        this.title = employee.getTitle().toString();
        this.department = employee.getDepartment().toString();
        this.metadata = employee.getMetadata();
        this.managerId = employee.getManagerId();

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

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
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
                Objects.equals(title, that.title) &&
                Objects.equals(department, that.department) &&
                Objects.equals(metadata, that.metadata) &&
                Objects.equals(managerId, that.managerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, title, department, metadata, managerId);
    }

    @Override
    public String toString() {
        return "EmployeeResource{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", title='" + title + '\'' +
                ", department='" + department + '\'' +
                ", metadata=" + metadata + '\'' +
                ", managerId=" + managerId +
                '}';
    }

}
