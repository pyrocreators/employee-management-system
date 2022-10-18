package com.example.employeemanagement.controller;

import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.exception.EmployeeNotFoundException;
import com.example.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String mainPage(Model model) {
        model.addAttribute("listEmployee", employeeService.getAllEmployee());
        return "employees-page";
    }

    @GetMapping("/newEmployeeForm")
    public String showEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new-employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        //  save new employee and updated
        employeeService.saveEmp(employee);
        return "redirect:/employee";
    }

    @GetMapping("/updateForm/{id}")
    public String updateEmployee(Model model, @PathVariable(value = "id") Integer id)
            throws EmployeeNotFoundException {
        Employee employee = employeeService.getEmployeeByid(id);
        model.addAttribute("employee", employee);
        return "update-employee";
    }

    @GetMapping("/deleteForm/{id}")
    public String deleteEmployee(Model model, @PathVariable(value = "id") Integer id) {
        employeeService.deleteEmployeeByid(id);
        return "redirect:/employee";
    }

}
