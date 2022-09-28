package pro.sky.kursovayatwo.Controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.kursovayatwo.Class.Question;
import pro.sky.kursovayatwo.Service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("math")
public class MathQuestionController {

    private final QuestionService questionService;

    public MathQuestionController(@Qualifier("mathQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }


    @GetMapping(path = "")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping (path = "add")
    public String addQuestion(@RequestParam("question") String question,
                              @RequestParam("answer") String answer) {
        Question questionAnswer = new Question(question, answer);
        questionService.addQuestion(questionAnswer);
        return "Вопрос и ответ успешно добавлены";
    }

    @GetMapping(path = "remove")
    public String removeQuestion(@RequestParam("question") String question,
                                 @RequestParam("answer") String answer) {
        Question questionAnswer = new Question(question, answer);
        questionService.removeQuestion(questionAnswer);
        return "Вопрос и ответ успешно удалены";
    }

}