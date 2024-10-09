package com.ktechs.collegemanagementbackend.entity;

import lombok.Data;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "exams") // Explicit table name
@Data
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_id") // Explicit column name
    private Long examId;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false)
    private Course course;

    @Column(name = "exam_name", nullable = false)
    private String examName;

    @Column(name = "exam_date")
    private Date examDate;

    @Column(name = "total_marks", nullable = false)
    private int totalMarks;
}
