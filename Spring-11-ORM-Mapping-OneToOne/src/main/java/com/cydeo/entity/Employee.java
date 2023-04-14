package com.cydeo.entity;

import com.cydeo.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="employees")
@NoArgsConstructor
@Data
public class Employee extends BaseEntity{

    //defining fields, they will turn into columns of the employees table
    private String firstName;
    private String lastName;
    private String email;
    @Column(columnDefinition = "DATE")//using custom name instead of the default name
    private LocalDate hireDate;
    private int salary;
    @Enumerated(EnumType.STRING)//marks that gender is an enum
    private Gender gender;

    //telling the Spring to create one-to-one relationship
    @OneToOne(cascade = CascadeType.ALL)//all actions happen on both existing entities
//    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name = "department_id")//changing the default name
    private Department department;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "region_id")
    private Region region;

    public Employee(String firstName, String lastName, String email,
                    LocalDate hireDate, int salary, Gender gender) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hireDate = hireDate;
        this.salary = salary;
        this.gender = gender;
    }
}
