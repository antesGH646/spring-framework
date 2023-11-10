package com.mycy.repository;

import com.mycy.entity.Department;
import com.mycy.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, String> {
    //Display all Departments in the furniture division
    List<Department> findByDepartment(String department);

    //Display all Departments in the Health Division
    List<Department> findByDivisionIs   (String division);
    List<Department> findByDivisionEquals(String division);

    //Display top 3 departments with division name includes 'Hea', without duplicates
    List<Department> findDistinctTop3ByDivisionContains (String pattern);

    @Query("select d from Department d where d.division in ?1")
    List<Department> getDepartmentDepartmentIn(List<String> division);

    //Using native queries
    //to use pure sql queries add .nativeQuery = true, retrieves data from tables not through Class name
    @Query(value = "select * from employees where  salary ?1", nativeQuery = true)
    List<Department> readDepartmentDetailBySalary();

    //writing queries through named queries in properties file under META-INF folder
    // (without using @Query annotation)
    List<Employee> retrieveDepartmentByDivision(String division);

    //writing queries through named queries in properties file under META-INF folder,
    // using native queries
    @Query(nativeQuery = true)
    List<Department> retrieveDepartmentByDivisionContain(String pattern);

}
