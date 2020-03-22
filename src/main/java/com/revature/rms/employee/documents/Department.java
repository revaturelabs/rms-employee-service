package com.revature.rms.employee.documents;

import com.revature.rms.core.exceptions.EnumMappingException;

import java.util.Arrays;

public enum Department {

    EXECUTIVE("Executive"),
    TRAINING("Training"),
    HR("Human Resources"),
    RECRUITMENT("Recruitment"),
    DELIVERY("Delivery"),
    FINANCE("Finance"),
    MARKETING("Marketing");

    private String departmentName;

    Department(String name) {
        this.departmentName = name;
    }

    @Override
    public String toString() {
        return departmentName;
    }

    public static Department findByName(String name) {

        return Arrays.stream(Department.values())
              .filter(dept -> dept.departmentName.equals(name))
              .findFirst()
              .orElseThrow(EnumMappingException::new);

    }

}
