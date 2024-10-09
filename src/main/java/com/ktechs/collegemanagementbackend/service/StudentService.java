package com.ktechs.collegemanagementbackend.service;

import com.ktechs.collegemanagementbackend.entity.Student;
import com.ktechs.collegemanagementbackend.entity.Department;
import com.ktechs.collegemanagementbackend.repository.StudentRepository;
import com.ktechs.collegemanagementbackend.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    // Create or update a student
    public Student saveStudent(Student student) {
        // Ensure department is valid before saving
        if (student.getDepartment() != null) {
            Department department = departmentRepository.findById(student.getDepartment().getDepartmentId())
                    .orElseThrow(() -> new RuntimeException("Department not found"));
            student.setDepartment(department);  // Set department before saving
        }
        return studentRepository.save(student);
    }

    // Get a student by ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get students by userId
    public List<Student> getStudentsByUserId(Long userId) {
        return studentRepository.findAllByUser_UserId(userId);
    }

    // Delete a student by ID
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    // Get student by roll number
    public Optional<Student> getStudentByRollNumber(String rollNumber) {
        return studentRepository.findByRollNumber(rollNumber);
    }

    // Get students by department
    public List<Student> getStudentsByDepartment(long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        return studentRepository.findAllByDepartment(department);
    }
    public Optional<String> getLastRollNumberByDepartment(Long departmentId) {
        Optional<Student> lastStudent = studentRepository.findTopByDepartment_DepartmentIdOrderByRollNumberDesc(departmentId);
        return lastStudent.map(Student::getRollNumber);
    }
}
