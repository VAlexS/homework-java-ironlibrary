package com.example.homework_library.services;

import com.example.homework_library.models.Book;
import com.example.homework_library.models.Issue;
import com.example.homework_library.models.Student;
import com.example.homework_library.repositories.BookRepository;
import com.example.homework_library.repositories.IssuesRepository;
import com.example.homework_library.repositories.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IssueServiceTest {

    @Mock
    private IssuesRepository issuesRepository;

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private IssueService issueService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testIssueBook() {
        Student student = new Student("USN123", "John Doe");
        Book book = new Book("123", "Test Book", "Fiction", 10);

        when(studentRepository.findStudentByUsn("USN123")).thenReturn(student);
        when(bookRepository.findByIsbn("123")).thenReturn(book);
        when(issuesRepository.existsByIssueStudent_Usn("USN123")).thenReturn(false);
        when(issuesRepository.existsByIssueBook_Isbn("123")).thenReturn(false);

        issueService.issueBook("USN123", "123");

        verify(issuesRepository, times(1)).save(any(Issue.class));
    }

    @Test
    void testFindIssueByStudentUsn() {
        Issue issue = new Issue("2023-10-01", "2023-10-08", new Student(), new Book());
        when(issuesRepository.findIssuesByIssueStudent_Usn("USN123")).thenReturn(issue);

        Issue result = issueService.findIssueByStudentUsn("USN123");

        assertNotNull(result);
    }
}