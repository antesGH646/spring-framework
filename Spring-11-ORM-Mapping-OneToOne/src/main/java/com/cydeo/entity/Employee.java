package com.cydeo.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_id;
    private String firstName;
    private String lastName;
    private String email;
    @Column(columnDefinition = "Date")
    private LocalDate hire_date;
    private String department;
    private String gender;
    private int salary;
    private int region_id;
}
