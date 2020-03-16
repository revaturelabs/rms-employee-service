package com.revature.rms.employee.dtos;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class NewEmployeeRequest {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String email;

    private String managerId;

    @NotEmpty
    private String title;

    @NotEmpty
    private String department;

    public NewEmployeeRequest() {
        super();
    }

    public NewEmployeeRequest(String fn, String ln, String email, String mngrId, String title, String dept) {
        this.firstName = fn;
        this.lastName = ln;
        this.email = email;
        this.managerId = mngrId;
        this.title = title;
        this.department = dept;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewEmployeeRequest that = (NewEmployeeRequest) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(email, that.email) &&
                Objects.equals(managerId, that.managerId) &&
                Objects.equals(title, that.title) &&
                Objects.equals(department, that.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, managerId, title, department);
    }

    @Override
    public String toString() {
        return "NewEmployeeRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", managerId='" + managerId + '\'' +
                ", title='" + title + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

}
