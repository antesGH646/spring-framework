package com.cydeo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_id;
    private String firstName;
    private String lastName;
    private String email;
    private Date hire_date;
    private String department;
    private String gender;
    private int salary;
    private int region_id;
}
