package com.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToMany(mappedBy = "exams")
    private List<Student> students = new ArrayList<>();

    public Exam() {
    }

    // Getters and Setters
}

