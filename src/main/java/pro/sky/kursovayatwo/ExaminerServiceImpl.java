package pro.sky.kursovayatwo;

import org.springframework.stereotype.Service;

import java.util.HashSet;

import java.util.Set;


@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;
    private final Set<Question> result = new HashSet<>();
    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Set<Question> getRandomQuestion(int a) {
        int size = questionService.getAllQuestions().size();
        if(a > size){
            throw new FewerQuestionsException();
        } else {
            while (result.size() < a) {
                result.add(questionService.getAllQuestions().get(questionService.getRandomQuestion(size)));
            }
            return result;
        }

    }

}
