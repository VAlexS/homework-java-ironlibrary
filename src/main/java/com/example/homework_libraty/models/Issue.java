package com.example.homework_libraty.models;

import jakarta.persistence.*;

@Entity
@Table(name = "issues")
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issue_id")
    private int issueId;

    @Column(name = "issue_date")
    private String issueDate;

    @Column(name = "return_date")
    private String returnDate;

    @OneToOne
    @JoinColumn(name = "issue_book", referencedColumnName = "isbm")
    private Book issueBook;

    @OneToOne
    @JoinColumn(name = "issue_student", referencedColumnName = "usn")
    private Student issueStudent;

    public Issue() {
    }

    public Issue(String issueDate, String returnDate, Book issueBook, Student issueStudent) {
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.issueBook = issueBook;
        this.issueStudent = issueStudent;
    }

    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Book getIssueBook() {
        return issueBook;
    }

    public void setIssueBook(Book issueBook) {
        this.issueBook = issueBook;
    }

    public Student getIssueStudent() {
        return issueStudent;
    }

    public void setIssueStudent(Student issueStudent) {
        this.issueStudent = issueStudent;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "issueId=" + issueId +
                ", issueDate='" + issueDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", issueBook=" + issueBook +
                ", issueStudent=" + issueStudent +
                '}';
    }
}
