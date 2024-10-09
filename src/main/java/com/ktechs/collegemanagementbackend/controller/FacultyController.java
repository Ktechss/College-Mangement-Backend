package com.ktechs.collegemanagementbackend.controller;

import com.ktechs.collegemanagementbackend.entity.Faculty;
import com.ktechs.collegemanagementbackend.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/faculty")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    // Create or update a faculty member
    @PostMapping
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty) {
        Faculty savedFaculty = facultyService.saveFaculty(faculty);
        return ResponseEntity.ok(savedFaculty);
    }

    // Get all faculty members
    @GetMapping
    public ResponseEntity<List<Faculty>> getAllFaculty() {
        List<Faculty> facultyList = facultyService.getAllFaculty();
        return ResponseEntity.ok(facultyList);
    }

    // Get faculty by ID
    @GetMapping("/{id}")
    public ResponseEntity<Faculty> getFacultyById(@PathVariable Long id) {
        Optional<Faculty> faculty = facultyService.getFacultyById(id);
        return faculty.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete faculty by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.noContent().build();
    }
}
