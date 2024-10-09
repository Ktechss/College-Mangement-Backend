package com.ktechs.collegemanagementbackend.controller;

import com.ktechs.collegemanagementbackend.entity.Library;
import com.ktechs.collegemanagementbackend.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    // Create or update a book
    @PostMapping
    public ResponseEntity<Library> createBook(@RequestBody Library book) {
        Library savedBook = libraryService.saveBook(book);
        return ResponseEntity.ok(savedBook);
    }

    // Get all books
    @GetMapping
    public ResponseEntity<List<Library>> getAllBooks() {
        List<Library> books = libraryService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    // Get book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Library> getBookById(@PathVariable Long id) {
        Optional<Library> book = libraryService.getBookById(id);
        return book.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get book by ISBN
    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<Library> getBookByIsbn(@PathVariable String isbn) {
        Optional<Library> book = libraryService.getBookByIsbn(isbn);
        return book.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete book by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        libraryService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
