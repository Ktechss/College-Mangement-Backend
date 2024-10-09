package com.ktechs.collegemanagementbackend.repository;

import com.ktechs.collegemanagementbackend.entity.FeeManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeeManagementRepository extends JpaRepository<FeeManagement, Long> {
    List<FeeManagement> findByStudentStudentId(Long studentId);
    List<FeeManagement> findByCourseCourseId(Long courseId);
}
