
package transportapp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class driverlogin extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton,regbutton;

    public driverlogin() {
        setTitle("Login Page");
        setSize(450, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(550,40);
        setLayout(null);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Osward", Font.BOLD, 18));
        usernameLabel.setBounds(50,  300, 100, 25);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(160, 300, 200, 25);
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Osward", Font.BOLD, 18));
        passwordLabel.setBounds(50, 350, 100, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(160, 350, 200, 25);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(100, 420, 100, 30);
        loginButton.addActionListener(this);
        add(loginButton);
        regbutton = new JButton("Back");
        regbutton.setBounds(250, 420, 100, 30);
        regbutton.addActionListener(this);
        add(regbutton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try{if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
             Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/busapp", "postgres","root");
            Statement stmt = conn.createStatement();
             String sql  = "select * from driver where username = '"+username+"' and password1= '"+password+"'";

                ResultSet rs = stmt.executeQuery(sql);
                if(rs.next()){
                    setVisible(false);
                    
                   JOptionPane.showMessageDialog(null, "SUCCESS");
                   new driverview(username).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "invalid username or password. Please try again.");
                }
            }else if(e.getSource()==regbutton){
                setVisible(false);
                new login().setVisible(true);
            }
           
        }catch(Exception ae){
             ae.printStackTrace();
        }
        }
    

    public static void main(String[] args) {
        new driverlogin();
    }
}