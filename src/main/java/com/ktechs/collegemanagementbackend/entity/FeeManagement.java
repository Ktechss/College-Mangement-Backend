package com.ktechs.collegemanagementbackend.entity;

import lombok.Data;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "feemanagement") // Explicit table name
@Data
public class FeeManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fee_id") // Explicit column name
    private Long feeId;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false)
    private Course course;

    @Column(name = "amount_due", nullable = false)
    private Double amountDue;

    @Column(name = "amount_paid", nullable = false)
    private Double amountPaid;

    @Column(name = "due_date", nullable = false)
    private Date dueDate;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private FeeStatus status;

    public enum FeeStatus {
        Paid,
        Pending,
        Overdue
    }
}
