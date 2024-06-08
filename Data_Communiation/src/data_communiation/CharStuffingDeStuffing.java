package data_communiation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharStuffingDeStuffing extends JFrame implements ActionListener {
    private JTextField inputField;
    private JTextField flagField;
    private JTextField escField;
    private JLabel outputLabel;
    private JButton processButton;
    private JComboBox<String> processOptions;

    public CharStuffingDeStuffing() {

        setTitle("Character Stuffing and De-Stuffing");
        getContentPane().setBackground(new Color(0, 168, 255)); // Updated color
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setLocation(200, 60);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel headerLabel = new JLabel("Character Stuffing and De-Stuffing");
        headerLabel.setFont(new Font("Serif", Font.BOLD, 40));
        headerLabel.setForeground(new Color(0, 0, 0));
        headerLabel.setBounds(200, 30, 700, 100);
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

        JLabel flagLabel = new JLabel("Flag Sequence:");
        flagLabel.setFont(new Font("Serif", Font.BOLD, 24));
        flagLabel.setForeground(new Color(0, 0, 0));
        flagLabel.setBounds(200, 250, 200, 50);
        add(flagLabel);

        flagField = new JTextField();
        flagField.setForeground(Color.DARK_GRAY);
        flagField.setBounds(400, 250, 200, 50);
        flagField.setFont(new Font("Serif", Font.BOLD, 20));
        add(flagField);
        JLabel escLabel = new JLabel("ESC Sequence:");
        escLabel.setFont(new Font("Serif", Font.BOLD, 24));
        escLabel.setForeground(new Color(0, 0, 0));
        escLabel.setBounds(600, 250, 200, 50);
        add(escLabel);

        escField = new JTextField();
        escField.setForeground(Color.DARK_GRAY);
        escField.setBounds(800, 250, 200, 50);
        escField.setFont(new Font("Serif", Font.BOLD, 20));
        add(escField);

        processOptions = new JComboBox<>(new String[] { "Character Stuffing", "Character De-Stuffing" });
        processOptions.setBounds(300, 320, 200, 50);
        processOptions.setFont(new Font("Serif", Font.BOLD, 20));
        add(processOptions);

        processButton = new JButton("Process");
        processButton.setForeground(new Color(255, 255, 255));
        processButton.setBackground(new Color(1, 55, 125));
        processButton.addActionListener(this);
        processButton.setBounds(550, 320, 150, 50);
        processButton.setFont(new Font("Serif", Font.BOLD, 20));
        add(processButton);
        ImageIcon b_backgroundImage = new ImageIcon("IMAGES/Back.png");

        JButton Back = new JButton("< Back", b_backgroundImage);
        Back.setFont(new Font("Arial", Font.BOLD, 20));
        Back.setBounds(0, 0, 85, 25);
        Back.setBackground(new Color(159, 126, 219));
        Back.setForeground(Color.white);
        Back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform action on button click
                new StuffingDeStuffing();
                setVisible(false);
            }
        });
        add(Back);
        ImageIcon color_background = new ImageIcon("IMAGES/color.png");
        // Color button
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
        outputLabel.setBounds(225, 400, 780, 50);
        outputLabel.setBackground(new Color(255, 255, 255));
        outputLabel.setForeground(Color.yellow);
        outputLabel.setFont(new Font("Serif", Font.BOLD, 25));
        add(outputLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = inputField.getText();
        String flag = flagField.getText();
        String esc = escField.getText();
        String selectedOption = (String) processOptions.getSelectedItem();

        if (e.getSource() == processButton) {
            if (input.isEmpty() || flag.isEmpty() || esc.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter input, flag sequence, and ESC sequence.",
                        "Empty Input", JOptionPane.WARNING_MESSAGE);
            } else {
                if ("Character Stuffing".equals(selectedOption)) {
                    charStuffed(input, flag, esc);
                } else if ("Character De-Stuffing".equals(selectedOption)) {
                    charDeStuffed(input, flag, esc);
                }
            }
        }
    }

    private void charStuffed(String input, String flag, String esc) {
        StringBuilder stuffed = new StringBuilder();

        stuffed.append(flag);

        for (int i = 0; i < input.length(); i++) {
            if (input.startsWith(flag, i) || input.startsWith(esc, i)) {
                stuffed.append(esc);
            }
            stuffed.append(input.charAt(i));
        }

        stuffed.append(flag);
        outputLabel.setText("Stuffed: " + stuffed.toString());
    }

    private void charDeStuffed(String input, String flag, String esc) {
        if (input.length() < 2 || !input.startsWith(flag) || !input.endsWith(flag)) {
            outputLabel.setText("Invalid input for de-stuffing.");
            return;
        }

        String trimmedInput = input.substring(flag.length(), input.length() - flag.length());
        StringBuilder deStuffed = new StringBuilder();

        for (int i = 0; i < trimmedInput.length(); i++) {
            if (trimmedInput.startsWith(esc, i)) {
                i += esc.length();
                deStuffed.append(trimmedInput.charAt(i));
            } else {
                deStuffed.append(trimmedInput.charAt(i));
            }
        }

        outputLabel.setText("De-Stuffed: " + deStuffed.toString());
    }

    public static void main(String[] args) {
        new CharStuffingDeStuffing();
    }
}
