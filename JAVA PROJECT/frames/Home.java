package frames;


import entities.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import repositories.UserRepo;

public class Home extends JFrame implements ActionListener // MouseMotionListener ,KeyListener
{

    private Panel panel;
    private JLabel logIn, welcome, userNm, Pass, JsideImg, underLine, notAccount, fillArea, passArea;
    private JTextField namef;
    private JPasswordField passf;
    private ImageIcon logInImg, ICON;
    private Image SideImg4resize, resize;
    private Font big, medium, medium1, small;
   // private JRadioButton Admin, user;
    private JCheckBox RememberMe;
    private ButtonGroup buttonGrp1;
    private Cursor hand;
    private JButton forgot, LogIN, SignUP;

    public Home() {
        super("LOG IN");
        inicom();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 60, 1100, 700);
        setVisible(true);

    }

    public void inicom() {

        panel = new Panel();
        panel.setBackground(Color.decode("#1877F2"));
        this.panel.setLayout(null);
        ICON = new ImageIcon(("Image/login.png"));

        this.setIconImage(ICON.getImage());

        big = new Font("Segoe UI", Font.BOLD + Font.PLAIN, 40);

        medium = new Font("Segoe UI", Font.BOLD + Font.PLAIN, 25);
        medium1 = new Font("Segoe UI", Font.BOLD + Font.PLAIN, 20);
        small = new Font("Segoe UI", Font.BOLD + Font.PLAIN, 14);

        hand = new Cursor(Cursor.HAND_CURSOR);

        // logInImg =new ImageIcon(("Image/login.jpg"));
        logInImg = new ImageIcon("Image/logIn.jpg");
        SideImg4resize = logInImg.getImage();
        resize = SideImg4resize.getScaledInstance(550, 700, Image.SCALE_SMOOTH);
        logInImg = new ImageIcon(resize);
        JsideImg = new JLabel(logInImg);
        JsideImg.setBounds(0, 0, 550, 700);
        panel.add(JsideImg);

        logIn = new JLabel("LOG IN");
        logIn.setBounds(730, 30, 150, 50);
        logIn.setFont(big);
        logIn.setForeground(Color.white);
        panel.add(logIn);

        welcome = new JLabel("Hello...! Let's Start a jounry with Us..!");
        welcome.setBounds(650, 80, 350, 50);
        welcome.setFont(medium1);
        welcome.setForeground(Color.white);
        panel.add(welcome);

        userNm = new JLabel("USER NAME");
        userNm.setBounds(600, 150, 200, 50);
        userNm.setFont(medium);
        userNm.setForeground(Color.white);
        panel.add(userNm);

        namef = new JTextField();
        namef.setBounds(600, 200, 350, 50);
        namef.setFont(small);
        namef.setForeground(Color.WHITE);
        namef.setCaretColor(Color.WHITE);
        namef.setBorder(null);
        namef.setOpaque(false);
        panel.add(namef);

        underLine = new JLabel("____________________________");
        underLine.setBounds(600, 200, 350, 50);
        underLine.setFont(medium);
        underLine.setForeground(Color.white);
        panel.add(underLine);

        Pass = new JLabel("PASSWORD");
        Pass.setBounds(600, 250, 350, 50);
        Pass.setFont(medium);
        Pass.setForeground(Color.white);
        panel.add(Pass);

        passf = new JPasswordField();
        passf.setBounds(600, 300, 350, 50);
        passf.setFont(small);
        passf.setForeground(Color.WHITE);
        passf.setCaretColor(Color.WHITE);
        passf.setBorder(null);
        passf.setOpaque(false);
        panel.add(passf);

        underLine = new JLabel("____________________________");
        underLine.setBounds(600, 300, 350, 50);
        underLine.setFont(medium);
        underLine.setForeground(Color.white);
        panel.add(underLine);

        // buttonGrp1 = new ButtonGroup();
        // Admin = new JRadioButton("Admin");
        // Admin.setBounds(730, 130, 100, 20);
        // Admin.setFont(small);
        // Admin.setForeground(Color.WHITE);
        // Admin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        // Admin.setBorderPainted(false);
        // Admin.setContentAreaFilled(false);
        // Admin.setFocusPainted(false);
        // Admin.addActionListener(this);

        // user = new JRadioButton("User");
        // user.setBounds(860, 130, 100, 20);
        // user.setFont(small);
        // user.setForeground(Color.WHITE);
        // user.setCursor(new Cursor(Cursor.HAND_CURSOR));
        // user.setBorderPainted(false);
        // user.setContentAreaFilled(false);
        // user.setFocusPainted(false);

        RememberMe = new JCheckBox("Remember me");
        RememberMe.setBounds(600, 350, 200, 50);
        RememberMe.setFont(small);
        RememberMe.setForeground(Color.WHITE);
        RememberMe.setFocusPainted(false);
        RememberMe.setContentAreaFilled(false);
        RememberMe.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        RememberMe.setCursor(hand);
        panel.add(RememberMe);

        forgot = new JButton("Forgot Password ?");
        forgot.setBounds(900, 350, 200, 50);
        forgot.setFont(small);
        forgot.setForeground(Color.WHITE);
        forgot.setFocusPainted(false);
        forgot.setContentAreaFilled(false);
        forgot.setCursor(hand);
        forgot.setBorder(BorderFactory.createEmptyBorder());
        panel.add(forgot);

        LogIN = new JButton("LOGIN");
        LogIN.setBounds(600, 400, 400, 50);
        LogIN.setFont(medium);
        LogIN.setForeground(Color.decode("#1877F2"));
        LogIN.setOpaque(true);
        LogIN.setBackground(Color.WHITE);
        LogIN.setFocusPainted(false);
        // LogIN.setContentAreaFilled(false);
        LogIN.setCursor(hand);
        LogIN.setBorder(BorderFactory.createEmptyBorder());
        panel.add(LogIN);
         LogIN.addActionListener(this);

        notAccount = new JLabel("Don't have account?");
        notAccount.setBounds(650, 480, 200, 50);
        notAccount.setFont(medium1);
        notAccount.setForeground(Color.WHITE);
        // notAccount.setOpaque(true);
        panel.add(notAccount);

        SignUP = new JButton("Sign Up");
        SignUP.setBounds(850, 480, 100, 50);
        SignUP.setFont(medium1);
        SignUP.setForeground(Color.WHITE);
        SignUP.setBorder(BorderFactory.createEmptyBorder());
        SignUP.setFocusPainted(false);
        SignUP.setContentAreaFilled(false);
        SignUP.addActionListener(this);

        SignUP.setCursor(hand);

        panel.add(SignUP);

        fillArea = new JLabel("Fill the Area");
        fillArea.setBounds(600, 220, 350, 50);
        fillArea.setFont(small);
        fillArea.setForeground(Color.RED);
        panel.add(fillArea);

        fillArea.setVisible(false);

        passArea = new JLabel("Fill the Password");
        passArea.setBounds(600, 310, 350, 50);
        passArea.setFont(small);
        passArea.setForeground(Color.RED);
        panel.add(passArea);

        passArea.setVisible(false);

        // buttonGrp1.add(Admin);
        // buttonGrp1.add(user);
        // panel.add(Admin);
        // panel.add(user);

        this.add(panel);
    }

    public void actionPerformed(ActionEvent e ){

    if (e.getSource() == LogIN) {
        String n = namef.getText();
        char[] p = passf.getPassword(); 
        UserRepo u = new UserRepo();
        User us = u.searchUser(n);

        String admin ="SHOHAG";
        

        if (n.equals(admin) && admin.equals(new String(p))){
   
            JOptionPane.showMessageDialog(this, "Log in Successful as an ADMIN");
            this.setVisible(false);
    
                 Admin Shohag = new Admin();
                 Shohag.setVisible(true);
    
              
        }

        
    
         else if (us != null) {
            if (us.getUserName().equals(n) && us.getPassword().equals(new String(p))) {
               
                int userID = Integer.parseInt(us.getID());
                if (userID >= 100 && userID <= 10000) {
                    JOptionPane.showMessageDialog(this, "Log in Successful as an Examinee");

                    this.setVisible(false);
                    UserHome sh = new UserHome(us.getFirstName());
                    sh.setVisible(true);

                  
                }
            }
            
            else if (us.getUserName().equals(n) &&!( us.getPassword().equals(new String(p)))) {
                JOptionPane.showMessageDialog(this, "Incorrect  password. Please try again.");
            }

        }
        

        
        


      

       else if (us==null) {

        JOptionPane.showMessageDialog(this, "Incorrect username or password. Please try again.");


        
    }

        } 



   

    if(e.getSource()==SignUP)
    {
        this.setVisible(false);
        SignUp sh =new SignUp();

        sh.setVisible(true);






    }
    

    }
}
