package com.example.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "subjects")
    private List<Student> students = new ArrayList<>();

    @OneToMany(mappedBy = "subject")
    private List<Exam> exams = new ArrayList<>();

    public Subject() {
    }

    // Getters and Setters
}

