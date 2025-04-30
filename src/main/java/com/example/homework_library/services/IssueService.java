package com.example.homework_library.services;

import com.example.homework_library.models.Book;
import com.example.homework_library.models.Issue;
import com.example.homework_library.models.Student;
import com.example.homework_library.repositories.BookRepository;
import com.example.homework_library.repositories.IssuesRepository;
import com.example.homework_library.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class IssueService {

    private final IssuesRepository issuesRepository;
    private final StudentRepository studentRepository;
    private final BookRepository bookRepository;

    public IssueService(IssuesRepository issuesRepository,StudentRepository studentRepository, BookRepository bookRepository) {
        this.issuesRepository = issuesRepository;
        this.studentRepository = studentRepository;
        this.bookRepository = bookRepository;
    }

    public void issueBook(String usn, String isbn) {
        // Buscar el estudiante por USN
        Student student = studentRepository.findStudentByUsn(usn);
        if (student == null) {
            throw new IllegalArgumentException("Student not found with USN: " + usn);
        }

        // Buscar el libro por ISBN
        Book book = bookRepository.findByIsbn(isbn);
        if (book == null) {
            throw new IllegalArgumentException("Book not found with ISBN: " + isbn);
        }

        // Validar si ya existe un préstamo asociado al estudiante o al libro
        if (issuesRepository.existsByIssueStudent_Usn(usn)) {
            throw new IllegalStateException("There is already an issue associated with this USN.");
        }

        if (issuesRepository.existsByIssueBook_Isbn(isbn)) {
            throw new IllegalStateException("There is already an issue associated with this ISBN.");
        }

        // Crear y guardar el préstamo
        Issue issue = new Issue(getDate(), getExpiredDate(), student, book);
        issuesRepository.save(issue);
    }


    public Issue findIssueByStudentUsn(String usn) {
        return issuesRepository.findIssuesByIssueStudent_Usn(usn);
    }

    private String getDate() {
        LocalDate actualDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return actualDate.format(formatter);
    }

    private String getExpiredDate() {
        LocalDate actualDate = LocalDate.now();
        LocalDate datePlusWeek = actualDate.plusWeeks(1);
        return datePlusWeek.toString();
    }
}