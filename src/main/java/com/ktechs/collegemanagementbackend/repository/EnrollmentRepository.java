package com.ktechs.collegemanagementbackend.repository;

import com.ktechs.collegemanagementbackend.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByStudentStudentId(Long studentId);
    List<Enrollment> findByCourseCourseId(Long courseId);
}
