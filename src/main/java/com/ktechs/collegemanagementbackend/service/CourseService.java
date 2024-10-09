package com.ktechs.collegemanagementbackend.service;

import com.ktechs.collegemanagementbackend.entity.Course;
import com.ktechs.collegemanagementbackend.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // Create or update a course
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    // Get a course by ID
    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    // Get all courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Delete a course by ID
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    // Get course by name
    public Optional<Course> getCourseByName(String courseName) {
        return Optional.ofNullable(courseRepository.findByCourseName(courseName));
    }
}
