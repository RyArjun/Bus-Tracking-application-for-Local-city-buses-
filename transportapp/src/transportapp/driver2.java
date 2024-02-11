
package transportapp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class driver2 extends JFrame implements ItemListener ,ActionListener{
    JLabel l1, l2, l3,l4,l5,l6,l7,l8;
    JTextField tf1;
    JComboBox stop;
    JButton b1, b2, b3,b4;
    String busno;
    String source;
    String dest;
     String stops[]=new String[10];
    int j;
    static JComboBox c1;
  
    driver2(String busno){
        this.busno=busno;
         l1 = new JLabel("Bus no");
        l1.setFont(new Font("Bus No.", Font.BOLD, 22));
        l1.setBounds(10, 20, 100, 50);
        add(l1);
        
        l2 = new JLabel(busno);
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setBounds(120, 20, 50, 50);
        add(l2);
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

 c1 = new JComboBox(stops);
c1.setEditable(true);
c1.setBounds(10, 180, 150, 50);
 add(c1)  ;
c1.addItemListener(this);
   



 l5 = new JLabel();
        
        l5.setBounds(200, 180, 180, 50);
        l5.setForeground(Color.blue);
        add(l5);





b3 = new JButton("End Journey");
        b3.setBounds(150,420, 150, 30);
        b3.addActionListener(this);
        add(b3);










     
           
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        setSize(450, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(550,40);
        setLayout(null);
        setVisible(true);
        
    }
    
    public void itemStateChanged(ItemEvent e)
    {
       
        if (e.getSource() == c1) {
 
            l5.setText(c1.getSelectedItem() + "");
            String loc=l5.getText();
            getlocation(busno,loc);
         
       
       
       
       
       }
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
     
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
    
    
    
     public void getlocation(String busno,String loc)
    {
        try{
         l5.setText(c1.getSelectedItem() + "");
            
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/busapp", "postgres","root");
                    Statement stmt = conn.createStatement();
                     String sql  = "select stop from route1 ";
       stmt.executeUpdate("UPDATE bus1 " +"SET location = '"+loc+"' where busno = '"+busno+"'");
        }
        catch(Exception ee){
                ee.printStackTrace();
                System.out.println("error: "+ee);
        }
        
    }
    
    
    
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b3)
        {
            setVisible(false);
            new driverlogin().setVisible(true);
        }
       
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
       
        new driver2("").setVisible(true);
    }
}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

