package pro.sky.kursovayatwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;

    private ExaminerService examinerService;

    @BeforeEach
    void setUp() {
        examinerService = new ExaminerServiceImpl(questionService);
    }

    @Test
    void getRandomQuestionWithThrowingException() {
        when(questionService.getAllQuestions())
                .thenReturn(Collections.emptyList());
        Assertions.assertThrows(RuntimeException.class, () -> examinerService.getRandomQuestion(1));
        verify(questionService, never()).getRandomQuestion(anyInt());
        verify(questionService, times(1)).getAllQuestions();
    }

    @Test
    void getRandomQuestion() {
        when(questionService.getAllQuestions())
                .thenReturn(List.of(
                        new Question("Вопрос первый", "Ответ первый"),
                        new Question("Вопрос второй", "Ответ второй"),
                        new Question("Вопрос третий", "Ответ третий"),
                        new Question("Вопрос четвёртый", "Ответ четвёртый"),
                        new Question("Вопрос пятый", "Ответ пятый")
                ));
        examinerService.getRandomQuestion(4);
        verify(questionService, atLeast(1)).getRandomQuestion(anyInt());
        verify(questionService, times(1)).getAllQuestions();
    }

}
