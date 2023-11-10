package com.mycy.repository;

import com.mycy.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    //Display all employees with email address
    List<Employee> findByEmail(String email);

    //Display all employees with first name plus and last name and email address
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String mail);

    //Display all employees that their first name is not ' '
    List<Employee> findByFirstNameIsNot(String firstName);

    //Display all employees where their last name starts with ' '
    List<Employee> findByLastNameStartsWith(String lastName);

    //Display all employees where their salaries is higher than ' '
    List<Employee> findBySalaryIsGreaterThan(Integer salary);

    //Display all employees where their salaries is less than ' '
    List<Employee> findBySalaryIsLessThan(Integer salary);

    //Display all employees where their salaries is less than equal to ' '
    List<Employee> findBySalaryIsLessThanEqual(Integer salary);

    //Display all employees hired between dates -- and --
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    //Display all employees where their salaries is greater equal in descending order
    List<Employee> findBySalaryIsGreaterThanEqualOrOrderBySalaryDesc(Integer salary);

    //Display to 3 employees that make salary less than --
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    //Display employees that do not have email address
    List<Employee> findByEmailIsNull();

    //writing JPQL queries with hard coded email
    @Query("select e from Employee e where e.email = 'fmorffew4@a8.net'")
    Employee getEmployeeDetail();

    //writing JPQL queries to extract employee salary, can use more parameters,
    // but specify their positions in the query
    @Query("select e.salary from Employee e where e.email = 'fmorffew4@a8.net'")
    Employee getEmployeeSalary();

    //can use parameters either positional or name binding, writing positional parameter
    //Use Optional to avoid null pointer exception, writing positional parameter
    @Query("select e from Employee e where e.email = ?1")//? marks position/index of the parameter
    Optional<Employee> getEmployeeDetail(String email);

    //position starts from 1, there are two positions 1 and 2
    @Query("select e.salary from Employee e where e.email = ?1 and e.salary = ?2")
    Employee getEmployeeSalary(String email, int salary);

    //Not equal
    @Query("SELECT e from Employee e where e.salary <> ?1")
    Employee getEmployeeSalaryNotEqual(int salary);

    //like/contains/startswith/endswith
    @Query("select e from Employee e where e.firstName like ?1")
    List<Employee> getEmployeeFirstNameLike(String pattern);

    //less than
    @Query("select e from Employee e where e.salary < ?1")
    List<Employee> getEmployeeSalaryLessThan(int salary);

    //greater than
    @Query("select e from Employee e where e.salary > ?1")
    List<Employee> getEmployeeSalaryGreaterThan(int salary);

    //before
    @Query("select e from Employee e where e.hireDate > ?1")
    List<Employee> getEmployeeHireDateBefore(LocalDate before);

    //between
    @Query("select e from Employee e where e.salary between ?1 and ?2")
    List<Employee> getEmployeeSalaryBetween(int start, int end);

    //is Null
    @Query("select e from Employee e where e.email is null")
    Optional<Employee> getEmployeesIsNull();

    //is not Null
    @Query("select e from Employee e where e.email is not null")
    Optional<Employee> getEmployeesIsNotNull();

    //sorting in ascending, it is optional to add asc, the order ascends automatically
    @Query("select e from Employee e order by e.salary asc")
    List<Employee> getEmployeeSalaryOrderAsc(int salary);

    //sorting in descending
    @Query("select e from Employee e order by e.salary DESC")
    List<Employee> getEmployeeSalaryOrderDesc(int salary);

    //Using native queries, declare the name by @Param("name"), assign the name by :parameterName
    @Query(value = "select e from Employee e where salary = :salary", nativeQuery = true)
    List<Employee> getEmployeeSalary(@Param("salary") int salary);

    //rolling back with JPQL query
    @Modifying
    @Transactional
    @Query("UPDATE Employee e SET e.email = 'admin@email.com' WHERE e.id=:id")
    void updateEmployeeJPQL(@Param("id") int id);

    //rolling back with native query
    @Modifying
    @Transactional
    @Query(value = "UPDATE employees SET email = 'admin@email.com' WHERE id=:id",nativeQuery = true)
    void updateEmployeeNativeQuery(@Param("id") int id);
}
