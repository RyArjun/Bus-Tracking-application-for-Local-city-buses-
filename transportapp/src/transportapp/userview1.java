
package transportapp;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class userview1 extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l8;
    JTextField t1,t2;
    JPasswordField pf2;
    JButton b1,b2,b3;
    
    String source  ;
                            String dest ;
    
    userview1()
    { 
       
        l1=new JLabel("City Link Bus app");
        l1.setFont(new Font("Osward", Font.BOLD, 18));
        l1.setBounds(150,40,450,50);
        add(l1);
        
        l2=new JLabel("Enter Bus no.");
        l2.setFont(new Font("Osward", Font.BOLD, 18));
        l2.setBounds(10,240,150,20);
        add(l2);
        
        t1 = new JTextField();
        
        t1.setBounds(10,280, 100, 25);
        add(t1);
         b1 = new JButton("Find Bus");
        b1.setBounds(10,320, 100, 30);
        b1.addActionListener(this);
        add(b1);
        l8=new JLabel("OR");
        l8.setFont(new Font("Osward", Font.BOLD, 18));
        l8.setBounds(180,250,30,50);
        add(l8);
        
        l3=new JLabel("Enter Bus Stop ");
        l3.setFont(new Font("Osward", Font.BOLD, 18));
        l3.setBounds(280,240,150,20);
        add(l3);
        
        t2 = new JTextField();
        
        t2.setBounds(280,280, 100, 25);
        add(t2);
        
         b2 = new JButton("Exit");
        b2.setBounds(300,520, 100, 30);
        b2.addActionListener(this);
        add(b2);
        
        
        
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
                    Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/busapp", "postgres","root");
                    Statement stmt = conn.createStatement();
                   //int amount1=Integer.parseInt(amount); 
                    
                    String sql  = "select * from bus1 where busno = '"+busno+"'";
                    ResultSet rs = stmt.executeQuery(sql);
                    
                    while(rs.next()){
                        
                       
                          String source  =rs.getString("source");
                            String dest =rs.getString("destination");
                            

                         
                    new tracking1(busno,source,dest).setVisible(true);
                    
                    }
                     setVisible(false);
                    
                  
}
                 
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        new userview1();
    }
}
