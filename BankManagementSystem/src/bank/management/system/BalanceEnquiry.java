package bank.management.system;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class BalanceEnquiry extends JFrame implements ActionListener
{
	JButton back;
	String pinnumber;
	BalanceEnquiry(String pinnumber)
	{
		this.pinnumber = pinnumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,700);
		add(image);
		
		back = new JButton("Back");
		back.setBounds(350,330,150,30);
		back.addActionListener(this);
		image.add(back);
		int balance = 0;
		try
		{
			Conn c6 = new Conn();
			ResultSet rs = c6.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
			
			while(rs.next())
			{
				if(rs.getString("type").equals("Deposit"))
				{
					balance += Integer.parseInt(rs.getString("amount"));
				}
				else if(rs.getString("type").equals("withdraw"))
				{
					balance -= Integer.parseInt(rs.getString("amount"));
				}
			}
				
		}
		catch(Exception ae)
		{
			System.out.println(ae);
		}
		
		JLabel text = new JLabel("Your current account balance is Rs "+balance);
		text.setFont(new Font("Raleway",Font.BOLD,16));
		text.setForeground(Color.WHITE);
		text.setBounds(170,170,400,30);
		image.add(text);
		
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
	}

	public static void main(String[] args) 
	{
	   new BalanceEnquiry("");	
      
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==back)
		{
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
		
		
		
	}

}
