package repositories;
import entities.*;
import interfaces.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionRepo implements IQuestionRepo {

    private String file = "repositories/Data/Question.txt";
    private FileIO fio = new FileIO();

    public void addQuestion(Question question) {
        List<Question> questions = getAllQuestions(); 
        questions.add(question);
        saveQuestions(questions);
    }

    public void updateQuestion(Question question) {
        List<Question> questions = this.getAllQuestions();

        boolean found = false;
        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(i).getId().equals(question.getId())) {
                questions.set(i, question); 
                found = true;
                break;
            }
        }

        if (found) {
            saveQuestions(questions);
        } else {
            System.out.println("Question not found");
        }
    }

    public void deleteQuestion(String id) {
        List<Question> questions = getAllQuestions();
        boolean questionFound = questions.removeIf(question -> question.getId().equals(id)); // Deleting by ID
    
        if (questionFound) {
            saveQuestions(questions);
            System.out.println("Question deleted successfully.");
        } else {
            System.out.println("Question not found with ID: " + id);
        }
    }
    
    public List<Question> getAllQuestions() {
        List<String> data = fio.readFile(file);
        List<Question> questions = new ArrayList<>();

        for (String line : data) {
            try {
                Question question = new Question().formQuestion(line);
                questions.add(question);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid question data format: " + line);
            }
        }
        return questions;
    }

    private void saveQuestions(List<Question> questions) {
        List<String> data = new ArrayList<>();
        for (Question question : questions) {
            data.add(question.toString());
        }
        fio.writeFile(file, data);
    }

    public Question searchQuestion(String questionId) {
        for (Question question : getAllQuestions()) {
            if (question.getId().equals(questionId)) {
                return question;
            }
        }
        return null;
    }
}
