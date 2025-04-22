package com.example.ironlibrary.repositories;

import com.example.ironlibrary.models.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {
}
