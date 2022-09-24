package pro.sky.kursovayatwo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
// import java.util.HashSet;
// import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public List<Question> getRandomQuestion(int a) {
        List<Question> randomQuestion = new ArrayList<>();
        List<Question> allQuestions = questionService.getAllQuestions();
        int size = allQuestions.size();
        if(a > size){
            throw new RuntimeException("BAD_REQUEST");
        } else {
            for (int i = 0; i < a; i++) {
                int m = questionService.getRandomQuestion(size);
                Question question = allQuestions.get(m);
                while (randomQuestion.contains(question)) {
                    m = questionService.getRandomQuestion(size);
                }
                question = allQuestions.get(m);
                randomQuestion.add(i, question);
            }
            return randomQuestion;
        }

            // можно такую проверку сделать
//            Set<Question> result = new HashSet<>();
//            int sizeSet = questionService.getAllQuestions().size();
//            result.add(questionService.getAllQuestions().get(questionService.getRandomQuestion(sizeSet)));
//            while (result.size() <= a) {
//                result.add(questionService.getAllQuestions().get(questionService.getRandomQuestion(sizeSet)));
//            }

    }

}
