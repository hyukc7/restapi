package com.hyuk.restapi.Controller;

import com.hyuk.restapi.Models.Employee;
import com.hyuk.restapi.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> all() {
        return this.employeeService.findAll();
    }

    @PostMapping("/employees")
    public Employee newEmployee(@RequestBody Employee newEmployee) {
        return this.employeeService.save(newEmployee);
    }

    @GetMapping("/employees/{id}")
    public Employee one(@PathVariable Long id) {
        return this.employeeService.one(id);
    }

    @GetMapping("/employees/{name}/{role}")
    public Employee getByNameRole(@PathVariable String name, @PathVariable String role) {
        return this.employeeService.getByNameRole(name, role).get(0);
    }

    @PutMapping("/employees/{id}")
    public Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
        return this.employeeService.replaceEmployee(id, newEmployee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        this.employeeService.deleteById(id);
    }
}