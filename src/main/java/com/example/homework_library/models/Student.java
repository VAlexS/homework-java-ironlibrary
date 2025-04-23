package com.example.homework_library.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

    @Id
    private String usn;

    @Column(name = "name")
    private String name;

    public Student() {
    }

    public String getUsn() {
        return usn;
    }

    public Student(String usn, String name) {
        setUsn(usn);
        setName(name);
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student {\n" +
                "    usn='" + usn + "',\n" +
                "    name='" + name + "'\n" +
                "}";
    }
}