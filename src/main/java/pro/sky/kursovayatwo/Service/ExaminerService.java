package pro.sky.kursovayatwo.Service;

import pro.sky.kursovayatwo.Class.Question;

import java.util.Set;

public interface ExaminerService {

    Set<Question> getRandomQuestion(int a);

}
