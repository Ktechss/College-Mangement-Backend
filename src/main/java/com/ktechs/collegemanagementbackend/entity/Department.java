package com.ktechs.collegemanagementbackend.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Table(name = "departments") // Explicit table name
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id") // Explicit column name
    private long departmentId;

    @Column(name = "department_name", unique = true, nullable = false)
    private String departmentName;
}
