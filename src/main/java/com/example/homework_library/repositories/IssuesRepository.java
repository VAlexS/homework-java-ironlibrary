package com.example.homework_library.repositories;

import com.example.homework_library.models.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssuesRepository extends JpaRepository<Issue, Integer> {
}
