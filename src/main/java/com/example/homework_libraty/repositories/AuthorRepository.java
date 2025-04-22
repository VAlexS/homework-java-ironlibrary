package com.example.homework_libraty.repositories;

import com.example.homework_libraty.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
