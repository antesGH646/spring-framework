package com.cydeo.service;

import com.cydeo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SalaryService {

    HoursRepository hoursRepository;
    HoursRepository hoursRepository2;
    EmployeeRepository employeeRepository;

    public SalaryService(@Qualifier("RH") HoursRepository hoursRepository,
                         @Qualifier("OTH") HoursRepository hoursRepository2,
                         EmployeeRepository employeeRepository) {
        this.hoursRepository2 = hoursRepository2;
        this.hoursRepository = hoursRepository;
        this.employeeRepository = employeeRepository;
    }

    public void calculateSalary() {
        //HourlyRate * (RegularHours + OvertimeHours)  => (15 + 40) * 65
        System.out.println(employeeRepository.getHourlyRate() * (hoursRepository.getHours() + hoursRepository2.getHours()));
    }
}
