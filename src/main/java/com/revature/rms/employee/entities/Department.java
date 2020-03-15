package com.revature.rms.employee.entities;

import com.revature.rms.employee.exceptions.EnumMappingException;

public enum Department {

    TRAINING("Training"), DELIVERY("Delivery"), RECRUITMENT("Recruitment"),
    HR("Human Resources");

    private String departmentName;

    Department(String name) {
        this.departmentName = name;
    }

    @Override
    public String toString() {
        return departmentName;
    }

    public static Department findByName(String name) {

        Department match = null;

        for (Department dept : Department.values()) {
            if (dept.departmentName.equalsIgnoreCase(name)) {
                match = dept;
            }
        }

        if (match == null) throw new EnumMappingException("No department match found!");

        return match;

    }

}
