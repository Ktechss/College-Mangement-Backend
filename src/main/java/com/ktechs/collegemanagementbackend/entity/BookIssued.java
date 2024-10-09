package com.ktechs.collegemanagementbackend.entity;

import lombok.Data;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "book_issued") // Explicit table name
@Data
public class BookIssued {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issue_id") // Explicit column name
    private Long issueId;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "book_id", nullable = false)
    private Library book;

    @Column(name = "issue_date", nullable = false)
    private Date issueDate;

    @Column(name = "return_date")
    private Date returnDate;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private BookStatus status;

    public enum BookStatus {
        Issued,
        Returned,
        Overdue
    }
}
