package com.example.homework_library.services;

import com.example.homework_library.models.Student;
import com.example.homework_library.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student findStudentByUsn(String usn) {
        return studentRepository.findStudentByUsn(usn);
    }

    public List<Student> listAllStudents() {
        return studentRepository.findAll();
    }
}