package com.example.ironlibrary.repositories;

import com.example.ironlibrary.models.Author;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorRepository extends JpaRepository<Author, Long> {

}
