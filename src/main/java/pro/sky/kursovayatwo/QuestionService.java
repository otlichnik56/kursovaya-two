package pro.sky.kursovayatwo;

import java.util.List;

public interface QuestionService {

    List<Question> getAllQuestions();

    void addQuestion(Question question);

    void removeQuestion(Question question);

    int getRandomQuestion(int a);

}
