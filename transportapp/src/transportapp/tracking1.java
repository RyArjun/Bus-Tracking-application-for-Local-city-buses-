
package transportapp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class tracking1 extends JFrame implements ActionListener{
    
    JLabel l1, l2, l3,l4,l5,l6,l7,l8;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1, b2, b3;
    String busno;
    String source;
    String dest;
    tracking1(String busno,String source,String dest)
    {
        this.busno=busno;
        this.source=source;
        this.dest=dest;
        
       
        l1 = new JLabel("Bus no");
        l1.setFont(new Font("Bus No.", Font.BOLD, 22));
        l1.setBounds(10, 20, 100, 50);
        add(l1);
        
        l2 = new JLabel(busno);
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setBounds(10, 60, 50, 50);
        add(l2);
        
         l3 = new JLabel("Source");
        l3.setFont(new Font("Bus No.", Font.BOLD, 22));
        l3.setBounds(140, 20, 100, 50);
        add(l3);
        
        l4 = new JLabel(source);
        l4.setFont(new Font("System", Font.BOLD, 16));
        l4.setBounds(140, 60, 150, 50);
        add(l4);
        
        l4 = new JLabel("Destination");
        l4.setFont(new Font("Bus No.", Font.BOLD, 22));
        l4.setBounds(280, 20, 150, 50);
        add(l4);
        
        l5 = new JLabel(dest);
        l5.setFont(new Font("System", Font.BOLD, 16));
        l5.setBounds(280, 60, 150, 50);
        add(l5);
        
        
        
        l6 = new JLabel("Current Location");
        l6.setFont(new Font("Osward", Font.BOLD, 18));
        l6.setBounds(120, 100, 150, 50);
        add(l6);
        
        b1 = new JButton("Show");
        b1.setFont(new Font("Osward", Font.BOLD, 12));
        b1.setBounds(300, 140, 100, 30);
        add(b1);
        
       // this.display();
          b1.addActionListener(this);
      
        b2 = new JButton("Refresh");
        b2.setFont(new Font("Osward", Font.BOLD, 12));
        b2.setBounds(300, 190, 100, 30);
        add(b2);
        
         b2.addActionListener(this);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
         setSize(450, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(550,40);
        setLayout(null);
        setVisible(true);
    }
   
    
     public void actionPerformed(ActionEvent ae) 
     {
         if(ae.getSource()==b1){
         getlocation(busno);
         }
         else if (ae.getSource()==b2)
         {
             setVisible(false);
             new tracking1(busno,source,dest).setVisible(true);
           
           
         }
     }
    
    
    
    
    
    
    public void getlocation(String busno)
    {
         JLabel l1, l2, l3,l4,l5,l6,l7,l8;
          String a[]=new String[10];
          String loc = null;
          int j=0;
        try {
           Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/busapp", "postgres","root");
                    Statement stmt = conn.createStatement();
                     String sql  = "select stop from route1 ";
                     String sql1  = "select location from bus1 where busno = '"+busno+"'";
            ResultSet rs = stmt.executeQuery(sql);
           
               
                        
                       
                    while (rs.next()) {      
                         a[j] = rs.getString("stop");j++;}
                         ResultSet rs1 = stmt.executeQuery(sql1); 
                while (rs1.next()) {      
                          loc= rs1.getString("location");}
                
                
               l1 = new JLabel(a[0]);
               l1.setBounds(100,180, 150, 50);
                
                add(l1);
                
             l2 = new JLabel(a[1]);
             l2.setBounds(100,220, 150, 50);
            l2.setFont(new Font("System", Font.BOLD, 16));
           
            add(l2); 
            
            
             l3 = new JLabel(a[2]);
             l3.setBounds(100,260, 150, 50);
            l3.setFont(new Font("System", Font.BOLD, 16));
            
            add(l3); 
            
            
             l4 = new JLabel(a[3]);
              l4.setBounds(100,320, 150, 50);
            l4.setFont(new Font("System", Font.BOLD, 16));
           
             add(l4); 
          
             
            l5 = new JLabel(a[4]);
            l5.setBounds(100,360, 150, 50);
            l5.setFont(new Font("System", Font.BOLD, 16));
            
            add(l5); 
            
                
            if(loc.equals(a[0])) 
            {
                l1.setFont(new Font("System", Font.BOLD, 16));
                l1.setForeground(Color.red);
                add(l1);
            }
            else{l1.setFont(new Font("System", Font.BOLD, 16));add(l1);}
                
            
              if(loc.equals(a[1])) 
            {
                l2.setFont(new Font("System", Font.BOLD, 16));
                l2.setForeground(Color.red);
                add(l2);
            }
            else{l2.setFont(new Font("System", Font.BOLD, 16));add(l2);}   
                
                
            
            
             if(loc.equals(a[2])) 
            {
                l3.setFont(new Font("System", Font.BOLD, 16));
                l3.setForeground(Color.red);
                add(l3);
            }
            else{l3.setFont(new Font("System", Font.BOLD, 16));add(l3);}
            
            
            
             if(loc.equals(a[3])) 
            {
                l4.setFont(new Font("System", Font.BOLD, 16));
                l4.setForeground(Color.red);
                add(l4);
            }
            else{l4.setFont(new Font("System", Font.BOLD, 16));add(l4);}
            
            
            
             if(loc.equals(a[4])) 
            {
                l5.setFont(new Font("System", Font.BOLD, 16));
                l5.setForeground(Color.red);
                add(l5);
            }
            else{l5.setFont(new Font("System", Font.BOLD, 16));add(l5);}
            
            
            
            
            
            
            
            
            
         

           
        } 
        
        
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
    
    
    public static void main(String[] args) {
        new tracking1("","","").setVisible(true);
    }
}
