package pro.sky.kursovayatwo.Repository;

import org.springframework.stereotype.Repository;
import pro.sky.kursovayatwo.Class.Question;
import pro.sky.kursovayatwo.Service.QuestionRepositoryService;

import java.util.List;

@Repository
public class MathQuestionRepository implements QuestionRepositoryService {

    private final List<Question> questions;

    public MathQuestionRepository(List<Question> questions) {
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

}
