package com.example.employeemanagement.exception;

import org.springframework.data.crossstore.ChangeSetPersister;

public class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
