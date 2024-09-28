package frames;

import entities.Question;
import entities.User;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

public class QuizFrame extends JFrame implements ActionListener {

    private List<Question> questionList; 
    private int currentQuestionIndex = 0; 
    private int correctAnswers = 0; 

    // GUI components
    private JLabel questionLabel;
    private JRadioButton[] optionButtons;
    private ButtonGroup optionsGroup;
    private JButton nextButton;
    private JPanel optionsPanel;
    private JLabel feedbackLabel; 

    Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
    
    public QuizFrame(List<Question> questionList) {
        this.questionList = questionList;
        initComponents();
        
        
        this.setBounds(100, 60, 1100, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initComponents() {
        this.setLayout(null);
        this.getContentPane().setBackground(Color.decode("#F0F4C3")); 

        // Question label
        questionLabel = new JLabel("Question: ", JLabel.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 22));
        questionLabel.setBounds(50, 50, 1000, 50); 
        this.add(questionLabel);

        // Panel for options
        optionsPanel = new JPanel(new GridLayout(4, 1));
        optionsPanel.setBounds(300, 150, 500, 200);
        optionsPanel.setOpaque(false); 
        optionButtons = new JRadioButton[4];
        optionsGroup = new ButtonGroup();

        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JRadioButton();
            optionButtons[i].setFont(new Font("Arial", Font.PLAIN, 18));
            optionButtons[i].setOpaque(false); 
            optionButtons[i].setCursor(handCursor);
            optionsGroup.add(optionButtons[i]);
            optionsPanel.add(optionButtons[i]);
        }
        this.add(optionsPanel);

     
        nextButton = new JButton("Next");
        nextButton.setFont(new Font("Arial", Font.BOLD, 20));
        nextButton.setBackground(Color.decode("#00C853")); 
        nextButton.setForeground(Color.WHITE);
        nextButton.setBounds(500, 400, 150, 50); 
        nextButton.setCursor(handCursor);
        nextButton.addActionListener(this);
        this.add(nextButton);

        
        feedbackLabel = new JLabel("", JLabel.CENTER);
        feedbackLabel.setFont(new Font("Arial", Font.BOLD, 20));
        feedbackLabel.setBounds(300, 500, 500, 50); 
        this.add(feedbackLabel);

      
        displayQuestion();
    }

    private void displayQuestion() {
        
        Question currentQuestion = questionList.get(currentQuestionIndex);
        questionLabel.setText("Question: " + currentQuestion.getQuestionText());

        
        List<String> options = currentQuestion.getOptions();
        for (int i = 0; i < optionButtons.length; i++) {
            if (i < options.size()) {
                optionButtons[i].setText(options.get(i));
                optionButtons[i].setVisible(true);
            } else {
                optionButtons[i].setVisible(false); 
            }
        }
        feedbackLabel.setText(""); 
    }

   
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {
            // Check if the selected answer is correct
            if (checkAnswer()) {
                feedbackLabel.setText("Correct!");
                feedbackLabel.setFont(new Font("Arial", Font.BOLD, 30));
                feedbackLabel.setForeground(Color.GREEN);
                correctAnswers++;
            } else {
                feedbackLabel.setText("Wrong!");
                feedbackLabel.setFont(new Font("Arial", Font.BOLD, 30));
                feedbackLabel.setForeground(Color.RED);
            }

           
            Timer timer = new Timer(2000, event -> {
                currentQuestionIndex++;
                if (currentQuestionIndex < questionList.size()) {
                    // Display the next question
                    optionsGroup.clearSelection(); // Clear previous selection
                    displayQuestion();
                } else {
                    // End of quiz, show result
                    showResult();
                }
            });
            timer.setRepeats(false);
            timer.start();
        }
    }

    private boolean checkAnswer() {
        Question currentQuestion = questionList.get(currentQuestionIndex);

        // Get the selected option
        for (int i = 0; i < optionButtons.length; i++) {
            if (optionButtons[i].isSelected()) {
                String selectedAnswer = optionButtons[i].getText();
                return selectedAnswer.equals(currentQuestion.getCorrectAnswer());
            }
        }
        return false; // If no option is selected, assume wrong answer
    }

    private void showResult() {
        JOptionPane.showMessageDialog(this, "You got " + correctAnswers + " out of " + questionList.size() + " correct!");
        this.setVisible(false);
        User u = new User();

        UserHome user = new UserHome(u.getFirstName());
        user.setVisible(true);
    }
}
