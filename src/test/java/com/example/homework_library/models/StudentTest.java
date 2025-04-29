package com.example.homework_library.models;

import com.example.homework_library.repositories.StudentRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
class StudentTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    @DisplayName("Guardo un estudiante en la base de datos")
    @Transactional
    @Rollback(false)
    void saveStudent(){
        Student student = new Student("123a", "Daniel");

        studentRepository.save(student);
    }

    @Test
    @DisplayName("Listar todos los estudiantes")
    void findAll(){
        System.out.println("============================");
        System.out.println("Los estudiantes que hemos encontrado son: ");
        System.out.println(studentRepository.findAll());
        System.out.println("===================");
    }

}