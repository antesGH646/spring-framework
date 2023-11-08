package com.mycy.repository;

import com.mycy.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class DBEmployeeRepository implements EmployeeRepository {
    @Override
    public int getHourlyRate() {
        //assume that this data is coming from db
        Employee employee = new Employee("Harold Finch", "IT", 65);
        return employee.getHourlyRate();

    }
}
