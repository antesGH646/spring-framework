package com.cydeo.entity;

import com.cydeo.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;

@Entity//to create a table from this class fields
@Table(name = "Students")//to change the default table name
public class Student {
    @Id//when using @Entity, it is mandatory to use @Id (primary key)
    //to provide primary keys automatically
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="student_first_name")//using custom name instead of using a default column names
    private String firstName;
    @Column(name="student_last_name")//to change default column names
    private String lastName;

    private String email;

    @Transient//marks to exclude or prevents creating a column from this field in the table
    private String city;

    //to add dates
    @Column(columnDefinition = "Date")
    private LocalDate birthDate;
    @Column(columnDefinition = "Time")
    private LocalDate birthTime;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate birthDateTime;

    //using enums
    @Enumerated(EnumType.STRING)//marks to use defined enum fields, otherwise it will use integer, or ordinal is 0 & 1
    private Gender gender;
}
