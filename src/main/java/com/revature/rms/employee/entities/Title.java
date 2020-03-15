package com.revature.rms.employee.entities;

import com.revature.rms.employee.exceptions.EnumMappingException;

public enum Title {

    TRAINER("Trainer"), SENIOR_TRAINER("Senior Trainer"), LEAD_TRAINER("Lead Trainer"),
    PRINCIPAL_TRAINER("Principal Trainer"), STAGING_MANAGER("Staging Manager"), QUALITY_ANALYST("Quality Analyst"),
    MANAGER_OF_TECH("Manager of Technology"), HR_SPECIALIST("HR Specialist"), HR_LEAD("HR Manager"),
    DIRECTOR_EMP_ENGAGEMENT("Director of Employee Engagement"), ASSOCIATE_MENTOR("Associate Mentor"), LOCKED("Locked");

    private String titleName;

    Title(String name) {
        this.titleName = name;
    }

    @Override
    public String toString() {
        return titleName;
    }

    public static Title findByName(String name) {

        Title match = null;

        for (Title title : Title.values()) {
            if (title.titleName.equalsIgnoreCase(name)) {
                match = title;
            }
        }

        if (match == null) throw new EnumMappingException("No title match found!");

        return match;

    }
}
