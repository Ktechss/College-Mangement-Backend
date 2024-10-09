package com.ktechs.collegemanagementbackend.repository;

import com.ktechs.collegemanagementbackend.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {
    Optional<Library> findByIsbn(String isbn);
}
