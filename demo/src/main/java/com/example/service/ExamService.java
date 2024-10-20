package com.example.service;

import com.example.Repository.ExamRepository;
import com.example.Repository.StudentRepository;
import com.example.Repository.SubjectRepository;
import com.example.ResourceNotFoundException;
import com.example.model.Exam;
import com.example.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamService {
    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    public void registerStudentForExam(Long examId, Long studentId) {
        Exam exam = examRepository.findById(examId)
                .orElseThrow(() -> new ResourceNotFoundException("Exam not found"));
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        if (!student.getSubjects().contains(exam.getSubject())) {
            throw new IllegalArgumentException("Student is not enrolled in the subject");
        }

        student.getExams().add(exam);
        studentRepository.save(student);
    }
}
