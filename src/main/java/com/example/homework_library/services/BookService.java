package com.example.homework_library.services;

import com.example.homework_library.models.Author;
import com.example.homework_library.models.Book;
import com.example.homework_library.repositories.AuthorRepository;
import com.example.homework_library.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public void addBook(String isbn, String title, String category, String authorName, String mail, int booksNumber) {
        Book book = new Book(isbn, title, category, booksNumber);
        Author author = new Author(authorName, mail, book);

        bookRepository.save(book);
        authorRepository.save(author);
    }

    public Book searchBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public List<Book> listAllBooks() {
        return bookRepository.findAllBooksAndAuthors();
    }

    public List<Book> searchBooksByCategory(String category) {
        return bookRepository.findByCategory(category);
    }

    public Book findBookByAuthor(String authorName) {
        Author author = authorRepository.findByName(authorName);
        if (author != null) {
            return author.getAuthorBook();
        }
        return null;
    }

    public Book searchBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }
}