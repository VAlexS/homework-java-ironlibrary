package com.example.homework_libraty.repositories;

import com.example.homework_libraty.models.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssuesRepository extends JpaRepository<Issue, Integer> {
}
