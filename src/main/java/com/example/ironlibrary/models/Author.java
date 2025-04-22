package com.example.ironlibrary.models;

import jakarta.persistence.*;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int authorId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "author_book", referencedColumnName = "isbn")
    private Book authorBook;

    public Author() {
    }

    public Author(String name, String email, Book authorBook) {
        setName(name);
        setEmail(email);
        setAuthorBook(authorBook);
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Book getAuthorBook() {
        return authorBook;
    }

    public void setAuthorBook(Book authorBook) {
        this.authorBook = authorBook;
    }

    @Override
    public String toString() {
        return "Author {\n" +
                "    authorId=" + authorId + ",\n" +
                "    name='" + name + "',\n" +
                "    email='" + email + "',\n" +
                "    authorBook=" + authorBook + "\n" +
                "}";
    }
}
