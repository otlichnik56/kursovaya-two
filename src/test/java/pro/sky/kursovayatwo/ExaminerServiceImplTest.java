package pro.sky.kursovayatwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.kursovayatwo.Class.Question;
import pro.sky.kursovayatwo.Impl.ExaminerServiceImpl;
import pro.sky.kursovayatwo.Service.ExaminerService;
import pro.sky.kursovayatwo.Service.QuestionService;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private QuestionService javaQuestionService;

    @Mock
    private QuestionService mathQuestionService;

    private ExaminerService examinerService;

    @BeforeEach
    void setUp() {
        examinerService = new ExaminerServiceImpl(javaQuestionService, mathQuestionService);
    }

    @Test
    void getRandomQuestionWithThrowingException() {
        when(javaQuestionService.getAllQuestions())
                .thenReturn(Collections.emptyList());
        Assertions.assertThrows(RuntimeException.class, () -> examinerService.getRandomQuestion(1));
        verify(javaQuestionService, never()).getRandomQuestion(anyInt());
        verify(javaQuestionService, times(1)).getAllQuestions();
    }

    @Test
    void getRandomQuestion() {
        when(javaQuestionService.getAllQuestions())
                .thenReturn(List.of(
                        new Question("Вопрос первый", "Ответ первый"),
                        new Question("Вопрос второй", "Ответ второй"),
                        new Question("Вопрос третий", "Ответ третий"),
                        new Question("Вопрос четвёртый", "Ответ четвёртый"),
                        new Question("Вопрос пятый", "Ответ пятый")
                ));
        examinerService.getRandomQuestion(4);
        verify(javaQuestionService, atLeast(1)).getRandomQuestion(anyInt());
        verify(javaQuestionService, times(1)).getAllQuestions();
    }

}
