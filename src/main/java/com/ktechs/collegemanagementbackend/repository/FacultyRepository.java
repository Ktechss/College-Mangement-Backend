package com.ktechs.collegemanagementbackend.repository;

import com.ktechs.collegemanagementbackend.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
