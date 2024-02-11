package transportapp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class login extends JFrame implements ActionListener {

    JLabel l1, l2, l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1, b2, b3;

    login() {
        l1 = new JLabel("City Link");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        l1.setBounds(100, 40, 450, 50);
        add(l1);

        b1 = new JButton("USER LOGIN");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        setLayout(null);

        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(100, 300, 200, 30);
        add(b1);

        b2 = new JButton("Driver LOGIN");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(100, 400, 200, 30);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setSize(450, 700);
        setLocation(550, 40);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            setVisible(false);
            new userlogin().setVisible(true);
        } else if (e.getSource() == b2) {
            setVisible(false);
            new driverlogin().setVisible(true);
        }
    }

    public static void main(String args[]) {
        new login();
    }
}
