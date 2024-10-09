package com.ktechs.collegemanagementbackend.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Table(name = "courses") // Explicit table name
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id") // Explicit column name
    private Long courseId;

    @Column(name = "course_name", unique = true, nullable = false)
    private String courseName;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "department_id", nullable = false)
    private Department department;

    @Column(name = "credits")
    private int credits;

    @Column(name = "course_duration")
    private String courseDuration;
}
