package com.ktechs.collegemanagementbackend.controller;

import com.ktechs.collegemanagementbackend.entity.BookIssued;
import com.ktechs.collegemanagementbackend.service.BookIssuedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/book-issued")
public class BookIssuedController {

    @Autowired
    private BookIssuedService bookIssuedService;

    // Create or update a book issued record
    @PostMapping
    public ResponseEntity<BookIssued> createBookIssued(@RequestBody BookIssued bookIssued) {
        BookIssued savedBookIssued = bookIssuedService.saveBookIssued(bookIssued);
        return ResponseEntity.ok(savedBookIssued);
    }

    // Get all book issued records
    @GetMapping
    public ResponseEntity<List<BookIssued>> getAllBookIssued() {
        List<BookIssued> bookIssuedList = bookIssuedService.getAllBookIssued();
        return ResponseEntity.ok(bookIssuedList);
    }

    // Get book issued record by ID
    @GetMapping("/{id}")
    public ResponseEntity<BookIssued> getBookIssuedById(@PathVariable Long id) {
        Optional<BookIssued> bookIssued = bookIssuedService.getBookIssuedById(id);
        return bookIssued.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get books issued by student ID
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<BookIssued>> getBooksIssuedByStudentId(@PathVariable Long studentId) {
        List<BookIssued> bookIssuedList = bookIssuedService.getBooksIssuedByStudentId(studentId);
        return ResponseEntity.ok(bookIssuedList);
    }

    // Get books issued by book ID
    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<BookIssued>> getBooksIssuedByBookId(@PathVariable Long bookId) {
        List<BookIssued> bookIssuedList = bookIssuedService.getBooksIssuedByBookId(bookId);
        return ResponseEntity.ok(bookIssuedList);
    }

    // Delete book issued record by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookIssued(@PathVariable Long id) {
        bookIssuedService.deleteBookIssued(id);
        return ResponseEntity.noContent().build();
    }
}
