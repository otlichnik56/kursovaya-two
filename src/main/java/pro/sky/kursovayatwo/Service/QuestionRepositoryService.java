package pro.sky.kursovayatwo.Service;

import pro.sky.kursovayatwo.Class.Question;

import java.util.List;

public interface QuestionRepositoryService {
    List<Question> getAllQuestions();

    void addQuestion(Question question);

    void removeQuestion(Question question);
}
