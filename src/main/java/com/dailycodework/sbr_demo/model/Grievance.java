package com.dailycodework.sbr_demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Grievance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "student_id")
//    private Student student;
    //    @ManyToOne
//    @JoinColumn(name = "department_id")

    private String department;

    private String student_regd_no;

    private String subject;

    private String description;

    private String status; // pending, in-progress, resolved

    private LocalDateTime createdDate;

    private LocalDateTime resolvedDate;

}
