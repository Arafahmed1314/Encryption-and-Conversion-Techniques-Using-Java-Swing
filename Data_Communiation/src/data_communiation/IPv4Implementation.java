package data_communiation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IPv4Implementation extends JFrame {
    public IPv4Implementation() {
        setTitle("IPv4 Implementation");
        getContentPane().setBackground(new Color(0, 168, 255)); // Updated color
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setLocation(200, 60);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel headerLabel = new JLabel("IPv4 Implementation");
        headerLabel.setFont(new Font("Serif", Font.BOLD, 40));
        headerLabel.setForeground(new Color(0, 0, 0));
        headerLabel.setBounds(300, 30, 700, 100);
        add(headerLabel);
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

        JButton ipv4ConversionButton = new JButton("IPv4 Conversion");
        ipv4ConversionButton.setFont(new Font("Arial", Font.BOLD, 20));
        ipv4ConversionButton.setBounds(400, 200, 200, 50);
        ipv4ConversionButton.setBackground(new Color(1, 55, 125));
        ipv4ConversionButton.setForeground(Color.white);
        ipv4ConversionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new IPv4Converter();
                setVisible(false);
            }
        });
        add(ipv4ConversionButton);
        JButton ipv4DetailsButton = new JButton("IPv4 Details");
        ipv4DetailsButton.setFont(new Font("Arial", Font.BOLD, 20));
        ipv4DetailsButton.setBounds(400, 270, 200, 50);
        ipv4DetailsButton.setBackground(new Color(1, 55, 125));
        ipv4DetailsButton.setForeground(Color.white);
        ipv4DetailsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new IPv4Details();
                setVisible(false);
            }
        });
        add(ipv4DetailsButton);
    }

    public static void main(String[] args) {
        new IPv4Implementation();
    }
}
