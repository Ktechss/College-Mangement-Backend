package com.ktechs.collegemanagementbackend.service;

import com.ktechs.collegemanagementbackend.entity.FeeManagement;
import com.ktechs.collegemanagementbackend.repository.FeeManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeeManagementService {

    @Autowired
    private FeeManagementRepository feeManagementRepository;

    // Create or update a fee record
    public FeeManagement saveFeeManagement(FeeManagement feeManagement) {
        return feeManagementRepository.save(feeManagement);
    }

    // Get a fee record by ID
    public Optional<FeeManagement> getFeeManagementById(Long id) {
        return feeManagementRepository.findById(id);
    }

    // Get all fee records
    public List<FeeManagement> getAllFeeManagement() {
        return feeManagementRepository.findAll();
    }

    // Get fee records by student ID
    public List<FeeManagement> getFeeManagementByStudentId(Long studentId) {
        return feeManagementRepository.findByStudentStudentId(studentId);
    }

    // Get fee records by course ID
    public List<FeeManagement> getFeeManagementByCourseId(Long courseId) {
        return feeManagementRepository.findByCourseCourseId(courseId);
    }

    // Delete a fee record by ID
    public void deleteFeeManagement(Long id) {
        feeManagementRepository.deleteById(id);
    }
}
