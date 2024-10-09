package com.ktechs.collegemanagementbackend.service;

import com.ktechs.collegemanagementbackend.entity.Attendance;
import com.ktechs.collegemanagementbackend.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    // Create or update an attendance record
    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    // Get an attendance record by ID
    public Optional<Attendance> getAttendanceById(Long id) {
        return attendanceRepository.findById(id);
    }

    // Get all attendance records
    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    // Get attendance records by student ID
    public List<Attendance> getAttendanceByStudentId(Long studentId) {
        return attendanceRepository.findByStudentStudentId(studentId);
    }

    // Get attendance records by course ID
    public List<Attendance> getAttendanceByCourseId(Long courseId) {
        return attendanceRepository.findByCourseCourseId(courseId);
    }

    // Delete an attendance record by ID
    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }
}
