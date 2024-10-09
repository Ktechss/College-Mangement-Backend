package com.ktechs.collegemanagementbackend.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Table(name = "results") // Explicit table name
@Data
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id") // Explicit column name
    private Long resultId;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "exam_id", referencedColumnName = "exam_id", nullable = false)
    private Exam exam;

    @Column(name = "marks_obtained", nullable = false)
    private Integer marksObtained;

    @Column(name = "grade", nullable = false)
    private String grade;
}
