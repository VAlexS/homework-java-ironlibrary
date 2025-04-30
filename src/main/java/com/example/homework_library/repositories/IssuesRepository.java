package com.example.homework_library.repositories;

import com.example.homework_library.models.Issue;
import com.example.homework_library.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssuesRepository extends JpaRepository<Issue, Integer> {

    //List<Issue> findIssuesByIssueStudent_Usn(String issueStudentUsn);
    Issue findIssuesByIssueStudent_Usn(String issueStudentUsn);
    Issue findIssuesByIssueBook_Isbn(String issueBookIsbn);
    boolean existsByIssueStudent_Usn(String usn);
    boolean existsByIssueBook_Isbn(String isbn);

}
