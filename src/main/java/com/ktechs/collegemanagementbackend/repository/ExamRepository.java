package com.ktechs.collegemanagementbackend.repository;

import com.ktechs.collegemanagementbackend.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
    Exam findByExamName(String examName);
}
