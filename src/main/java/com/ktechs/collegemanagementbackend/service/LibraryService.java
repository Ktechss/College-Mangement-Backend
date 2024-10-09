package com.ktechs.collegemanagementbackend.service;

import com.ktechs.collegemanagementbackend.entity.Library;
import com.ktechs.collegemanagementbackend.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    // Create or update a book
    public Library saveBook(Library book) {
        return libraryRepository.save(book);
    }

    // Get a book by ID
    public Optional<Library> getBookById(Long id) {
        return libraryRepository.findById(id);
    }

    // Get all books
    public List<Library> getAllBooks() {
        return libraryRepository.findAll();
    }

    // Get a book by ISBN
    public Optional<Library> getBookByIsbn(String isbn) {
        return libraryRepository.findByIsbn(isbn);
    }

    // Delete a book by ID
    public void deleteBook(Long id) {
        libraryRepository.deleteById(id);
    }
}
