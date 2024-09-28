package entities ;

public class result {
    private User userr;         
    private Quiz quizz;         
    private int totalQuestions; 
    private int correctAnswers;
    private double score;     
     

   
    public result(User userr, Quiz quizz, int totalQuestions, int correctAnswers, double score) {
        this.userr = userr;
        this.quizz = quizz;
        this.totalQuestions = totalQuestions;
        this.correctAnswers = correctAnswers;
        this.score = score;
        
    }

   
    public User getUser() {
        return userr;
    }

    public void setUser(User userr) {
        this.userr = userr;
    }

    public Quiz getQuiz() {
        return quizz;
    }

    public void setQuiz(Quiz quizz) {
        this.quizz = quizz;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

  

   

  
    public void displayResult() {
        
      //  System.out.println("Result for: " +User);
        System.out.println("Quiz: " + quizz.getName());
        System.out.println("Total Questions: " + totalQuestions);
        System.out.println("Correct Answers: " + correctAnswers);
        System.out.println("Score: " + score);
        
    }


    public String toString ()
    {

        String s =  this.userr.toString() +"$"+this.quizz.toString()+"$"+this.totalQuestions+"$"+this.correctAnswers+"$"+String.valueOf(this.score);

        return s;





    }
}
