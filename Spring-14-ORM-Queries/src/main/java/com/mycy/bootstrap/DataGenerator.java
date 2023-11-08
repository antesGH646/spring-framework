package com.mycy.bootstrap;

import com.mycy.repository.CourseRepository;
import com.mycy.repository.DepartmentRepository;
import com.mycy.repository.EmployeeRepository;
import com.mycy.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class DataGenerator implements CommandLineRunner {
    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final CourseRepository courseRepository;

    public DataGenerator(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, CourseRepository courseRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("-------------Region Start----------------");
        //need to inject by constructor to access a method
        System.out.println("Find by Country: " + regionRepository.findByCountry("Canada"));
        System.out.println("Distinct Countries: " + regionRepository.findDistinctByCountry("Canada"));
        System.out.println("Containing United: " + regionRepository.findByCountryContaining("United"));
        System.out.println("Containing United: " + regionRepository.findByCountryContainingOrderByCountry("Asia"));
        System.out.println("Containing United: " + regionRepository.findTopByCountry("Canada"));
        System.out.println("-------------Region End------------------");

        System.out.println("-------------Department Start----------------");
        departmentRepository.findByDepartment("Toys");
        departmentRepository.findByDivisionEquals("Outdoors");
        departmentRepository.findDistinctTop3ByDivisionContains("Hea");
        System.out.println("-------------Department End------------------");

        System.out.println("-------------Employee Start----------------");
        System.out.println("getEmployeeDetail:" + employeeRepository.getEmployeeDetail());
        System.out.println("getEmployeeSalary:" + employeeRepository.getEmployeeSalary("",2));
        System.out.println("getEmployeeDetail:" + employeeRepository.findByEmail("fmorffew4@a8.net"));
        System.out.println("getEmployeeSalary:" + employeeRepository.findByEmailIsNull());
        System.out.println("-------------Employee End------------------");

        System.out.println("-------------Course Start----------------");
        courseRepository.findByCategory("Spring").forEach(System.out::println);
        courseRepository.findByCategoryOrderByName("Spring").forEach(System.out::println);
        System.out.println(courseRepository.existsByName("JavaScript for All"));
        System.out.println(courseRepository.countByCategory("Spring"));
        courseRepository.findByNameStartsWith("Scalable").forEach(System.out::println);
        courseRepository.streamByCategory("Spring").forEach(System.out::println);
        System.out.println("-------------Course End------------------");
    }
}
