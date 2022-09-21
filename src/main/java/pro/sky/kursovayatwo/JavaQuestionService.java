package pro.sky.kursovayatwo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JavaQuestionService implements QuestionService{

    private  final List<Question> questions = new ArrayList<>();

    @Override
    public List<Question> getAllQuestions() {
        return questions;
    }

    @Override
    public void addQuestion(Question question) {
        questions.add(question);
    }

    @Override
    public void removeQuestion(Question question) {
        questions.remove(question);
    }

    @Override
    public List<Question> getRandomQuestion(int a) {
        return questions;
    }
}
