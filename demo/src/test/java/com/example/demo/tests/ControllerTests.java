package com.example.demo.tests;

import com.example.ResourceNotFoundException;
import com.example.controller.ExamController;
import com.example.service.ExamService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ExamController.class)
public class ExamControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExamService examService;

    @Test
    public void testRegisterStudent() throws Exception {
        mockMvc.perform((RequestBuilder) post("/exams/1/register/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Student registered for exam"));
    }

    @Test
    public void testRegisterStudent_NotFound() throws Exception {
        Mockito.doThrow(new ResourceNotFoundException("Exam not found")).when(examService).registerStudentForExam(1L, 1L);

        mockMvc.perform((RequestBuilder) post("/exams/1/register/1"))
                .andExpect(status().isNotFound());
    }
}

