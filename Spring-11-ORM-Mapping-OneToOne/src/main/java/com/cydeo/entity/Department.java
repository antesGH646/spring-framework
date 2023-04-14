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

    //creating by directional relationship
    @OneToOne(mappedBy = "department")//do not create foreign key, employee is the owner
    private Employee employee;

    public Department(String department, String division) {
        this.department = department;
        this.division = division;
    }
}
