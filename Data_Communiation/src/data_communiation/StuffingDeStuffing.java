package data_communiation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StuffingDeStuffing extends JFrame {

    public StuffingDeStuffing() {

        JFrame frame = new JFrame("DATA COMMUNICATION LAB");
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(0, 168, 255));

        frame.setSize(1000, 600);
        frame.setLocation(200, 60);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel headerLabel = new JLabel("Stuffing and De-Stuffing");
        headerLabel.setFont(new Font("Serif", Font.BOLD, 40));
        headerLabel.setForeground(new Color(0, 0, 0));
        headerLabel.setBounds(300, 50, 700, 100);
        frame.add(headerLabel);
        ImageIcon color_background = new ImageIcon("IMAGES/color.png");

        JButton c = new JButton("<BG color>", color_background);
        c.setBounds(900, 0, 100, 25);
        c.setBackground(new Color(159, 126, 219));
        c.setForeground(Color.white);
        c.setFont(new Font("Arial", Font.BOLD, 12));

        c.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color cc = JColorChooser.showDialog(null, "choose a color", Color.green);
                frame.getContentPane().setBackground(cc);

            }
        });
        frame.add(c);

        JButton bitButton = new JButton("Bit Stuffing and De-stuffing");
        bitButton.setFont(new Font("Arial", Font.BOLD, 18));
        bitButton.setBounds(350, 200, 350, 40);
        bitButton.setBackground(new Color(1, 55, 125));
        bitButton.setForeground(Color.WHITE);
        bitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                new BitStuffingDeStuffing();
                frame.setVisible(false);
            }
        });
        frame.add(bitButton);

        JButton charButton = new JButton("Character Stuffing and De-stuffing");
        charButton.setFont(new Font("Arial", Font.BOLD, 18));
        charButton.setBounds(350, 250, 350, 40);
        charButton.setBackground(new Color(1, 55, 125));
        charButton.setForeground(Color.WHITE);
        charButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                new CharStuffingDeStuffing();
                frame.setVisible(false);
            }
        });
        frame.add(charButton);

        ImageIcon b_backgroundImage = new ImageIcon("IMAGES/Back.png");

        JButton Back = new JButton("< Back", b_backgroundImage);
        Back.setFont(new Font("Arial", Font.BOLD, 20));
        Back.setBounds(0, 0, 85, 25);
        Back.setBackground(new Color(159, 126, 219));
        Back.setForeground(Color.white);
        Back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                new welcomePage();
                frame.setVisible(false);
            }
        });
        frame.add(Back);
    }

    public static void main(String[] args) {
        new StuffingDeStuffing();
    }
}
