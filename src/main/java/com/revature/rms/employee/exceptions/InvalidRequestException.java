package com.revature.rms.employee.exceptions;

public class InvalidRequestException extends RuntimeException {

    public InvalidRequestException() {
        super("An invalid request was made.");
    }

    public InvalidRequestException(String s) {
        super(s);
    }

    public InvalidRequestException(Throwable throwable) {
        super(throwable);
    }

    public InvalidRequestException(String s, Throwable throwable) {
        super(s, throwable);
    }

}
