package com.revature.rms.employee.entities;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.revature.rms.core.models.Resource;
import com.revature.rms.core.models.ResourceMetadata;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Data model representation of an Employee entity.
 */
@Document
@JsonPropertyOrder({
        "id",
        "firstName",
        "lastName",
        "email",
        "title",
        "department",
        "managerId",
        "metadata"
})
public class Employee extends Resource {

    @NotNull @NotEmpty
    private String firstName;

    @NotNull @NotEmpty
    private String lastName;

    @NotNull @NotEmpty
    private String email;

    @NotNull
    private Title title;

    @NotNull
    private Department department;

    @NotNull @NotEmpty
    private String managerId;

    public Employee() {
        super();
    }

    public Employee(@NotNull @NotEmpty String firstName, @NotNull @NotEmpty String lastName, @NotNull @NotEmpty String email,
                    @NotNull Title title, @NotNull Department department, String managerId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.title = title;
        this.department = department;
        this.managerId = managerId;
    }

    public Employee(@NotNull @NotEmpty String firstName, @NotNull @NotEmpty String lastName, @NotNull @NotEmpty String email,
                    @NotNull Title title, @NotNull Department department, String managerId, ResourceMetadata metadata) {
        this(firstName, lastName, email, title, department, managerId);
        this.metadata = metadata;
    }

    public Employee(String id, @NotNull @NotEmpty String firstName, @NotNull @NotEmpty String lastName,
                    @NotNull @NotEmpty String email, @NotNull Title title, @NotNull Department department,
                    String managerId, ResourceMetadata metadata) {
        this(firstName, lastName, email, title, department, managerId, metadata);
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return firstName.equals(employee.firstName) &&
                lastName.equals(employee.lastName) &&
                email.equals(employee.email) &&
                title == employee.title &&
                department == employee.department &&
                managerId.equals(employee.managerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, title, department, managerId);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", title=" + title +
                ", department=" + department +
                ", managerId='" + managerId + '\'' +
                ", metadata=" + metadata +
                '}';
    }
}
