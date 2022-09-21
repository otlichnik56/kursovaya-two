package pro.sky.kursovayatwo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JavaQuestionController {

    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }


    @GetMapping(path = "/exam/java")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping (path = "/exam/java/add")
    public String addQuestion(@RequestParam("question") String question,
                            @RequestParam("answer") String answer) {
        Question questionAnswer = new Question(question, answer);
        questionService.addQuestion(questionAnswer);
        return "Вопрос и ответ успешно добавлены";
    }

    @GetMapping(path = "/exam/java/remove")
    public String removeQuestion(@RequestParam("question") String question,
                               @RequestParam("answer") String answer) {
        Question questionAnswer = new Question(question, answer);
        questionService.removeQuestion(questionAnswer);
        return "Вопрос и ответ успешно удалены";
    }




}
