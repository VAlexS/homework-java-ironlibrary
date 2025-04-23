package com.example.homework_library.repositories;

import com.example.homework_library.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    Book findByTitle(String title);

    List<Book> findByCategory(String category);

    @Query("SELECT b FROM Book b")
    List<Book> findAllBooksAndAuthors();

    Book findByIsbn(String isbn);



}
