package ASimulatorSystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.sql.*;
public class Login extends JFrame implements ActionListener {
	JLabel l1,l2,l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1,b2,b3;
  
    Login(){
         
    	super("AUTOMATIC TELLER MACHINE");
    	Color  clr = new Color(5, 46, 66);
    	Color  clr1 = new Color(149, 212, 245);
    	Color clr2 = new Color(173, 239, 208);
        
        l1 = new JLabel("WELCOME TO ATM");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        
        l1.setForeground(clr1);
        
        l2 = new JLabel("Card No:");
        l2.setFont(new Font("Raleway", Font	.BOLD, 28));
       
        l2.setForeground(clr2);
        
        l3 = new JLabel("PIN:");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        l3.setForeground(clr2);
        
        tf1 = new JTextField(15);
        tf1.setBackground(clr1);
        pf2 = new JPasswordField(15);
        pf2.setBackground(clr1);
        
        b1 = new JButton("SIGN IN");
        b1.setBackground(clr1);
        b1.setForeground(clr);
        
        b2 = new JButton("CLEAR");
        b2.setBackground(clr1);
        b2.setForeground(clr);
        
        b3 = new JButton("SIGN UP");
        b3.setBackground(clr1);
        b3.setForeground(clr);
        
        setLayout(null);
        
        l1.setBounds(175,50,450,200);            //set bounds for position and size of the component
        add(l1);                                 //(height from x, height from y, width(length),  height)
        
        l2.setBounds(125,150,375,200);
        add(l2); 
        
        l3.setBounds(125,225,375,200);
        add(l3);
        
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        tf1.setBounds(300,235,230,30);
        add(tf1);
       
        pf2.setFont(new Font("Arial", Font.BOLD, 14));
        pf2.setBounds(300,310,230,30);
        add(pf2);
        
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(300,400,100,30);
        add(b1);
        
        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(430,400,100,30);
        add(b2);
        
        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setBounds(300,450,230,30);
        add(b3);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        
        getContentPane().setBackground(clr);
        
        setSize(750,750);
        setLocation(500,200);
        setVisible(true);              //by default the frame is false
        
    }
    public void actionPerformed(ActionEvent ae){
       
        try{        
            conn c1 = new conn();
        	String a  = tf1.getText();
            String b  = new String(pf2.getPassword());
            String q  = "select * from login where cardno = '"+a+"' and pin = '"+b+"'";
            ResultSet rs = c1.s.executeQuery(q);            //when we need to retrieve data from database we use execute query.
            
            if(ae.getSource()==b1){
                if(rs.next()){
                    new Transaction().setVisible(true);                 //
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Password");
                    }
            }
            else if(ae.getSource()==b2){
                tf1.setText("");
                pf2.setText("");
            }else if(ae.getSource()==b3){
                new Signup().setVisible(true);                       //
                setVisible(false);
            }
        }catch(Exception e){
                    e.printStackTrace();
                    System.out.println("error: "+e);
        }
    }
    
    public static void main(String[] args){
        new Login().setVisible(true);
    }
}