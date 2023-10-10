package com.example.digitallibrary.repositories;

import com.example.digitallibrary.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Author findByEmail(String email);
}
