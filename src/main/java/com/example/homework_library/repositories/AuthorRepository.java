package com.example.homework_library.repositories;

import com.example.homework_library.models.Author;
import com.example.homework_library.models.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

   // Book findByIsbn(String isbn);
    Author findByName(String authorName);

    List<Author> findAll();





}

