package data_communiation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HammingCodeErrorCorrection extends JFrame implements ActionListener {

    private JTextField inputField;
    private JLabel errorLabel;
    private JLabel correctedCodeLabel;
    private JButton checkButton;
    private JButton correctButton;
    private JButton Back;

    public HammingCodeErrorCorrection() {

        setTitle("Hamming Code Error Detection and Correction");
        getContentPane().setBackground(new Color(0, 168, 255));
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setLocation(200, 60);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel headerLabel = new JLabel("Hamming Code Error Detection and Correction");
        headerLabel.setFont(new Font("Serif", Font.BOLD, 30));
        headerLabel.setForeground(new Color(0, 0, 0));
        headerLabel.setBounds(200, 30, 800, 50);
        add(headerLabel);

        JLabel inputLabel = new JLabel("Input Codeword:");
        inputLabel.setFont(new Font("Serif", Font.BOLD, 24));
        inputLabel.setForeground(new Color(0, 0, 0));
        inputLabel.setBounds(100, 120, 200, 50);
        add(inputLabel);

        inputField = new JTextField();
        inputField.setForeground(Color.DARK_GRAY);
        inputField.setBounds(310, 120, 400, 50);
        inputField.setFont(new Font("Serif", Font.BOLD, 20));
        add(inputField);

        checkButton = new JButton("Check");
        checkButton.setForeground(new Color(255, 255, 255));
        checkButton.setBackground(new Color(1, 55, 125));
        checkButton.addActionListener(this);
        checkButton.setBounds(400, 200, 200, 50);
        checkButton.setFont(new Font("Serif", Font.BOLD, 20));
        add(checkButton);

        correctButton = new JButton("Correct Error");
        correctButton.setForeground(new Color(255, 255, 255));
        correctButton.setBackground(new Color(1, 55, 125));
        correctButton.addActionListener(this);
        correctButton.setBounds(400, 340, 200, 50);
        correctButton.setFont(new Font("Serif", Font.BOLD, 20));
        correctButton.setVisible(false);
        add(correctButton);

        ImageIcon b_backgroundImage = new ImageIcon("IMAGES/Back.png");
        Back = new JButton("< Back", b_backgroundImage);
        Back.setFont(new Font("Arial", Font.BOLD, 20));
        Back.setBounds(0, 0, 85, 25);
        Back.setBackground(new Color(159, 126, 219));
        Back.setForeground(Color.white);
        Back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new welcomePage();
                setVisible(false);
            }
        });
        add(Back);

        ImageIcon color_background = new ImageIcon("IMAGES/color.png");

        JButton c = new JButton("<BG color>", color_background);
        c.setBounds(900, 0, 100, 25);
        c.setBackground(new Color(159, 126, 219));
        c.setForeground(Color.white);
        c.setFont(new Font("Arial", Font.BOLD, 12));

        c.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color cc = JColorChooser.showDialog(null, "choose a color", Color.green);
                getContentPane().setBackground(cc);
            }
        });
        add(c);
        errorLabel = new JLabel();
        errorLabel.setBounds(400, 270, 800, 50);
        errorLabel.setBackground(new Color(255, 255, 255));
        errorLabel.setForeground(Color.red);
        errorLabel.setFont(new Font("Serif", Font.BOLD, 25));
        add(errorLabel);
        correctedCodeLabel = new JLabel();
        correctedCodeLabel.setBounds(300, 400, 700, 50);
        correctedCodeLabel.setBackground(new Color(255, 255, 255));
        correctedCodeLabel.setForeground(Color.black);
        correctedCodeLabel.setFont(new Font("Serif", Font.BOLD, 25));
        add(correctedCodeLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkButton) {
            String input = inputField.getText();
            if (input.isEmpty()) {
                errorLabel.setText("Invalid input: Input field is empty");
                correctButton.setVisible(false);
                correctedCodeLabel.setText("");
                return;
            } else if (input.length() != 7) {
                errorLabel.setText("We develop for exactly 7 bits");
                correctButton.setVisible(false);
                correctedCodeLabel.setText("");
                return;
            }
            int errorPosition = checkErrorIndex(input);
            if (errorPosition > 0) {
                errorLabel.setText("Error position: " + errorPosition);
                correctButton.setVisible(true);
                correctedCodeLabel.setText("");
            } else {
                errorLabel.setText("Error: No");
                correctButton.setVisible(false);
                correctedCodeLabel.setText("");
            }
        } else if (e.getSource() == correctButton) {
            String input = inputField.getText();
            String correctedCodeword = correctError(input);
            correctedCodeLabel.setText("Corrected Codeword: " + correctedCodeword);
        }
    }

    private int checkErrorIndex(String input) {
        int[] rcwArray = new int[7];
        for (int i = 0; i < 7; i++) {
            rcwArray[i] = input.charAt(i) - '0';
        }

        int p1 = rcwArray[6] ^ rcwArray[4] ^ rcwArray[2] ^ rcwArray[0];
        int p2 = rcwArray[5] ^ rcwArray[4] ^ rcwArray[1] ^ rcwArray[0];
        int p4 = rcwArray[3] ^ rcwArray[2] ^ rcwArray[1] ^ rcwArray[0];
        int errorIndex = (p4 << 2) | (p2 << 1) | p1;

        return errorIndex;
    }

    private String correctError(String input) {
        int errorIndex = checkErrorIndex(input);
        StringBuilder correctedCodeword = new StringBuilder(input);

        if (errorIndex > 0) {
            int index = errorIndex - 1;
            correctedCodeword.setCharAt(index, correctedCodeword.charAt(index) == '0' ? '1' : '0');
        }

        return correctedCodeword.toString();
    }

    public static void main(String[] args) {
        new HammingCodeErrorCorrection();
    }
}
