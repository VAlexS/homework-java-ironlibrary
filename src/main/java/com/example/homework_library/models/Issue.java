package com.example.homework_library.models;

import jakarta.persistence.*;

@Entity
@Table(name = "issue")
public class Issue {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int issueId;

    @Column(name = "issue_date")
    private String issueDate;

    @Column(name = "return_date")
    private String returnDate;

    @OneToOne
    @JoinColumn(name = "issue_student", referencedColumnName = "usn")
    private Student issueStudent;

    @OneToOne
    @JoinColumn(name = "issue_book", referencedColumnName = "isbn")
    private Book issueBook;

    public Issue() {
    }

    public Issue(String issueDate, String returnDate, Student issueStudent, Book issueBook) {
        setIssueDate(issueDate);
        setReturnDate(returnDate);
        setIssueStudent(issueStudent);
        setIssueBook(issueBook);
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

    public Student getIssueStudent() {
        return issueStudent;
    }

    public void setIssueStudent(Student issueStudent) {
        this.issueStudent = issueStudent;
    }

    public Book getIssueBook() {
        return issueBook;
    }

    public void setIssueBook(Book issueBook) {
        this.issueBook = issueBook;
    }

    @Override
    public String toString() {
        return "Issue {\n" +
                "    issueId=" + issueId + ",\n" +
                "    issueDate='" + issueDate + "',\n" +
                "    returnDate='" + returnDate + "',\n" +
                "    issueStudent=" + issueStudent + ",\n" +
                "    issueBook=" + issueBook + "\n" +
                "}";
    }
}