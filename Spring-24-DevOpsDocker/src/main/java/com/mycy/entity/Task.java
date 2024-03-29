package com.mycy.entity;

import com.mycy.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@NoArgsConstructor
@Getter
@Setter
@Where(clause = "is_deleted=false")
public class Task extends BaseEntity{
    private String taskSubject;
    private String taskDetail;

    @Enumerated(EnumType.STRING)
    private Status taskStatus;

    @Column(columnDefinition = "Date")
    private LocalDate assignedDate;

    @ManyToOne(fetch = FetchType.LAZY)//many tasks can be assigned to one employee
    private User assignedEmployee;

    @ManyToOne(fetch = FetchType.LAZY)//many tasks can be assigned to one project
    private Project project;

}
