package com.hyuk.restapi.CustomExceptions;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(Long employeeId) {
        super(String.format("Employee ID, %d, not found", employeeId));
    }
}



