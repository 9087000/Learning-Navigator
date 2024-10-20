package  com.example.controller;
import com.example.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exams")
public class ExamController {
    @Autowired
    private ExamService examService;

    @PostMapping("/{examId}/register/{studentId}")
    public ResponseEntity<String> registerStudent(@PathVariable Long examId, @PathVariable Long studentId) {
        examService.registerStudentForExam(examId, studentId);
        return ResponseEntity.ok("Student registered for exam");
    }
}
