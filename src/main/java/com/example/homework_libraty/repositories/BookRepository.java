package com.example.homework_libraty.repositories;

import com.example.homework_libraty.models.Author;
import com.example.homework_libraty.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}
