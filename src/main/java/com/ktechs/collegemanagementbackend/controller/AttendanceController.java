package com.ktechs.collegemanagementbackend.controller;

import com.ktechs.collegemanagementbackend.entity.Attendance;
import com.ktechs.collegemanagementbackend.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    // Create or update an attendance record
    @PostMapping
    public ResponseEntity<Attendance> createAttendance(@RequestBody Attendance attendance) {
        Attendance savedAttendance = attendanceService.saveAttendance(attendance);
        return ResponseEntity.ok(savedAttendance);
    }

    // Get all attendance records
    @GetMapping
    public ResponseEntity<List<Attendance>> getAllAttendance() {
        List<Attendance> attendanceList = attendanceService.getAllAttendance();
        return ResponseEntity.ok(attendanceList);
    }

    // Get attendance by ID
    @GetMapping("/{id}")
    public ResponseEntity<Attendance> getAttendanceById(@PathVariable Long id) {
        Optional<Attendance> attendance = attendanceService.getAttendanceById(id);
        return attendance.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get attendance records by student ID
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Attendance>> getAttendanceByStudentId(@PathVariable Long studentId) {
        List<Attendance> attendanceList = attendanceService.getAttendanceByStudentId(studentId);
        return ResponseEntity.ok(attendanceList);
    }

    // Get attendance records by course ID
    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Attendance>> getAttendanceByCourseId(@PathVariable Long courseId) {
        List<Attendance> attendanceList = attendanceService.getAttendanceByCourseId(courseId);
        return ResponseEntity.ok(attendanceList);
    }

    // Delete attendance by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable Long id) {
        attendanceService.deleteAttendance(id);
        return ResponseEntity.noContent().build();
    }
}
