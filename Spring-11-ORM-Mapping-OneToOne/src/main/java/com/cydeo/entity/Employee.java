package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="employees")
@NoArgsConstructor
@Data
public class Employee extends BaseEntity{

    private String firstName;
    private String lastName;
    private String email;
    @Column(columnDefinition = "Date")
    private LocalDate hire_date;
    private String gender;
    private int salary;

    @OneToOne(cascade = CascadeType.ALL)
   // @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="region_id")
    private Region region;

    public Employee(String firstName, String lastName,
                    String email, LocalDate hire_date,
                    String gender, int salary) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hire_date = hire_date;
        this.gender = gender;
        this.salary = salary;
    }
}
