package com.hyuk.restapi.Services;

import com.hyuk.restapi.CustomExceptions.EmployeeNotFoundException;
import com.hyuk.restapi.Models.Employee;
import com.hyuk.restapi.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository repository;

    public List<Employee> findAll() {

        return this.repository.findAll();
    }

    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    public Employee save(Employee newEmployee) {
        return this.repository.save(newEmployee);
    }

    public Employee one(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    public Employee replaceEmployee(Long id, Employee newEmployee) {
        return this.repository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
    }

    public List<Employee> getByNameRole(String name, String role) {
        return this.repository.findEmployeeByNameAndRole(name, role);
    }
}
