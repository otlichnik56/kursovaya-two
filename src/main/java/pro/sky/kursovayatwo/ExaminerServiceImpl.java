package pro.sky.kursovayatwo;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;


    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public List<Question> getRandomQuestion(int a) {
        return questionService.getRandomQuestion(a);
    }
}
