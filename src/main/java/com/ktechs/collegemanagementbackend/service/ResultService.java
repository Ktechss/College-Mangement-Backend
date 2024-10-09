package com.ktechs.collegemanagementbackend.service;

import com.ktechs.collegemanagementbackend.entity.Result;
import com.ktechs.collegemanagementbackend.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

    // Create or update a result record
    public Result saveResult(Result result) {
        return resultRepository.save(result);
    }

    // Get a result record by ID
    public Optional<Result> getResultById(Long id) {
        return resultRepository.findById(id);
    }

    // Get all result records
    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }

    // Get result records by student ID
    public List<Result> getResultsByStudentId(Long studentId) {
        return resultRepository.findByStudentStudentId(studentId);
    }

    // Get result records by exam ID
    public List<Result> getResultsByExamId(Long examId) {
        return resultRepository.findByExamExamId(examId);
    }

    // Delete a result record by ID
    public void deleteResult(Long id) {
        resultRepository.deleteById(id);
    }
}
