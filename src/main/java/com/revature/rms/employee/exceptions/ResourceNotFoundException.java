package com.revature.rms.employee.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("No resources found with provided data.");
    }

    public ResourceNotFoundException(String s) {
        super(s);
    }

}
