package com.ktechs.collegemanagementbackend.service;

import com.ktechs.collegemanagementbackend.entity.Exam;
import com.ktechs.collegemanagementbackend.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamService {

    @Autowired
    private ExamRepository examRepository;

    // Create or update an exam
    public Exam saveExam(Exam exam) {
        return examRepository.save(exam);
    }

    // Get an exam by ID
    public Optional<Exam> getExamById(Long id) {
        return examRepository.findById(id);
    }

    // Get all exams
    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    // Delete an exam by ID
    public void deleteExam(Long id) {
        examRepository.deleteById(id);
    }

    // Get exam by name
    public Optional<Exam> getExamByName(String examName) {
        return Optional.ofNullable(examRepository.findByExamName(examName));
    }
}
