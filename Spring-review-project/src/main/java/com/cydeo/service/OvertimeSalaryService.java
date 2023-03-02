package com.cydeo.service;

import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.HoursRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OvertimeSalaryService {
    HoursRepository hoursRepository;
    EmployeeRepository employeeRepository;

    public OvertimeSalaryService(@Qualifier("OTH") HoursRepository hoursRepository, EmployeeRepository employeeRepository) {
        this.hoursRepository = hoursRepository;
        this.employeeRepository = employeeRepository;
    }

    public void calculateOvertimeSalary(){
        System.out.println(hoursRepository.getHours());
    }
}
