package pro.sky.kursovayatwo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;

import java.util.List;
import java.util.Set;


@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;
    private final Set<Question> result = new HashSet<>();

    public ExaminerServiceImpl(QuestionService javaQuestionService, QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    private List<Question> unitLists() {
        List<Question> result = new ArrayList<>();
        result.addAll(javaQuestionService.getAllQuestions());
        result.addAll(mathQuestionService.getAllQuestions());
        return result;
    }

    @Override
    public Set<Question> getRandomQuestion(int a) {
        int size = javaQuestionService.getAllQuestions().size() + mathQuestionService.getAllQuestions().size();
        List<Question> unitArrays = unitLists();
        if(a > size){
            throw new FewerQuestionsException();
        } else {
            while (result.size() < a) {
                result.add(unitArrays.get(javaQuestionService.getRandomQuestion(size)));
            }
            return result;
        }
    }

}
