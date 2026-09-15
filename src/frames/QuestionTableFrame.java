package frames;

import entities.Question;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class QuestionTableFrame extends JFrame implements ActionListener {

    private JTable table;
    private JScrollPane scrollPane;
    private JPanel panel;
    private DefaultTableModel tableModel;
    private JButton exit;
    Cursor Hand = new Cursor(Cursor.HAND_CURSOR);

    public QuestionTableFrame(List<Question> questionList) {
        super("Question List");

        initComponents(questionList);

        this.setBounds(100, 60, 1100, 600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    private void initComponents(List<Question> questionList) {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        
        String[] columns = {"ID", "Question", "Correct Answer", "Options"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);

       
        table.setFont(new Font("Arial", Font.PLAIN, 16)); 
        table.setRowHeight(30); 

        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
        table.getTableHeader().setBackground(Color.decode("#004D40")); 
        table.getTableHeader().setForeground(Color.WHITE); 

        // Background color for rows
        table.setBackground(Color.decode("#E0F7FA")); // Light cyan background
        table.setForeground(Color.BLACK); // Black text color

        // Center-align the cell contents
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Populate table with data from questionList
        for (Question q : questionList) {
            String options = String.join(", ", q.getOptions()); 
            Object[] row = {q.getId(), q.getQuestionText(), q.getCorrectAnswer(), options};
            tableModel.addRow(row);
        }

        // Scroll pane for the table
        scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        
        panel.add(scrollPane, BorderLayout.CENTER);

        
        exit = new JButton("Exit");
        exit.setFont(new Font("Arial", Font.PLAIN, 16));
        exit.setBackground(Color.RED);
        exit.setForeground(Color.WHITE);
        exit.setCursor(Hand);
        exit.addActionListener(this);

        
        panel.add(exit, BorderLayout.SOUTH);

       
        this.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            this.setVisible(false);
            Admin Shohag = new Admin();
            Shohag.setVisible(true);
        }
    }
}
