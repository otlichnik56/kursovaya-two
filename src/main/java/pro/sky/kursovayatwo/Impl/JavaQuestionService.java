package pro.sky.kursovayatwo.Impl;

import org.springframework.stereotype.Service;
import pro.sky.kursovayatwo.Class.Question;
import pro.sky.kursovayatwo.Repository.JavaQuestionRepository;
import pro.sky.kursovayatwo.Service.QuestionService;

import java.util.List;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {

    private final JavaQuestionRepository javaQuestionRepository;

    public JavaQuestionService(JavaQuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public List<Question> getAllQuestions() {
        return javaQuestionRepository.getAllQuestions();
    }

    @Override
    public void addQuestion(Question question) {
        javaQuestionRepository.addQuestion(question);
    }

    @Override
    public void removeQuestion(Question question) {
        javaQuestionRepository.removeQuestion(question);
    }

    @Override
    public int getRandomQuestion(int a) {
        final Random random = new Random();
        return random.nextInt(a);
    }

}
