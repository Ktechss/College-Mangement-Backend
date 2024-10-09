package com.ktechs.collegemanagementbackend.service;

import com.ktechs.collegemanagementbackend.entity.Enrollment;
import com.ktechs.collegemanagementbackend.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    // Create or update an enrollment record
    public Enrollment saveEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    // Get an enrollment record by ID
    public Optional<Enrollment> getEnrollmentById(Long id) {
        return enrollmentRepository.findById(id);
    }

    // Get all enrollment records
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    // Get enrollment records by student ID
    public List<Enrollment> getEnrollmentsByStudentId(Long studentId) {
        return enrollmentRepository.findByStudentStudentId(studentId);
    }

    // Get enrollment records by course ID
    public List<Enrollment> getEnrollmentsByCourseId(Long courseId) {
        return enrollmentRepository.findByCourseCourseId(courseId);
    }

    // Delete an enrollment record by ID
    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);
    }
}
