package bank.management.system;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.*;

public class MiniStatement extends JFrame{

	MiniStatement(String pinnumber)
	{
		
		setLayout(null);
		
		JLabel text = new JLabel();
		add(text);
		
		JLabel bank = new JLabel("Indian Bank");
		bank.setBounds(150,20,100,20);
		bank.setFont(new Font("System",Font.BOLD,16));
		add(bank);
		
		JLabel card = new JLabel();
		card.setBounds(20,80,300,20);
		add(card);
		
		JLabel mini = new JLabel();
		add(mini);
		
		JLabel balance = new JLabel();
		balance.setBounds(20,400,300,20);
		add(balance);
		
		try
		{
			Conn c8 = new Conn();
			ResultSet rs = c8.s.executeQuery("select * from login where pinnumber = '"+pinnumber+"'");
			int cnt = 0;
			while(rs.next())
			{
				card.setText("Card Number: " + rs.getString("cardnumber").substring(0,4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12) );
			}
		}
		catch(Exception ae)
		{
			System.out.println(ae);
		}
		
		try
		{
			Conn c8 = new Conn();
			ResultSet rs1 = c8.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
			int cnt = 1;
			int size = rs1.getRow();
			while(rs1.next())
			{
				mini.setText(mini.getText() + "<html>" + rs1.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs1.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs1.getString("amount") +"<br><br><html>");
			    cnt = cnt + 1;
			    
			}
			mini.setText(mini.getText()+"......");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		try
		{
			Conn c6 = new Conn();
			ResultSet rs = c6.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
			int bal = 0;
			while(rs.next())
			{
				if(rs.getString("type").equals("Deposit"))
				{
					bal += Integer.parseInt(rs.getString("amount"));
				}
				else if(rs.getString("type").equals("withdraw"))
				{
					bal -= Integer.parseInt(rs.getString("amount"));
				}
			}
			balance.setText("Your current balance is Rs. "+bal);
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
		
		mini.setBounds(20,140,400,200);
		
		setTitle("Mini Statement");
		setVisible(true);
		setLocation(20,20);
		setSize(400,600);
		
	}
	
	public static void main(String[] args) 
	{
		new MiniStatement("");

	}

}
