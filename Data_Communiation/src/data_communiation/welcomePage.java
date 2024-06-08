package data_communiation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class welcomePage extends JFrame implements ActionListener {

    welcomePage() {

        JFrame frame = new JFrame("DATA COMMUNICATION LAB");
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(136, 196, 245));

        frame.setSize(1000, 600);
        frame.setLocation(200, 60);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel headerLabel = new JLabel("ToolKit For Encryption and Conversion");
        headerLabel.setFont(new Font("Serif", Font.BOLD, 40));
        headerLabel.setForeground(new Color(255, 255, 255));
        headerLabel.setBounds(200, 50, 700, 100);
        frame.add(headerLabel);

        ImageIcon backgroundImage = new ImageIcon("Data_Communiation/IMAGES/welcome.png");
        JLabel background = new JLabel(backgroundImage);
        frame.add(background);
        background.setBounds(0, 0, 1000, 600);

        JButton btnClass1 = new JButton("Stuffing and De-stuffing");
        btnClass1.setFont(new Font("Arial", Font.BOLD, 18));
        btnClass1.setBounds(350, 200, 350, 40);
        btnClass1.setBackground(new Color(1, 55, 125));
        btnClass1.setForeground(Color.WHITE);
        btnClass1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new StuffingDeStuffing();
                frame.setVisible(false);
            }
        });
        frame.add(btnClass1);

        JButton btnClass2 = new JButton("IPv4 implementation");
        btnClass2.setFont(new Font("Arial", Font.BOLD, 18));
        btnClass2.setBounds(350, 250, 350, 40);
        btnClass2.setBackground(new Color(1, 55, 125));
        btnClass2.setForeground(Color.WHITE);
        btnClass2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new IPv4Implementation();
                frame.setVisible(false);
            }
        });
        frame.add(btnClass2);

        JButton btnClass3 = new JButton("Parity Checker");
        btnClass3.setFont(new Font("Arial", Font.BOLD, 18));
        btnClass3.setBounds(350, 300, 350, 40);
        btnClass3.setBackground(new Color(1, 55, 125));
        btnClass3.setForeground(Color.WHITE);
        btnClass3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new HammingCode();
                frame.setVisible(false);
            }
        });
        frame.add(btnClass3);

        JButton btnClass4 = new JButton("Hamming Code Error Detection");
        btnClass4.setFont(new Font("Arial", Font.BOLD, 18));
        btnClass4.setBounds(350, 350, 350, 40);
        btnClass4.setBackground(new Color(1, 55, 125));
        btnClass4.setForeground(Color.WHITE);
        btnClass4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new HammingCodeErrorCorrection();
                frame.setVisible(false);
            }
        });
        frame.add(btnClass4);

        JButton developerInfoButton = new JButton("Developer Info");
        developerInfoButton.setBounds(880, 0, 120, 25);
        developerInfoButton.setBackground(new Color(1, 55, 125));
        developerInfoButton.setForeground(Color.WHITE);
        developerInfoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame dialogFrame = new JFrame("Developer Information");
                dialogFrame.setLayout(new BorderLayout());
                dialogFrame.setSize(600, 200);
                dialogFrame.setLocationRelativeTo(frame);

                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                panel.setBackground(new Color(136, 196, 245));

                JLabel infoLabel1 = new JLabel("1. Name: Md Naimul Islam");
                infoLabel1.setFont(new Font("Serif", Font.BOLD, 24));
                infoLabel1.setForeground(Color.BLACK);
                panel.add(infoLabel1);

                JLabel idLabel1 = new JLabel("ID : 221902056");
                idLabel1.setFont(new Font("Serif", Font.BOLD, 24));
                idLabel1.setForeground(Color.BLACK);
                panel.add(idLabel1);

                panel.add(Box.createRigidArea(new Dimension(0, 20)));

                JLabel infoLabel2 = new JLabel("2. Sajal Bhuiyan");
                infoLabel2.setFont(new Font("Serif", Font.BOLD, 24));
                infoLabel2.setForeground(Color.BLACK);
                panel.add(infoLabel2);

                JLabel idLabel2 = new JLabel("ID : 221902064");
                idLabel2.setFont(new Font("Serif", Font.BOLD, 24));
                idLabel2.setForeground(Color.BLACK);
                panel.add(idLabel2);

                dialogFrame.add(panel, BorderLayout.CENTER);
                dialogFrame.setVisible(true);
            }
        });
        frame.add(developerInfoButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new welcomePage();
    }
}
