package com.hyuk.restapi.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hyuk.restapi.Models.Employee;
import com.hyuk.restapi.Services.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class EmployeeControllerTest {

    private MockMvc mockMvc;

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    void testGetAllEmployees() throws Exception {
        // Arrange
        List<Employee> employees = Arrays.asList(new Employee(1L, "John", "Developer"));
        when(employeeService.findAll()).thenReturn(employees);

        // Act and Assert
        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("John"))
                .andExpect(jsonPath("$[0].role").value("Developer"));

        // Verify
        verify(employeeService, times(1)).findAll();
        verifyNoMoreInteractions(employeeService);
    }

    @Test
    void testCreateNewEmployee() throws Exception {
        // Arrange
        Employee newEmployee = new Employee(null, "Alice", "Manager");
        when(employeeService.save(any(Employee.class))).thenReturn(new Employee(1L, "Alice", "Manager"));

        // Act and Assert
        mockMvc.perform(post("/employees")
                        .content(new ObjectMapper().writeValueAsString(newEmployee))
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Alice"))
                .andExpect(jsonPath("$.role").value("Manager"));

        // Verify
        verify(employeeService, times(1)).save(any(Employee.class));
        verifyNoMoreInteractions(employeeService);
    }
}
