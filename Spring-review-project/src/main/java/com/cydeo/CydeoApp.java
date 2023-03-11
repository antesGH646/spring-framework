package com.cydeo;

import com.cydeo.config.EmployeeConfig;
import com.cydeo.repository.HoursRepository;
import com.cydeo.service.SalaryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(EmployeeConfig.class);

        SalaryService salaryService = container.getBean(SalaryService.class);

        salaryService.calculateRegularSalary();

        HoursRepository hr = container.getBean(HoursRepository.class);

        System.out.println(hr);

    }
}
