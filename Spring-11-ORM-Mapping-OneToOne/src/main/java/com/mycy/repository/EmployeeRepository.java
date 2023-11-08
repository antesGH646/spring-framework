package com.mycy.repository;

import com.mycy.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//pass the entity name and the primary type
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
