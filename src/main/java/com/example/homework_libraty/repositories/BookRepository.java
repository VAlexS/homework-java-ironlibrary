package com.example.homework_libraty.repositories;

import com.example.homework_libraty.models.BookExample;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookExample, String> {
}
