package frames;

import entities.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import repositories.QuestionRepo;

public class UserHome extends JFrame implements ActionListener {

    private JPanel panel;
    private JLabel welcomeLabel;
    private JButton startQuizButton, viewHistoryButton, logoutButton;
    Question q =new Question();
    QuestionRepo qr =new QuestionRepo();

    public UserHome(String userName) {
        super("Examiner");
        initializeComponents(userName);
        setLayout();
    }

    private void initializeComponents(String userName) {
        // Panel
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.decode("#1877F2")); 

        // Welcome message
        welcomeLabel = new JLabel("Welcome, " + userName + "!");
        welcomeLabel.setBounds(0, 50, 1100, 50); 
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30)); 
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setForeground(Color.BLUE); 

        
        startQuizButton = new JButton("Start Quiz");
        startQuizButton.setBounds(450, 150, 200, 40);
        startQuizButton.setFont(new Font("Arial", Font.PLAIN, 16));
        startQuizButton.setBackground(Color.GREEN); 
        startQuizButton.setForeground(Color.WHITE); 
        startQuizButton.addActionListener(this);

    
        viewHistoryButton = new JButton("View Quiz History");
        viewHistoryButton.setBounds(450, 220, 200, 40); 
        viewHistoryButton.setFont(new Font("Arial", Font.PLAIN, 16));
        viewHistoryButton.setBackground(Color.BLUE); 
        viewHistoryButton.setForeground(Color.WHITE);
        viewHistoryButton.addActionListener(this);

      
        logoutButton = new JButton("Log Out");
        logoutButton.setBounds(450, 290, 200, 40); 
        logoutButton.setFont(new Font("Arial", Font.PLAIN, 16));
        logoutButton.setBackground(Color.RED); 
        logoutButton.setForeground(Color.WHITE);
        logoutButton.addActionListener(this);

       
        panel.add(welcomeLabel);
        panel.add(startQuizButton);
        panel.add(viewHistoryButton);
        panel.add(logoutButton);
    }

    private void setLayout() {
       
        this.add(panel);
        this.setSize(1100, 700); 
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == startQuizButton) {
        JOptionPane.showMessageDialog(this, "Starting Quiz...");
        this.setVisible(false);

        
        QuestionRepo qr = new QuestionRepo();

       List<Question> ql=new ArrayList<>();
       

        
        ql = qr.getAllQuestions(); 

        
        QuizFrame quizFrame = new QuizFrame(ql);
        quizFrame.setVisible(true);

        } else if (e.getSource() == viewHistoryButton) {
            JOptionPane.showMessageDialog(this, "Showing Quiz History...");
           
        } else if (e.getSource() == logoutButton) {
            JOptionPane.showMessageDialog(this, "Logging Out...");
            this.dispose();
            new Home(); 
        }
    }
}

   
