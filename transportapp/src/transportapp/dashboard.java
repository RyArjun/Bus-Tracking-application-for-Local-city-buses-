package transportapp;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class dashboard extends JFrame
{
    JLabel l1, l2, l3,l4,l5,l6,l7,l8,l10,l11,l12,l13,l14,l15,l21;
    JLabel s1, s2, s3,s4,s5;
    JTextField tf1;
    JComboBox stop;
    JButton b1, b2, b3,b4;
    String busno="21";
    String source;
    String dest;
     String stops[]=new String[5];
        String status[]=new String[3];
    int j,m;
    static JComboBox c1;
    String loc = null;
    boolean x=true;
    dashboard()
    {
        
        
        System.out.println(busno);
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
         
             try{ 
          Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/busapp", "postgres","root");
                    Statement stmt = conn.createStatement();
                     String sql  = "select stop from route1 ";
                     String sql1  = "select location from bus1 where busno = '"+busno+"'";
            ResultSet rs = stmt.executeQuery(sql);
           
               
                        
                       
                    while (rs.next()) {      
                         stops[j] = rs.getString("stop");j++;}
       }
       catch (Exception e) {
            e.printStackTrace();
        }
        
        
       try{ 
          Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/busapp", "postgres","root");
                    Statement stmt = conn.createStatement();
                     
                     String sql1  = "select location from bus1 where busno = '"+busno+"'";
                    ResultSet rs = stmt.executeQuery(sql1);
           
               
                        
                       
                    while (rs.next()) {      
                        loc= rs.getString("location");}
       }
       catch (Exception e) {
            e.printStackTrace();
        }
             
             
        try{ 
          Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/busapp", "postgres","root");
                    Statement stmt = conn.createStatement();
                    
                     String sql1  = "select location from bus1";
            ResultSet rs = stmt.executeQuery(sql1);
           
               
                        
                       
                    while (rs.next()) {      
                         status[m] = rs.getString("location");m++;}
       }
       catch (Exception e) {
            e.printStackTrace();
        }   
       
             
      
        
       
       
       
       
       
       
       
       
       
       
       
       
       
        
         l10 = new JLabel(stops[0]);
         l10.setBounds(50,300, 150, 50);
                
          add(l10);
          
         l11 = new JLabel(stops[1]);
         l11.setBounds(180,300, 150, 50);
                
          add(l11);
          
          l12 = new JLabel(stops[2]);
         l12.setBounds(280,300, 150, 50);
                
          add(l12);
          
          l13 = new JLabel(stops[3]);
         l13.setBounds(430,300, 150, 50);
                
          add(l13);
        
        
        l14 = new JLabel(stops[4]);
         l14.setBounds(630,300, 150, 50);
                
          add(l14);
        
      
        
      
        
        
        s1 = new JLabel(">>");
        s1.setBounds(80,250, 150, 100);
        
        
        s2 = new JLabel(">>");
        s2.setBounds(210,250, 150, 100);
        
        s3 = new JLabel(">>");
        s3.setBounds(310,250, 150, 100);
        
         s4 = new JLabel(">>");
        s4.setBounds(460,250, 150, 100);
        
        s5 = new JLabel(">>");
        s5.setBounds(660,250, 150, 100);
        
      
        
        
        
       
      int m=0;
       for(int j=0;j<status.length;j++)
            {
                if(status[j].equals(stops[m]))
                {
                    add(s1);
                   
                    
                }
            }
       m++;
           for(int j=0;j<status.length;j++)
            {
                if(status[j].equals(stops[m]))
                {
                    add(s2);
                   
                    
                }
            }   
           m++;
                
                for(int j=0;j<status.length;j++)
            {
                if(status[j].equals(stops[m]))
                {
                    add(s3);
                   
                    
                }
            }   
                m++;
                  for(int j=0;j<status.length;j++)
            {
                if(status[j].equals(stops[m]))
                {
                    add(s4);
                   
                    
                }
            }   
                  m++;
                    for(int j=0;j<status.length;j++)
            {
                if(status[j].equals(stops[m]))
                {
                    add(s5);
                   
                    
                }
            }   
            
       
        
    
        
        
        
       
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(350,80);
        setLayout(null);
        setVisible(true);
        
        
        
    }
    
    
    
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String args[]) 
    
   {
     new dashboard();
   }
    
}