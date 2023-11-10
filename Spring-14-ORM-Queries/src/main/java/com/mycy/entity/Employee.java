package com.mycy.entity;

import com.mycy.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
public class Employee extends BaseEntity{

    private String firstName;
    private String lastName;

    private String email;
    @Column(columnDefinition = "Date")

    private LocalDate hireDate;
    @Enumerated(EnumType.STRING)

    private Gender gender;
    private Integer salary;

    @ManyToOne
    @JoinColumn(name="department")
    private Department department;

    @ManyToOne
    private Region region;
}
