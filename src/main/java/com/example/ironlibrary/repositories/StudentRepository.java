package com.example.ironlibrary.repositories;

import com.example.ironlibrary.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
