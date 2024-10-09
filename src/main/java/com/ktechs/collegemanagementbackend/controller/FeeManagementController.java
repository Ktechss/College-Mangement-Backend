package com.ktechs.collegemanagementbackend.controller;

import com.ktechs.collegemanagementbackend.entity.FeeManagement;
import com.ktechs.collegemanagementbackend.service.FeeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fee-management")
public class FeeManagementController {

    @Autowired
    private FeeManagementService feeManagementService;

    // Create or update a fee record
    @PostMapping
    public ResponseEntity<FeeManagement> createFeeManagement(@RequestBody FeeManagement feeManagement) {
        FeeManagement savedFeeManagement = feeManagementService.saveFeeManagement(feeManagement);
        return ResponseEntity.ok(savedFeeManagement);
    }

    // Get all fee records
    @GetMapping
    public ResponseEntity<List<FeeManagement>> getAllFeeManagement() {
        List<FeeManagement> feeManagementList = feeManagementService.getAllFeeManagement();
        return ResponseEntity.ok(feeManagementList);
    }

    // Get fee record by ID
    @GetMapping("/{id}")
    public ResponseEntity<FeeManagement> getFeeManagementById(@PathVariable Long id) {
        Optional<FeeManagement> feeManagement = feeManagementService.getFeeManagementById(id);
        return feeManagement.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get fee records by student ID
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<FeeManagement>> getFeeManagementByStudentId(@PathVariable Long studentId) {
        List<FeeManagement> feeManagementList = feeManagementService.getFeeManagementByStudentId(studentId);
        return ResponseEntity.ok(feeManagementList);
    }

    // Get fee records by course ID
    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<FeeManagement>> getFeeManagementByCourseId(@PathVariable Long courseId) {
        List<FeeManagement> feeManagementList = feeManagementService.getFeeManagementByCourseId(courseId);
        return ResponseEntity.ok(feeManagementList);
    }

    // Delete fee record by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeeManagement(@PathVariable Long id) {
        feeManagementService.deleteFeeManagement(id);
        return ResponseEntity.noContent().build();
    }
}
