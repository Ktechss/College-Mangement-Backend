package com.ktechs.collegemanagementbackend.controller;

import com.ktechs.collegemanagementbackend.entity.Student;
import com.ktechs.collegemanagementbackend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Create or update a student, the department will be part of the student object
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student savedStudent = studentService.saveStudent(student);
        return ResponseEntity.ok(savedStudent);
    }

    // Get all students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    // Get student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get student by roll number
    @GetMapping("/rollNumber/{rollNumber}")
    public ResponseEntity<Student> getStudentByRollNumber(@PathVariable String rollNumber) {
        Optional<Student> student = studentService.getStudentByRollNumber(rollNumber);
        return student.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get students by userId
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Student>> getStudentsByUserId(@PathVariable Long userId) {
        List<Student> students = studentService.getStudentsByUserId(userId);
        if (students.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(students);
    }

    // Get students by departmentId
    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<Student>> getStudentsByDepartment(@PathVariable Long departmentId) {
        List<Student> students = studentService.getStudentsByDepartment(departmentId);
        if (students.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(students);
    }

    // Delete student by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/last-roll-number")
    public ResponseEntity<String> getLastRollNumberByDepartment(@RequestParam Long departmentId) {
        Optional<String> lastRollNumber = studentService.getLastRollNumberByDepartment(departmentId);
        return lastRollNumber.map(ResponseEntity::ok)
                .orElse(ResponseEntity.ok(null)); // Return null if no student found
    }
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Optional<Student> existingStudent = studentService.getStudentById(id);

        if (existingStudent.isPresent()) {
            student.setStudentId(id); // Ensure the ID matches
            Student updatedStudent = studentService.saveStudent(student); // Assuming saveStudent handles both create and update
            return ResponseEntity.ok(updatedStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
