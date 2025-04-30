package com.example.homework_library.services;

import com.example.homework_library.models.Author;
import com.example.homework_library.models.Book;
import com.example.homework_library.repositories.AuthorRepository;
import com.example.homework_library.repositories.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddBook() {
        // Arrange
        String isbn = "123";
        String title = "Test Book";
        String category = "Fiction";
        String authorName = "John Doe";
        String mail = "john@example.com";
        int booksNumber = 10;

        // Act
        bookService.addBook(isbn, title, category, authorName, mail, booksNumber);

        // Assert
        ArgumentCaptor<Book> bookCaptor = ArgumentCaptor.forClass(Book.class);
        ArgumentCaptor<Author> authorCaptor = ArgumentCaptor.forClass(Author.class);

        verify(bookRepository, times(1)).save(bookCaptor.capture());
        verify(authorRepository, times(1)).save(authorCaptor.capture());

        Book capturedBook = bookCaptor.getValue();
        Author capturedAuthor = authorCaptor.getValue();

        assertEquals(isbn, capturedBook.getIsbn());
        assertEquals(title, capturedBook.getTitle());
        assertEquals(category, capturedBook.getCategory());
        assertEquals(booksNumber, capturedBook.getQuantity());

        assertEquals(authorName, capturedAuthor.getName());
        assertEquals(mail, capturedAuthor.getEmail());
        assertEquals(capturedBook, capturedAuthor.getAuthorBook());
    }

    @Test
    void testSearchBookByTitle() {
        Book book = new Book("123", "Test Book", "Fiction", 10);
        when(bookRepository.findByTitle("Test Book")).thenReturn(book);

        Book result = bookService.searchBookByTitle("Test Book");

        assertNotNull(result);
        assertEquals("Test Book", result.getTitle());
    }

    @Test
    void testListAllBooks() {
        when(bookRepository.findAllBooksAndAuthors()).thenReturn(List.of(new Book("123", "Test Book", "Fiction", 10)));

        List<Book> books = bookService.listAllBooks();

        assertFalse(books.isEmpty());
        assertEquals(1, books.size());
    }

    @Test
    void testSearchBookByIsbn() {
        Book book = new Book("123", "Test Book", "Fiction", 10);
        when(bookRepository.findByIsbn("123")).thenReturn(book);

        Book result = bookService.searchBookByIsbn("123");

        assertNotNull(result);
        assertEquals("123", result.getIsbn());
    }
}