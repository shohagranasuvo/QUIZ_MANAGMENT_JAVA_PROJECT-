package interfaces;

import entities.Question;
import java.util.List;

public interface IQuestionRepo {
    void addQuestion(Question question);
    void updateQuestion(Question question);
    void deleteQuestion(String id);
    List<Question> getAllQuestions();
    Question searchQuestion(String questionName);
}
