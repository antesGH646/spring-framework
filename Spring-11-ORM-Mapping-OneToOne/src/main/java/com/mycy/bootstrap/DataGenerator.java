package com.mycy.bootstrap;

import com.mycy.entity.Department;
import com.mycy.entity.Employee;
import com.mycy.entity.Region;
import com.mycy.enums.Gender;
import com.mycy.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataGenerator implements CommandLineRunner {

    EmployeeRepository employeeRepository;
    //DepartmentRepository departmentRepository;
    //RegionRepository regionRepository;

    public DataGenerator(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
       // this.departmentRepository = departmentRepository;
       // this.regionRepository = regionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Employee> employeeList = new ArrayList<>();
        List<Department> departmentList = new ArrayList<>();
        List<Region> regionList = new ArrayList<>();

        Employee e1 = new Employee("Berrie", "Manueau", "bmanueau0@dion.ne.jp", LocalDate.of(2006,04,20),154864, Gender.FEMALE);
        Employee e2 = new Employee("Aeriell", "McNee", "amcnee1@google.es", LocalDate.of(2009,01,26),56752, Gender.FEMALE);
        Employee e3 = new Employee("Sydney", "Symonds", "ssymonds2@hhs.gov", LocalDate.of(2010,05,17),95313, Gender.FEMALE);
        Employee e4 = new Employee("Avrom", "Rowantree", null, LocalDate.of(2014,03,02) ,119764,Gender.MALE);
        Employee e5 = new Employee("Feliks", "Morffew", "fmorffew4@a8.net", LocalDate.of(2003,01,14), 55307,Gender.MALE);

        Department d1 = new Department("Sports","Outdoors");
        Department d2 = new Department("Tools","Hardware");
        Department d3 = new Department("Clothing","Home");
        Department d4 = new Department("Phones & Tablets","Electronics");
        Department d5 = new Department("Computers","Electronics");

        Region r1 = new Region("Southwest","United States");
        Region r2 = new Region("Central","United States");
        Region r3 = new Region("Northwest","United States");
        Region r4 = new Region("Quebec'","Canada");
        Region r5 = new Region("Central","Asia");

        //setting employees to departments
        e1.setDepartment(d1);
        e2.setDepartment(d2);
        e3.setDepartment(d3);
        e3.setDepartment(d4);
        e3.setDepartment(d5);

        //setting the employees to regions
        e1.setRegion(r1);
        e2.setRegion(r2);
        e3.setRegion(r3);
        e4.setRegion(r4);
        e5.setRegion(r5);

        employeeList.addAll(Arrays.asList(e1,e2,e3,e4,e5));
        departmentList.addAll(Arrays.asList(d1,d2,d3,d4,d5));
        regionList.addAll(Arrays.asList(r1,r2,r3,r4,r5));

        //saveAll() is coming from JpaRepository because it is extending from it
        employeeRepository.saveAll(employeeList);

        /**
         *  if employees are set to departments and regions,
         *  department & region repositories
         *  so both DepartmentRepository and RegionRepository are deleted from the repository package
         */
        // departmentRepository.saveAll(departmentList);
        //regionRepository.saveAll(regionList);
    }
}
