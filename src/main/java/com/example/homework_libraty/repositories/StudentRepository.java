package com.example.homework_libraty.repositories;

import com.example.homework_libraty.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {

    Student findByName(String studentName);
}
