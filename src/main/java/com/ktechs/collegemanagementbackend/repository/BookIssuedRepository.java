package com.ktechs.collegemanagementbackend.repository;

import com.ktechs.collegemanagementbackend.entity.BookIssued;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookIssuedRepository extends JpaRepository<BookIssued, Long> {
    List<BookIssued> findByStudentStudentId(Long studentId);
    List<BookIssued> findByBookBookId(Long bookId);
}
