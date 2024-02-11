
package transportapp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import java.util.*;

public class usersignup extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JRadioButton r1,r2,r3,r4,r5;
    JButton b;
  
    
   
    
    usersignup(){
        
        setTitle("Registeration");
        
        
        JLabel l11 = new JLabel();
        l11.setBounds(20, 0, 100, 100);
        add(l11);
        
        l1 = new JLabel("Registeration");
        l1.setFont(new Font("Raleway", Font.BOLD, 38));
        
        l2 = new JLabel(" Personal Details");
        l2.setFont(new Font("Raleway", Font.BOLD, 22));
        
        l3 = new JLabel("Name:");
        l3.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l4 = new JLabel("Gender:");
        l4.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l5 = new JLabel("City:");
        l5.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l6 = new JLabel("username");
        l6.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l7 = new JLabel("password");
        l7.setFont(new Font("Raleway", Font.BOLD, 20));
        
          
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t3 = new JTextField();
        t3.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t4 = new JTextField();
        t4.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t5 = new JTextField();
        t5.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t6 = new JTextField();
        t6.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t7 = new JTextField();
        t7.setFont(new Font("Raleway", Font.BOLD, 14));
        
       
        
        b = new JButton("Submit");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        
        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);
        
        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);
        
        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(r1);
        groupgender.add(r2);

       
        
        setLayout(null);
       
        l2.setBounds(290,80,600,30);
        add(l2);
        
        l3.setBounds(100,140,100,30);
        add(l3);
        
        t1.setBounds(300,140,400,30);
        add(t1);
        
        l4.setBounds(100,190,200,30);
        add(l4);
        
        r1.setBounds(300,190,60,30);
        add(r1);
        
        r2.setBounds(450,190,90,30);
        add(r2);
        
        
       
        
        l5.setBounds(100,240,200,30);
        add(l5);
        t3.setBounds(300,240,200,30);
        add(t3);
        
        
        l6.setBounds(100,290,200,30);
        add(l6);
        t4.setBounds(300,290,400,30);
        add(t4);
        
        
        l7.setBounds(100,340,200,30);
        add(l7);
        t5.setBounds(300,340,400,30);
        add(t5);
       

        
        b.setBounds(620,660,100,30);
        add(b);
        
        b.addActionListener(this); 
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(500,120);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
     
        String firstname = t1.getText();
     
        int age=10;
        String gender = null;
        if(r1.isSelected()){ 
            gender = "Male";
        }else if(r2.isSelected()){ 
            gender = "Female";
        }
            
        String city = t3.getText();
       
           
        String username= t4.getText();
        String password = t5.getText();
      
        

        try{
           
            if(t5.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            }else{
                  Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/busapp", "postgres","root");
            Statement stmt = conn.createStatement();
                String sq1 = "insert into user1 values('"+firstname+"','"+age+"','"+username+"','"+password+"','"+gender+"','"+city+"')";
                stmt.executeUpdate(sq1);
                JOptionPane.showMessageDialog(null, "SUCCESS");
                new userlogin().setVisible(true);
                setVisible(false);
            }
            
        }catch(Exception e){
             e.printStackTrace();
        }
        
    }
    
    
    public static void main(String[] args){
        new usersignup().setVisible(true);
    }
}