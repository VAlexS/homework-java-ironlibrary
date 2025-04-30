package com.example.homework_library.services;

import com.example.homework_library.models.Student;
import com.example.homework_library.repositories.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindStudentByUsn() {
        Student student = new Student("USN123", "John Doe");
        when(studentRepository.findStudentByUsn("USN123")).thenReturn(student);

        Student result = studentService.findStudentByUsn("USN123");

        assertNotNull(result);
        assertEquals("USN123", result.getUsn());
    }

    @Test
    void testListAllStudents() {
        when(studentRepository.findAll()).thenReturn(List.of(new Student("USN123", "John Doe")));

        List<Student> students = studentService.listAllStudents();

        assertFalse(students.isEmpty());
        assertEquals(1, students.size());
    }
}