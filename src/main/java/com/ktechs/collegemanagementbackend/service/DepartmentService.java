package com.ktechs.collegemanagementbackend.service;

import com.ktechs.collegemanagementbackend.entity.Department;
import com.ktechs.collegemanagementbackend.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Create or update a department
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    // Get a department by ID
    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    // Get all departments
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // Delete a department by ID
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    // Get department by name
    public Optional<Department> getDepartmentByName(String departmentName) {
        return Optional.ofNullable(departmentRepository.findByDepartmentName(departmentName));
    }
}
