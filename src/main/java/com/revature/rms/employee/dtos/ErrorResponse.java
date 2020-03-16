package com.revature.rms.employee.dtos;

import java.time.LocalDateTime;

public class ErrorResponse {

    private int status;
    private String timestamp;
    private String message;

    public ErrorResponse() {
        super();
    }

    public ErrorResponse(int status, String message) {
        this.status = status;
        this.timestamp = LocalDateTime.now().toString();
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

}
