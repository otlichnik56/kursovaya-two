package pro.sky.kursovayatwo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService{

    private final List<Question> questions;

    public JavaQuestionService(List<Question> questions) {
        this.questions = questions;
    }

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
    public int getRandomQuestion(int a) {
        final Random random = new Random();
        return random.nextInt(a);
    }

}
