package com.ktechs.collegemanagementbackend.controller;

import com.ktechs.collegemanagementbackend.entity.Result;
import com.ktechs.collegemanagementbackend.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/results")
public class ResultController {

    @Autowired
    private ResultService resultService;

    // Create or update a result record
    @PostMapping
    public ResponseEntity<Result> createResult(@RequestBody Result result) {
        Result savedResult = resultService.saveResult(result);
        return ResponseEntity.ok(savedResult);
    }

    // Get all result records
    @GetMapping
    public ResponseEntity<List<Result>> getAllResults() {
        List<Result> results = resultService.getAllResults();
        return ResponseEntity.ok(results);
    }

    // Get result by ID
    @GetMapping("/{id}")
    public ResponseEntity<Result> getResultById(@PathVariable Long id) {
        Optional<Result> result = resultService.getResultById(id);
        return result.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get results by student ID
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Result>> getResultsByStudentId(@PathVariable Long studentId) {
        List<Result> results = resultService.getResultsByStudentId(studentId);
        return ResponseEntity.ok(results);
    }

    // Get results by exam ID
    @GetMapping("/exam/{examId}")
    public ResponseEntity<List<Result>> getResultsByExamId(@PathVariable Long examId) {
        List<Result> results = resultService.getResultsByExamId(examId);
        return ResponseEntity.ok(results);
    }

    // Delete result by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResult(@PathVariable Long id) {
        resultService.deleteResult(id);
        return ResponseEntity.noContent().build();
    }
}
