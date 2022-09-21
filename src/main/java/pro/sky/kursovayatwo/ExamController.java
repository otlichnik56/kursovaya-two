package pro.sky.kursovayatwo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(path = "/exam/java")
    public List<Question> getQuestions(int amount) {
        return examinerService.getRandomQuestion(amount);
    }
}
