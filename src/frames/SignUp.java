package frames;
import entities.User;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import repositories.UserRepo;



public class SignUp extends JFrame implements ActionListener{

   

    private JPanel panel;
    private JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7,lbl8,lbl9,lbl10,lbl11,lbl12,JSignUpImg,underLine,underLine1,underLine2,underLine3,underLine4,underLine5,underLine6,underLine7;
    private JTextField tf1,tf2,tf3,tf5,tf4,tf8;
    private JPasswordField pf1,pf2;
    private JRadioButton rb1,rb2,rb3;
    private JComboBox combx1;
    private ButtonGroup btng1;
    private Font big,medium,medium1,small;
    private ImageIcon SignUpImg,ICON;
    private Image resize,resize1;
    private Cursor hand;
    private JButton btn1,btn2 ;
    private String SignUpform[];
    boolean allcheck,check ;
    Random rn =new Random() ;
    private int x =rn.nextInt(10);
    private int y =rn.nextInt(10);
    private int z=x+y;

    User spUser = new User();
    Random r =new Random();
    int a = r.nextInt(10000 - 100 + 1) + 100; 

    String sh = String.valueOf(a);

     






   public SignUp(){ 
    super("SIGN UP");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setBounds(100, 60, 1100, 700);
    setVisible(true);
    this.panel =new JPanel();
    panel.setBackground(Color.decode("#1877F2"));
    this.panel.setLayout(null);

    ICON = new ImageIcon(("Image/signupicon.png"));

    this.setIconImage(ICON.getImage());



    big =new Font("Segoe UI", Font.BOLD+Font.PLAIN, 40);

    medium =new Font("Segoe UI",Font.BOLD+Font.PLAIN,25);
    medium1  =new Font("Segoe UI",Font.BOLD+Font.PLAIN,20);
    small =new Font("Segoe UI",Font.BOLD+Font.PLAIN,14);
    hand =new Cursor(Cursor.HAND_CURSOR);



    SignUpImg =new ImageIcon(("Image/Signup.png"));
    resize =SignUpImg.getImage();
    resize1=resize.getScaledInstance(550, 700,Image.SCALE_SMOOTH);
    SignUpImg =new ImageIcon(resize1);
    JSignUpImg = new JLabel(SignUpImg);
    JSignUpImg.setBounds(0,0,550,700);
    panel.add(JSignUpImg);


    lbl1 =new JLabel("Create Account");
    lbl1.setBounds(700,10,350,50);
    lbl1.setFont(big);
    lbl1.setForeground(Color.WHITE);
    this.panel.add(lbl1);



    lbl2 =new JLabel("First Name");
    lbl2.setBounds(600,90,200,50);
    lbl2.setFont(medium1);
    lbl2.setForeground(Color.WHITE);
    this.panel.add(lbl2);

    underLine =new JLabel("________________");
    underLine.setBounds(600,140,350,50);
    underLine.setFont(medium);
    underLine.setForeground(Color.white);
    panel.add(underLine);

        tf1 =new JTextField();
        tf1.setBounds(600,140,200,50);
        tf1.setFont(small);
        tf1.setForeground(Color.WHITE);
        tf1.setCaretColor(Color.WHITE);
        tf1.setBorder(null);
        tf1.setOpaque(false);
        panel.add(tf1);



        lbl3 =new JLabel("Surname");
        lbl3.setBounds(850,90,200,50);
        lbl3.setFont(medium1);
        lbl3.setForeground(Color.WHITE);
        this.panel.add(lbl3);


        // tf2 =new JTextField("TT");
        // tf2.setBounds(850,90,200,50);
        // tf2.setFont(medium1);
        // tf2.setForeground(Color.WHITE);
        // tf2.setCaretColor(Color.WHITE);
        // tf2.setBorder(null);
        // tf2.setOpaque(false);
        // panel.add(tf2);

        underLine1 =new JLabel("________________");
        underLine1.setBounds(850,140,200,50);
        underLine1.setFont(medium);
        underLine1.setForeground(Color.white);
        panel.add(underLine1);


        tf2 =new JTextField();
        tf2.setBounds(850,140,200,50);
        tf2.setFont(small);
        tf2.setForeground(Color.WHITE);
        tf2.setCaretColor(Color.WHITE);
        tf2.setBorder(null);
        tf2.setOpaque(false);
        panel.add(tf2);


        lbl4 =new JLabel("Date of Birth");
        lbl4.setBounds(600,190,200,50);
        lbl4.setFont(medium1);
        lbl4.setForeground(Color.WHITE);
        this.panel.add(lbl4);


        tf3 =new JTextField();
        tf3.setBounds(600,220,200,50);
        tf3.setFont(medium1);
        tf3.setForeground(Color.WHITE);
        tf3.setCaretColor(Color.WHITE);
        tf3.setBorder(null);
        tf3.setOpaque(false);
        this.panel.add(tf3);

        underLine2 =new JLabel("________________");
        underLine2.setBounds(600,220,200,50);
        underLine2.setFont(medium1);
        underLine2.setForeground(Color.white);
        this.panel.add(underLine2);


        lbl5 =new JLabel("Religion");
        lbl5.setBounds(850,190,200,50);
        lbl5.setFont(medium1);
        lbl5.setForeground(Color.WHITE);
        this.panel.add(lbl5);

        String Religion[]={"ISLAM","HINDU","Buddhism","Christianity"};
        combx1=new JComboBox<>(Religion);
        combx1.setBounds(930,205,150,25);
        combx1.setFont(small);
        combx1.setForeground(Color.WHITE);
        combx1.setBackground(Color.decode("#1877F2"));
        panel.add(combx1);



        lbl6 = new JLabel("Gender");
        lbl6.setBounds(600,260,100,50);
        lbl6.setForeground(Color.white);
        lbl6.setFont(medium1);
        panel.add(lbl6);

        btng1 = new ButtonGroup();

        rb1= new JRadioButton("Male");
        rb1.setBounds(720, 260, 100, 50);
        rb1.setForeground(Color.white);
        rb1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        rb1.setFocusPainted(false);
        rb1.setBorderPainted(false);
        rb1.setContentAreaFilled(false);
        btng1.add(rb1);
        panel.add(rb1);

        rb2 = new JRadioButton("Female");
        rb2.setForeground(Color.white);
        rb2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        rb2.setBounds(820, 260, 100, 50);
        rb2.setFocusPainted(false);
        rb2.setBorderPainted(false);
        rb2.setContentAreaFilled(false);
        btng1.add(rb2);
        panel.add(rb2);

        rb3 = new JRadioButton("Other");
        rb3.setForeground(Color.white);
        rb3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        rb3.setBounds(920, 260, 100, 50);
        rb3.setFocusPainted(false);
        rb3.setBorderPainted(false);
        rb3.setContentAreaFilled(false);
        btng1.add(rb3);
        panel.add(rb3);


        lbl7 = new JLabel("Email");
        lbl7.setBounds(600, 310, 300, 40);
        lbl7.setForeground(Color.white);
        lbl7.setFont(medium1);
        panel.add(lbl7);


        tf4 = new JTextField();
        tf4.setBounds(600, 350, 380, 30);
        tf4.setForeground(Color.white);
        tf4.setFont(medium1);
        tf4.setCaretColor(Color.white);
        tf4.setBorder(null);
        tf4.setOpaque(false);
        panel.add(tf4);


        underLine3 = new JLabel("_________________________________________________");
        underLine3.setBounds(600, 360, 380, 30);
        underLine3.setForeground(Color.white);
        panel.add(underLine3);

        lbl8 = new JLabel("User Name");
        lbl8.setBounds(600, 390, 300, 40);
        lbl8.setForeground(Color.white);
        lbl8.setFont(medium1);
        panel.add(lbl8);


        tf5 = new JTextField("");
        tf5.setBounds(600, 430, 380, 30);
        tf5.setForeground(Color.white);
        tf5.setFont(medium1);
        tf5.setCaretColor(Color.white);
        tf5.setBorder(null);
        tf5.setOpaque(false);
        panel.add(tf5);


        underLine4 = new JLabel("_________________________________________________");
        underLine4.setBounds(600, 440, 380, 30);
        underLine4.setForeground(Color.white);
        panel.add(underLine4);



        lbl9 = new JLabel("Password");
        lbl9.setBounds(600, 470, 300, 40);
        lbl9.setForeground(Color.white);
        lbl9.setFont(medium1);
        panel.add(lbl9);


        pf1 = new JPasswordField();
        pf1.setBounds(600, 510, 300, 30);
        pf1.setForeground(Color.white);
        pf1.setFont(medium1);
        pf1.setCaretColor(Color.white);
        pf1.setBorder(null);
        pf1.setOpaque(false);
        panel.add(pf1);


        underLine5 = new JLabel("____________________________");
        underLine5.setBounds(600, 520, 380, 30);
        underLine5.setForeground(Color.white);
        panel.add(underLine5);


        lbl10 = new JLabel("Re type Password");
        lbl10.setBounds(900, 470, 300, 40);
        lbl10.setForeground(Color.white);
        lbl10.setFont(medium1);
        panel.add(lbl10);


        pf2 = new JPasswordField("");
        pf2.setBounds(900, 510, 380, 30);
        pf2.setForeground(Color.white);
        pf2.setFont(medium1);
        pf2.setCaretColor(Color.white);
        pf2.setBorder(null);
        pf2.setOpaque(false);
        panel.add(pf2);


        underLine6 = new JLabel("____________________________");
        underLine6.setBounds(900, 520, 380, 30);
        underLine6.setForeground(Color.white);
        panel.add(underLine6);


        

        lbl11 = new JLabel("Capcha");
        lbl11.setBounds(600, 550, 100, 30);
        lbl11.setForeground(Color.white);
        lbl11.setFont(small);
        panel.add(lbl11);

        lbl12 =new JLabel();
        lbl12.setText(" "+x+" + "+y +" = " );
        lbl12.setBounds(650,550,100,30);
        lbl12.setForeground(Color.WHITE);
        lbl12.setFont(small);
        lbl12.setBackground(Color.decode("#1877F2"));
        panel.add(lbl12);


        tf8 = new JTextField();
        tf8.setBounds(700, 550, 50, 30);
        tf8.setForeground(Color.WHITE);
        tf8.setFont(small);
        tf8.setCaretColor(Color.GREEN);
        tf8.setBorder(null);
        tf8.setOpaque(false);
        panel.add(tf8);


        underLine7 = new JLabel("__________");
        underLine7.setBounds(700, 550, 70, 30);
        underLine7.setFont(small);
        underLine7.setForeground(Color.white);
        panel.add(underLine7);

        btn1 = new JButton("Submit");
        btn1.setBounds(730,590,200,40);
        btn1.setBackground(Color.GREEN);
        btn1.setForeground(Color.WHITE);
        btn1.setFont(medium);
        btn1.addActionListener(this);
        btn1.setCursor(hand);
        panel.add(btn1);
        

        lbl12 = new JLabel("Already have an account?");
        lbl12.setBounds(720, 630, 200, 20);
        lbl12.setForeground(Color.white);
        lbl12.setFont(small);
        panel.add(lbl12);

        btn2 =new JButton("Log in");
        btn2.setBounds(870, 615, 100, 50);
        btn2.setFont(small);
        btn2.setForeground(Color.WHITE);
        btn2.setBorder(BorderFactory.createEmptyBorder());
        btn2.setFocusPainted(false);
        btn2.setContentAreaFilled(false);
        btn2.addActionListener(this);
        btn2.setCursor(hand);
        panel.add(btn2);



        





        








        






  this.add(this.panel);
   }


   public  void actionPerformed(ActionEvent e) {
    if(e.getSource()==btn1)
    {
        SignUpform  = new String[9];
       SignUpform [0]=tf1.getText();
       SignUpform [1]=tf2.getText();
       SignUpform [2]=tf3.getText();
       SignUpform [3]=tf4.getText();
       SignUpform [4]=tf5.getText();
       SignUpform [5]=pf1.getText();
       SignUpform [6]=pf2.getText();
       SignUpform [7]=tf8.getText();
       if(rb1.isSelected() || rb2.isSelected())
       {

        allcheck=true;
       }
      

       
       


       for(int i =0 ; i<8  ;i++)
       {
        
       if( !SignUpform[i].isEmpty())
       {

        allcheck =true ;



       }

       else if (SignUpform[i].isEmpty()) {
        allcheck =false;
        JOptionPane.showMessageDialog(null, "Fill the all data properly");
        break;


       }

       




       }

     




       if( allcheck == true && pf1.getText().equals(pf2.getText())  )
       {
        check = true;
       }
        


    
       else if(allcheck==true)
       {

        check = false ;
        JOptionPane.showMessageDialog(null, "Passwords do not match. Please try again");
       }

       if (!tf8.getText().equals(String.valueOf(z)) && allcheck ==true){

        check = false;
        
        JOptionPane.showMessageDialog(null, "Capcha is wrong");


        

       }

       if (check==true && allcheck ==true )
       {

       



        spUser.setID(sh);

        spUser.setFirstName(tf1.getText());
        spUser.setSecondName(tf2.getText());
        spUser.setDateOfBirth(tf3.getText());
        spUser.setEmail(tf4.getText());
        spUser.setUserName(tf5.getText());
        spUser.setPassword(pf1.getText());
        if(Integer.parseInt(spUser.getID())>100)
        {
            spUser.setRole("3");


        }
        else
        {

            spUser.setRole("1");


        }

        UserRepo urp = new UserRepo();

        urp.addUser(spUser);

        this.setVisible(false);


        JOptionPane.showMessageDialog(this, "Sign Up Successfull.");

        Home h=new Home();
        h.setVisible(true);




       }

       













    }


    if(e.getSource()==btn2)
       {

        this.setVisible(false);

        Home h=new Home();
        h.setVisible(true);



       }



   
}





}