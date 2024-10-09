package com.ktechs.collegemanagementbackend.service;

import com.ktechs.collegemanagementbackend.entity.Faculty;
import com.ktechs.collegemanagementbackend.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    // Create or update a faculty
    public Faculty saveFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    // Get a faculty by ID
    public Optional<Faculty> getFacultyById(Long id) {
        return facultyRepository.findById(id);
    }

    // Get all faculty members
    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    // Delete a faculty by ID
    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }
}
