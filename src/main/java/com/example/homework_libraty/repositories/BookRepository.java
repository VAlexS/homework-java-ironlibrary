package com.example.homework_libraty.repositories;

import com.example.homework_libraty.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    Book findByTitle(String title);

    List<Book> findByCategory(String category);

}
