package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="departments")
@NoArgsConstructor
@Data
public class Department extends BaseEntity {
    private String department;
    private String division;

    //creating by directional relationship, Departments table will not have FK of Employees table
    @OneToOne(mappedBy = "department")//marks not to create foreign key, employee has ownership
    private Employee employee;

    public Department(String department, String division) {
        this.department = department;
        this.division = division;
    }
}
