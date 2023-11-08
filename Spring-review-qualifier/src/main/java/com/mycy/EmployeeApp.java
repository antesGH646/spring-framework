package com.mycy;

import com.mycy.config.EmployeeConfig;
import com.mycy.service.SalaryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmployeeApp {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(EmployeeConfig.class);
        SalaryService salaryService = container.getBean(SalaryService.class);
        salaryService.calculateSalary();
    }
}
