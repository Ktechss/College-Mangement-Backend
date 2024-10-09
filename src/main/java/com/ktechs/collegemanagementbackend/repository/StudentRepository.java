package com.ktechs.collegemanagementbackend.repository;

import com.ktechs.collegemanagementbackend.entity.Student;
import com.ktechs.collegemanagementbackend.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Find students based on userId from the User entity
    List<Student> findAllByUser_UserId(Long userId);

    // Find a student by roll number
    Optional<Student> findByRollNumber(String rollNumber);

    // Find students by department
    List<Student> findAllByDepartment(Department department);
    Optional<Student> findTopByDepartment_DepartmentIdOrderByRollNumberDesc(Long departmentId);
}
