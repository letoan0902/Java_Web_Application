package org.example.bai5.exceptions;

public class EmployeeNotFoundException extends RuntimeException {

    private final String code;

    public EmployeeNotFoundException(String code) {
        super("Employee not found: " + code);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}

