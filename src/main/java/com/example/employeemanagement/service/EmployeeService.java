package com.example.employeemanagement.service;

import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.exception.EmployeeNotFoundException;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private static EmployeeRepository employeeRepository;

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public void saveEmp(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee getEmployeeByid(Integer id) throws EmployeeNotFoundException {
        Employee employee;
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent())
            employee = optionalEmployee.get();
        else
            throw new EmployeeNotFoundException("Employee with id: " + id + " not found");
        return employee;
    }

    @Secured(value = "ADMIN")
    public void deleteEmployeeByid(Integer id) {
        employeeRepository.deleteById(id);
    }
}
