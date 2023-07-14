package bank.management.system;

import java.awt.*;
import java.awt.event.*; //ActionListener
import java.sql.*;

import javax.swing.*;

public class Login extends JFrame implements ActionListener
{
	private
	   JButton login,signUp,clear;
	   JTextField cardField;
	   JPasswordField pinField;
	 
	Login()
	{
	  setSize(700,500);
	  setLayout(null);
	  
	  ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
	  Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
	  ImageIcon i3 = new ImageIcon(i2);
	  
	  JLabel label = new JLabel(i3);
	  label.setBounds(70,10,100,100);
	  add(label);
	  
	  JLabel text = new JLabel("Welcome to ATM");
	  text.setFont(new Font("Osword",Font.BOLD,30));
	  text.setBounds(200,40,500,40);
	  add(text);
	  
	  JLabel cardno = new JLabel("Card No.");
	  cardno.setFont(new Font("Raleway",Font.BOLD,20));
	  cardno.setBounds(120,150,150,30);
	  add(cardno);
	  
	  cardField = new JTextField();
	  cardField.setBounds(330,150,250,30);
	  cardField.setFont(new Font("Arial",Font.BOLD,14));
	  add(cardField);
	  
	  JLabel pin = new JLabel("PIN:");
	  pin.setFont(new Font("Raleway",Font.BOLD,20));
	  pin.setBounds(120,210,150,40);
	  add(pin);
	  
	  pinField = new JPasswordField();
	  pinField.setBounds(330,210,250,30);
	  pinField.setFont(new Font("Arial",Font.BOLD,14));
	  add(pinField);
	  
	  login = new JButton("SIGN IN");
	  login.setBounds(330,280,100,35);
	  login.setBackground(Color.BLACK);
	  login.setForeground(Color.white);
	  login.addActionListener(this);
	  add(login);
	  
	  clear = new JButton("CLEAR");
	  clear.setBounds(480,280,100,35);
	  clear.setBackground(Color.BLACK);
	  clear.setForeground(Color.white);
	  clear.addActionListener(this);
	  add(clear);
	  
	  signUp = new JButton("SIGN UP");
	  signUp.setBounds(330,340,250,35);
	  signUp.setBackground(Color.BLACK);
	  signUp.setForeground(Color.white);
	  signUp.addActionListener(this);
	  add(signUp);
	  
	  getContentPane().setBackground(Color.white);
	  
	  setLocation(200,100);
	  setTitle("Automated Teller Machine");
	  setVisible(true);
	}
	
    public static void main(String[] args)
    {
    	new Login();
    }

    @Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == clear)
		{
			cardField.setText("");
			pinField.setText("");
		}
		else if(e.getSource() == login)
		{
			
			Conn c4 = new Conn();
			String cardnumber = cardField.getText();
			String pinnumber = pinField.getText();
			String query = "select * from login where cardnumber = '"+cardnumber+"'and pinnumber = '"+pinnumber+"'";
		    try
		    {
		    	ResultSet rs = c4.s.executeQuery(query);
		    	if(rs.next())
		    	{
		    		setVisible(false);
					new Transactions(pinnumber).setVisible(true);
		    	}
		    	else
		    	{
		    		JOptionPane.showMessageDialog(null, "Incorrect card number or pin");
		    	}
		    }
		    catch(Exception ex)
		    {
		    	System.out.println(ex);
		    }
			
			
		}
		else if(e.getSource() == signUp)
		{
		  setVisible(false);
		  new SignupOne().setVisible(true); 
		}
    
	}
} 


