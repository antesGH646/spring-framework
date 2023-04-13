package com.cydeo.repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

//pass the entity name and the primary type
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
