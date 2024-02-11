
package transportapp;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import transportapp.tracking1;

public class driverview extends JFrame implements ActionListener{
    String name="hello";
    JLabel l1, l2, l3,l4,l5,l6,l7,l8;
    JTextField t1;
    JPasswordField pf2;
    JButton b1, b2, b3;
    driverview(String name)
    {
       this.name=name;   
       System.out.println(name);
        
        l1=new JLabel("Driver name :");
        l1.setFont(new Font("Osward", Font.BOLD, 18));
        l1.setBounds(10,40,150,20);
        add(l1);
        l6=new JLabel( name);
        l6.setFont(new Font("Osward", Font.BOLD, 18));
        l6.setBounds(150,40,150,20);
        add(l6);
        
       
       
        l2=new JLabel("Enter Bus no.");
        l2.setFont(new Font("Osward", Font.BOLD, 18));
        l2.setBounds(150,240,150,20);
        add(l2);
        
        t1 = new JTextField();
        
        t1.setBounds(150,280, 150, 25);
        add(t1);
        b1 = new JButton("Start Journey");
        b1.setBounds(150,320, 150, 30);
        b1.addActionListener(this);
        add(b1);
        
        
       l1=new JLabel("Driver name :");
        l1.setFont(new Font("Osward", Font.BOLD, 18));
        l1.setBounds(10,40,150,20);
        add(l1);
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
        setSize(450, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(550,40);
        setLayout(null);
        setVisible(true);  
    }
    
    public void actionPerformed(ActionEvent e) 
    {
    try{   
         
            String busno= t1.getText();
            if(e.getSource()==b1){
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Enter  busno");
                }else{
                  

                         
                    new driver2(busno).setVisible(true);
                    
                    }
                     setVisible(false);
                    
                  
}
                 
                





            
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        else if(e.getSource()==b2){
                setVisible(false);
                System.exit(0);
            }
}catch(Exception ee){
                ee.printStackTrace();
                System.out.println("error: "+ee);
        }
    
}
    
   
    
    
    
    
    public static void main(String args[]) {
        new driverview("").setVisible(true);
    }
    
}
