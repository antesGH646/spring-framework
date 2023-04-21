package com.cydeo.bootstrap;

import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {
    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;

    public DataGenerator(RegionRepository regionRepository, DepartmentRepository departmentRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
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
        System.out.println("-------------Employee End------------------");

        System.out.println("-------------Course Start----------------");
        System.out.println("-------------Course End------------------");

    }
}
