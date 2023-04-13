package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//pass the entity name and the primary type
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
