package pro.sky.kursovayatwo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService{

    private  final List<Question> questions = new ArrayList<>(List.of(
            new Question("Вопрос первый", "Ответ первый"),
            new Question("Вопрос второй", "Ответ второй"),
            new Question("Вопрос третий", "Ответ третий"),
            new Question("Вопрос четвёртый", "Ответ четвёртый"),
            new Question("Вопрос пятый", "Ответ пятый")
    ));

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
