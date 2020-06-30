package com.revature.rms.employee.documents;

import com.revature.rms.core.exceptions.EnumMappingException;

import java.util.Arrays;

public enum Title {

    // Executive Department
    CEO("Chief Executive Officer"),
    CSO("Chief Strategy Officer"),

    // Training Department
    CTO("Chief Technology Officer"),
    VP_OF_TECH("Vice President of Technology"),
    DIRECTOR_OF_TECH("Director of Technology"),
    MANAGER_OF_TECH("Manager of Technology"),
    STAGING_MANAGER("Staging Manager"),
    PRINCIPAL_TRAINER("Principal Trainer"),
    LEAD_TRAINER("Lead Trainer"),
    SENIOR_TRAINER("Senior Trainer"),
    TRAINER("Trainer"),
    TRAINING_ASSISTANT("Training Assistant"),
    LEAD_QC_ANALYST("Lead QC Analyst"),
    QUALITY_ANALYST("Quality Analyst"),
    ASSOCIATE("Associate"),
    SOFTWARE_DEV("Software Developer"),

    // HR Department
    HR_DIRECTOR("HR Director"),
    SENIOR_HR_MNGR("Senior HR Manager"),
    HR_MNGR("HR Employee Experience Manager"),
    HR_SPECIALIST("HR Specialist"),

    // Recruitment Department
    VP_OF_RECRUITMENT("Vice President of Recruitment"),
    SENIOR_DIRECTOR_OF_RECRUIT("Senior Director of Recruitment"),
    ASSOC_DIRECTOR_OF_RECRUIT("Associate Director of Recruitment"),
    ASSOCIATE_MENTOR("Associate Mentor"),
    TECHNICAL_RECRUITER("Technical Recruiter"),

    // Delivery Department
    DIRECTOR_EMP_ENGAGEMENT("Director of Employee Engagement"),

    // Finance Department
    CFO("Chief Financial Officer"),

    // Other
    LOCKED("Locked");

    private String titleName;

    Title(String name) {
        this.titleName = name;
    }

    @Override
    public String toString() {
        return titleName;
    }

    public static Title findByName(String name) {

        return Arrays.stream(Title.values())
                .filter(t -> t.titleName.equals(name))
                .findFirst()
                .orElseThrow(EnumMappingException::new);

    }
}
