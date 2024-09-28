package frames;

import entities.Question;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import repositories.QuestionRepo;


public class Admin extends JFrame implements ActionListener {

    // Components
    private JPanel panel;
    private JLabel titleLabel, idLabel, questionLabel, correctAnswerLabel, optionsLabel;
    private JTextField idField, questionField, correctAnswerField;
    private JTextField option1Field, option2Field, option3Field, option4Field;
    private JButton createButton, readButton, updateButton, deleteButton,exiButton,showAllQuestion;
    private ImageIcon ICON;
    

    QuestionRepo qr=new QuestionRepo();
    Question q =new Question();
    Cursor Hand =new Cursor(Cursor.HAND_CURSOR);
    
    public Admin() {
        super("ADMIN");
        initializeComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 60, 1100, 700); // Frame size and position
        setVisible(true);
        panel.setBackground(Color.decode("#1877F2"));
        
        
        ICON = new ImageIcon(("Image/admin-panel.png"));

        this.setIconImage(ICON.getImage());
    }

    public void initializeComponents() {
        // Create panel
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY); // Set background color

        // Title Label
        titleLabel = new JLabel("SET UP QUESTION");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(350, 20, 400, 50); // Position and size
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(titleLabel);

        // Question ID Label and TextField
        idLabel = new JLabel("Question ID:");
        idLabel.setFont(new Font("Arial", Font.PLAIN+Font.BOLD, 18));
        idLabel.setBounds(300, 80, 150, 30); 
        panel.add(idLabel);

        idField = new JTextField();
        idField.setBounds(450, 80, 300, 30);
        panel.add(idField);

        // Question Label and TextField
        questionLabel = new JLabel("Question:");
        questionLabel.setFont(new Font("Arial", Font.PLAIN+Font.BOLD, 18));
        questionLabel.setBounds(300, 130, 150, 30); 
        panel.add(questionLabel);

        questionField = new JTextField();
        questionField.setBounds(450, 130, 300, 30); 
        panel.add(questionField);

       
        correctAnswerLabel = new JLabel("Correct Answer:");
        correctAnswerLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        correctAnswerLabel.setBounds(300, 180, 150, 30); 
        panel.add(correctAnswerLabel);

        correctAnswerField = new JTextField();
        correctAnswerField.setBounds(450, 180, 300, 30); 
        panel.add(correctAnswerField);

        // Options Label
        optionsLabel = new JLabel("Options:");
        optionsLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        optionsLabel.setBounds(300, 230, 150, 30); 
        panel.add(optionsLabel);

        // Option Fields
        option1Field = new JTextField();
        option1Field.setBounds(450, 230, 300, 30);
        panel.add(option1Field);

        option2Field = new JTextField();
        option2Field.setBounds(450, 270, 300, 30); 
        panel.add(option2Field);

        option3Field = new JTextField();
        option3Field.setBounds(450, 310, 300, 30); 
        panel.add(option3Field);

        option4Field = new JTextField();
        option4Field.setBounds(450, 350, 300, 30); 
        panel.add(option4Field);

        


        // CRUD Buttons
        createButton = new JButton("Create");
        createButton.setFont(new Font("Arial", Font.PLAIN, 16));
        createButton.setBounds(200, 420, 120, 40); 
        createButton.setBackground(Color.GREEN);
        createButton.setForeground(Color.WHITE);
        createButton.addActionListener(this);
        createButton.setCursor(Hand);
        panel.add(createButton);

        readButton = new JButton("Read");
        readButton.setFont(new Font("Arial", Font.PLAIN, 16));
        readButton.setBounds(350, 420, 120, 40); 
        readButton.setBackground(Color.BLUE);
        readButton.setForeground(Color.WHITE);
        readButton.addActionListener(this);
        readButton.setCursor(Hand);
        panel.add(readButton);

        updateButton = new JButton("Update");
        updateButton.setFont(new Font("Arial", Font.PLAIN, 16));
        updateButton.setBounds(500, 420, 120, 40); 
        updateButton.setBackground(Color.ORANGE);
        updateButton.setForeground(Color.WHITE);
        updateButton.addActionListener(this);
        updateButton.setCursor(Hand);
        panel.add(updateButton);

        deleteButton = new JButton("Delete");
        deleteButton.setFont(new Font("Arial", Font.PLAIN, 16));
        deleteButton.setBounds(650, 420, 120, 40); 
        deleteButton.setBackground(Color.RED);
        deleteButton.setForeground(Color.WHITE);
        deleteButton.addActionListener(this);
        deleteButton.setCursor(Hand);
        panel.add(deleteButton);

        exiButton = new JButton("Log out");
        exiButton.setFont(new Font("Arial", Font.PLAIN, 16));
        exiButton.setBounds(800, 420, 120, 40); 
        exiButton.setBackground(Color.RED);
        exiButton.setForeground(Color.WHITE);
        exiButton.setCursor(Hand);
        exiButton.addActionListener(this);
        
        panel.add(exiButton);

        showAllQuestion = new JButton("QUESTION TABLE");
        showAllQuestion.setFont(new Font("Arial", Font.PLAIN+Font.BOLD, 16));
        showAllQuestion.setBounds(450, 480, 250, 40); 
        showAllQuestion.setBackground(Color.WHITE);
        showAllQuestion.setForeground(Color.GREEN);
        showAllQuestion.setCursor(Hand);
        showAllQuestion.addActionListener(this);
        
        panel.add(showAllQuestion);


        
        add(panel);
    }

    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createButton) {


            String questionID = idField.getText();
            String questionText = questionField.getText();
            String correctAnswer = correctAnswerField.getText();
            ArrayList<String> options = new ArrayList<>();
            options.add(option1Field.getText());
            options.add(option2Field.getText());
            options.add(option3Field.getText());
            options.add(option4Field.getText());
           
            Question q =new Question(questionID,questionText,correctAnswer,options);
            if(qr.searchQuestion(q.getId())==null){
            qr.addQuestion(q);
            JOptionPane.showMessageDialog(this, "Question added successfully!");
            idField.setText("");
            questionField.setText("");
            correctAnswerField.setText("");
            option1Field.setText("");
            option2Field.setText("");
            option3Field.setText("");
            option4Field.setText("");


            }

            else{


                JOptionPane.showMessageDialog(this, "Question already exist");
            }


          

            

        } 
        
        else if (e.getSource() == readButton) {


            String questionIDD = idField.getText();

            if (((qr.searchQuestion(questionIDD)))!=null) {

                Question q = qr.searchQuestion(questionIDD);
                String show = q.showString();

                JOptionPane.showMessageDialog(this, show);



            }

           

          


            else 
            {

                JOptionPane.showMessageDialog(this, "Question ID is in Valid");


            }

          


            
        }


         else if (e.getSource() == updateButton) {



            String questionID = idField.getText();

            if (((qr.searchQuestion(questionID)))!=null) {


            String questionText = questionField.getText();
            String correctAnswer = correctAnswerField.getText();
            ArrayList<String> options = new ArrayList<>();
            options.add(option1Field.getText());
            options.add(option2Field.getText());
            options.add(option3Field.getText());
            options.add(option4Field.getText());

            Question qq = new Question(questionID,questionText,correctAnswer,options);


            JOptionPane.showMessageDialog(this, "Updating Question: " );

            qr.updateQuestion(qq);
            
        }
        else{

            JOptionPane.showMessageDialog(this, "Question ID is in Valid");


        }}
        
        else if (e.getSource() == deleteButton) {

            String questionID = idField.getText();

            if (((qr.searchQuestion(questionID)))!=null) {


            JOptionPane.showMessageDialog(this, "Deleting Question with ID: " + questionID);
           qr.deleteQuestion(questionID);
        }

       
    }
    else if(e.getSource()==exiButton)
    {
        this.setVisible(false);
        Home h =new Home();
        h.setVisible(true);



    }


   else if (e.getSource() == showAllQuestion) {
      

    try { this.setVisible(false);
        List<Question> que = qr.getAllQuestions(); 

        if(que!=null){
    
        
        QuestionTableFrame qtf = new QuestionTableFrame(que);
    
        qtf.setVisible(true);
        
    
    }

    else
    {

        JOptionPane.showMessageDialog(this,"NO QUESTION");

    }
        
    } 
    
    catch (Exception ef) {
        ef.getStackTrace();
    }

    
   
   
}


}}
