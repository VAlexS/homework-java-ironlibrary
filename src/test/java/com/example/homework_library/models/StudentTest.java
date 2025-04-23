package com.example.homework_library.models;

import com.example.homework_library.repositories.StudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    @DisplayName("Guardo un estudiante en la base de datos")
    void saveStudent(){
        Student student = new Student("843t", "Daniel");

        studentRepository.save(student);
    }

}