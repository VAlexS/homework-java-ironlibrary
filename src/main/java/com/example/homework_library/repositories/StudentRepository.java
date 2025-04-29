package com.example.homework_library.repositories;

import com.example.homework_library.models.Student;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    Student findByName(String studentName);
    Student findStudentByUsn(String usn);
}
