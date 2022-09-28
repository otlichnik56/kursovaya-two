package pro.sky.kursovayatwo.Impl;

import org.springframework.stereotype.Service;
import pro.sky.kursovayatwo.Class.Question;
import pro.sky.kursovayatwo.Repository.MathQuestionRepository;
import pro.sky.kursovayatwo.Service.QuestionService;

import java.util.List;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {

    private final MathQuestionRepository mathQuestionRepository;

    public MathQuestionService(MathQuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }

    @Override
    public List<Question> getAllQuestions() {
        return mathQuestionRepository.getAllQuestions();
    }

    @Override
    public void addQuestion(Question question) {
        mathQuestionRepository.addQuestion(question);
    }

    @Override
    public void removeQuestion(Question question) {
        mathQuestionRepository.removeQuestion(question);
    }

    @Override
    public int getRandomQuestion(int a) {
        final Random random = new Random();
        return random.nextInt(a);
    }

}