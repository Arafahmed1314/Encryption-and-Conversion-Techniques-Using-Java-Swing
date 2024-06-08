package data_communiation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HammingCode extends JFrame implements ActionListener {

    private JTextField inputField;
    private JLabel outputLabel;
    private JButton evenParityButton;
    private JButton oddParityButton;

    public HammingCode() {
        setTitle("Parity Checker");
        getContentPane().setBackground(new Color(52, 152, 219));
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel headerLabel = new JLabel("Parity Checker");
        headerLabel.setFont(new Font("Serif", Font.BOLD, 40));
        headerLabel.setForeground(new Color(0, 0, 0));
        headerLabel.setBounds(350, 30, 700, 100);
        add(headerLabel);

        JLabel inputLabel = new JLabel("Input:");
        inputLabel.setFont(new Font("Serif", Font.BOLD, 24));
        inputLabel.setForeground(new Color(0, 0, 0));
        inputLabel.setBounds(200, 180, 150, 50);
        add(inputLabel);

        inputField = new JTextField();
        inputField.setForeground(Color.DARK_GRAY);
        inputField.setBounds(300, 180, 450, 50);
        inputField.setFont(new Font("Serif", Font.BOLD, 20));
        add(inputField);

        evenParityButton = new JButton("Even Parity");
        evenParityButton.setForeground(new Color(255, 255, 255));
        evenParityButton.setBackground(new Color(1, 55, 125));
        evenParityButton.addActionListener(this);
        evenParityButton.setBounds(300, 250, 150, 50);
        add(evenParityButton);

        oddParityButton = new JButton("Odd Parity");
        oddParityButton.addActionListener(this);
        oddParityButton.setBackground(new Color(1, 55, 125));
        oddParityButton.setForeground(new Color(255, 255, 255));
        oddParityButton.setBounds(600, 250, 150, 50);
        add(oddParityButton);

        ImageIcon b_backgroundImage = new ImageIcon("IMAGES/Back.png");
        JButton Back = new JButton("< Back", b_backgroundImage);
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

        outputLabel = new JLabel();
        outputLabel.setBounds(225, 350, 780, 50);
        outputLabel.setBackground(new Color(255, 255, 255));
        outputLabel.setForeground(Color.black); // Change foreground color to black
        outputLabel.setFont(new Font("Serif", Font.BOLD, 25));
        add(outputLabel);

        JLabel backgroundImageLabel = new JLabel(new ImageIcon("IMAGES/image.jpg"));
        backgroundImageLabel.setBounds(0, 0, 1000, 600);
        add(backgroundImageLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = inputField.getText();

        if (input.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter some bits to process.", "Empty Input",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            int wish = e.getSource() == evenParityButton ? 0 : 1;
            solve(input, wish);
        }
    }

    private void solve(String input, int wish) {
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '1') {
                count++;
            }
        }

        if ((wish == 0 && count % 2 == 0) || (wish == 1 && count % 2 == 1)) {
            input += "0";
        } else {
            input += "1";
        }

        outputLabel.setText("The Output Code is: " + input);
    }

    public static void main(String[] args) {
        new HammingCode();
    }
}
