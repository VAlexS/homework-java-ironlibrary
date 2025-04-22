package com.example.ironlibrary.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

    @Id
    private String isbn;

    @Column(name = "title")
    private String title;

    @Column(name = "category")
    private String category;

    @Column(name = "quantity")
    private int quantity;

    public Book() {

    }

    public Book(String isbn, String title, String category, int quantity) {
        setIsbn(isbn);
        setTitle(title);
        setCategory(category);
        setQuantity(quantity);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book {\n" +
                "    isbn='" + isbn + "',\n" +
                "    title='" + title + "',\n" +
                "    category='" + category + "',\n" +
                "    quantity=" + quantity + "\n" +
                "}";
    }
}
