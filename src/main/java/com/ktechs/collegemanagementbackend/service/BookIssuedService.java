package com.ktechs.collegemanagementbackend.service;

import com.ktechs.collegemanagementbackend.entity.BookIssued;
import com.ktechs.collegemanagementbackend.repository.BookIssuedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookIssuedService {

    @Autowired
    private BookIssuedRepository bookIssuedRepository;

    // Create or update a book issued record
    public BookIssued saveBookIssued(BookIssued bookIssued) {
        return bookIssuedRepository.save(bookIssued);
    }

    // Get a book issued record by ID
    public Optional<BookIssued> getBookIssuedById(Long id) {
        return bookIssuedRepository.findById(id);
    }

    // Get all book issued records
    public List<BookIssued> getAllBookIssued() {
        return bookIssuedRepository.findAll();
    }

    // Get book issued records by student ID
    public List<BookIssued> getBooksIssuedByStudentId(Long studentId) {
        return bookIssuedRepository.findByStudentStudentId(studentId);
    }

    // Get book issued records by book ID
    public List<BookIssued> getBooksIssuedByBookId(Long bookId) {
        return bookIssuedRepository.findByBookBookId(bookId);
    }

    // Delete a book issued record by ID
    public void deleteBookIssued(Long id) {
        bookIssuedRepository.deleteById(id);
    }
}
