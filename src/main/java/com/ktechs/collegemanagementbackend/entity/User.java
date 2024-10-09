package com.ktechs.collegemanagementbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "users")  // Explicit table name
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")  // Explicit column name
    private Long userId;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    // Method called before persisting the entity
    @PrePersist
    protected void onCreate() {
        this.createdAt = Timestamp.from(Instant.now());
        this.updatedAt = Timestamp.from(Instant.now());
    }

    // Method called before updating the entity
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = Timestamp.from(Instant.now());
    }
}

enum Role {
    Admin, Student, Faculty, Staff, Librarian, Accounts
}
