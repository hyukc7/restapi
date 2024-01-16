package com.hyuk.restapi.Repositories;

import com.hyuk.restapi.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e from Employee e where e.name = :name and e.role = :role")
    List<Employee> findEmployeeByNameAndRole(@Param("name") String name, @Param("role") String role);
}