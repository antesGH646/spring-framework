package com.cydeo.repository;

import com.cydeo.entity.Department;
import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Use repository when you want to bring data from a database. Since thymeleaf understands
 * java objects, create methods to manipulate the data, then display it on the UI.
 * When repositories make sure to extend the JpaRepository<repositoryName, dataType>
 * The common ways of writing queries are derived queries and @Query annotation queries.
 * Note that writing derived queries is good only with methods having 3-4 parameters, otherwise
 * it would be difficult or almost impossible to read and maintain these queries when adding,
 * filtering, comparison, and result size limiting. For this reason you rather use more flexible
 * queries such as JPQL (Java Persistence Query Language) or native SQL queries
 * (e.g. select * from tableName).
 * The @Query annotation is used for both JPQL and native queries
 * JPQL
 * Since JPQL supports the SQL subset standard, it is not a good
 * choice to use it for more complex queries. JPQL is an abstraction, it might have slight
 * performance issue (The flow is: JPQL => convert to sql ==> access database)
 * When writing JPQL queries through @Query annotations, you may specify parameters through
 * methods either positional parameter use ?parameterName or name-binding parameters.
 * Note that JPQL method names does not matter, it can be any descriptive name
 * In the method signature name-binding parameter uses the @Param("parameterName") annotation,
 * when writing the query uses :parameterName
 * Native SQL
 * To write native SQL make sure pass the nativeQuery = true into the @Query annotation
 * RollingBack
 * If anything happens during inserting, updating, and deleting, the data should roll back
 * to the original state. Use @Modifying, @Transactional annotations
 */
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
