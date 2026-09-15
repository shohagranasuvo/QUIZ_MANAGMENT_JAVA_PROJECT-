package entities;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private String id;
    private String name;
    private List<Question> Questions;

    // Constructor
    public Quiz(String id, String name, List<Question> Questions) {
        this.id = id;
        this.name = name;
        this.Questions = Questions;
    }

   
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestions() {
        return Questions;
    }

    public void setQuestions(List<Question> Questions) {
        this.Questions = Questions;
    }

    
    public void addQuestion(Question Question) {
        this.Questions.add(Question);
    }

    
    public void removeQuestion(Question Question) {
        this.Questions.remove(Question);
    }

    
    public void displayQuiz() {
        System.out.println("Quiz ID: " + id);
        System.out.println("Quiz Name: " + name);
        System.out.println("Questions: ");
        for (Question Question : Questions) {
            System.out.println("- " + Question.getQuestionText());
        }
        }

        
         public String toString () {
            StringBuilder str = new StringBuilder(this.id + "~" + this.name + "~");
            
            for (Question question : this.Questions) {
                str.append(question.getQuestionText()).append("~");
            }
        
            // Remove the trailing "~" if needed
            if (str.length() > 0) {
                str.setLength(str.length() - 1);
            }
            
            return str.toString();
        }

        public Quiz formString(String s) {

            String[] arr = s.split("~");

        // Assign the id and name
        this.id = arr[0];
        this.name = arr[1];

        // Clear any existing questions and add new ones
        this.Questions = new ArrayList<>();

        // Iterate through the remaining parts of the array to form questions
        for (int i = 2; i < arr.length; i += 7) {
            // Since each question has an id, questionText, correctAnswer, and 4 options
            String questionId = arr[i];
            String questionText = arr[i + 1];
            String correctAnswer = arr[i + 2];
            List<String> options = new ArrayList<>();
            options.add(arr[i + 3]);
            options.add(arr[i + 4]);
            options.add(arr[i + 5]);
            options.add(arr[i + 6]);


            // Create a new Question object and add it to the list
            Question question = new Question(questionId, questionText, correctAnswer, options);
            this.Questions.add(question);
        }

        return this; 
           





        }
        

}


























