package pro.sky.kursovayatwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

    @Mock
    private List<Question> questions;

    private QuestionService questionService;

    @BeforeEach
    public void setUp() {
        questionService = new JavaQuestionService(questions);
    }

    @Test
    void getAllQuestions() {
        List<Question> actualQuestions = questionService.getAllQuestions();
        Assertions.assertEquals(questions, actualQuestions);
    }

    @Test
    void addQuestion() {
        Question question = new Question("Question six", "test");
        questionService.addQuestion(question);
        verify(questions, times(1)).add(question);
    }

    @Test
    void removeQuestion() {
        Question question = new Question("Question six", "test");
        questionService.removeQuestion(question);
        verify(questions, times(1)).remove(question);
    }
}



