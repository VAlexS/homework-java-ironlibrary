package com.example.homework_library.services;

import com.example.homework_library.models.Author;
import com.example.homework_library.models.Book;
import com.example.homework_library.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author addAuthor(String name, String email, Book book) {
        Author author = new Author(name, email, book);
        return authorRepository.save(author);
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author findAuthorByName(String name) {
        return authorRepository.findByName(name);
    }
}