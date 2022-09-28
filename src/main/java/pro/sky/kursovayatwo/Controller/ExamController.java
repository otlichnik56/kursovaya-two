package pro.sky.kursovayatwo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.kursovayatwo.Service.ExaminerService;
import pro.sky.kursovayatwo.Class.Question;

import java.util.Set;

@RestController
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(path = "/exam/get/{amount}")
    public Set<Question> getQuestions(@PathVariable int amount) {
        return examinerService.getRandomQuestion(amount);
    }
}
