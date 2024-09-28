package entities;
import java.util.*;

public class Question {

    private String id;                
    private String questionText;      
    private String correctAnswer;      
             
    private List<String> options;     

   
    public Question() {
        this.id = "";
        this.questionText = "";
        this.correctAnswer = "";
        
        this.options = new ArrayList<>();
    }

    // Parameterized constructor
    public Question(String id, String questionText, String correctAnswer, List<String> options) {
        this.id = id;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        
        this.options = new ArrayList<>(options);
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

  
    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

   

    
    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String showString()
    {

        String s ="Question number "+this.id+" \n Question: "+this.questionText+"\n Answer "+this.correctAnswer;

        return s ;


    }

   
  
    public String toString() {
        return this.id + "~" + this.questionText + "~" + this.correctAnswer + "~" + String.join("~", this.options);
    }
    

    public Question formQuestion (String s){

       String arr[]=s.split("~");

       if (arr.length>3){

        this.id =arr[0];
        this.questionText=arr[1];
        this.correctAnswer=arr[2];
        this.options = new ArrayList<>();
        options.add(arr[3]);
        options.add(arr[4]);
        options.add(arr[5]);
        options.add(arr[6]);


    }

    else {
        // Handle invalid format or missing fields
        throw new IllegalArgumentException("Invalid question format: " + s);}
    
    return this;

    
}

}

