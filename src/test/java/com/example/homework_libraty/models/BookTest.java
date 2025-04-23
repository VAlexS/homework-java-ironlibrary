package com.example.homework_libraty.models;

import com.example.homework_libraty.repositories.BookRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    @DisplayName("Save book")
    void saveBook(){
        Book book = new Book("32fs4r", "El señor de los anillos", "accion", 42);
        bookRepository.save(book);

    }

    @Test
    @DisplayName("Buscar todos los libros")
    void listAllBooks(){
        List<Book> allBooks = bookRepository.findAllBooksAndAuthors();

        System.out.println("============================");
        System.out.println("Los libros que hemos encontrado son: ");
        System.out.println(allBooks);
        System.out.println("===================");
    }

}