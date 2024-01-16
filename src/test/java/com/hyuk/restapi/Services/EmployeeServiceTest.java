package com.hyuk.restapi.Services;

import com.hyuk.restapi.CustomExceptions.EmployeeNotFoundException;
import com.hyuk.restapi.Models.Employee;
import com.hyuk.restapi.Repositories.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {

    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        // Arrange
        List<Employee> employees = Arrays.asList(new Employee(1L, "John", "Developer"));
        when(repository.findAll()).thenReturn(employees);

        // Act
        List<Employee> result = employeeService.findAll();

        // Assert
        assertEquals(1, result.size());
        assertEquals("John", result.get(0).getName());
        assertEquals("Developer", result.get(0).getRole());

        // Verify
        verify(repository, times(1)).findAll();
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testDeleteById() {
        // Arrange
        Long idToDelete = 1L;

        // Act
        employeeService.deleteById(idToDelete);

        // Verify
        verify(repository, times(1)).deleteById(idToDelete);
        verifyNoMoreInteractions(repository);
    }

    // Add similar tests for other service methods (save, one, replaceEmployee, getByNameRole)

    @Test
    void testOneFound() {
        // Arrange
        Long id = 1L;
        Employee mockEmployee = new Employee(id, "John", "Developer");
        when(repository.findById(id)).thenReturn(Optional.of(mockEmployee));

        // Act
        Employee result = employeeService.one(id);

        // Assert
        assertEquals("John", result.getName());
        assertEquals("Developer", result.getRole());

        // Verify
        verify(repository, times(1)).findById(id);
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testOneNotFound() {
        // Arrange
        Long id = 1L;
        when(repository.findById(id)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.one(id));

        // Verify
        verify(repository, times(1)).findById(id);
        verifyNoMoreInteractions(repository);
    }

    // Add similar tests for other service methods (save, replaceEmployee, getByNameRole)
}
