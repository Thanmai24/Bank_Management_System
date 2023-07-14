package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;

public class Withdrawl extends JFrame implements ActionListener
{
	JButton withdraw,back;
	JTextField amount;
	String pinnumber;
	Withdrawl(String pinnumber)
	{
		setLayout(null);
		this.pinnumber = pinnumber;
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900,700,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,700);
		add(image);
		
		JLabel text = new JLabel("Enter the amount you want to deposit");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(190,160,400,20);
		image.add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("Raleway",Font.BOLD,22));
		amount.setBounds(190,210,300,25);
		image.add(amount);
		
		withdraw = new JButton("Withdraw");
		withdraw.setBounds(355,300,140,30);
		withdraw.addActionListener(this);
		image.add(withdraw);
		
	    back = new JButton("Back");
		back.setBounds(355,340,140,30);
		back.addActionListener(this);
		image.add(back);
		
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
	}
	
	public static void main(String args[])
	{
		new Withdrawl("");
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		if(e.getSource() == withdraw)
		{
			String number = amount.getText();
			Date date = new Date();
			if(number.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
			}
			else 
			{
				try
				{
				   Conn c5 = new Conn();
			       String query = "insert into bank values('"+pinnumber+"','"+date+"','withdraw','"+number+"')";
			       c5.s.executeUpdate(query);
			       JOptionPane.showMessageDialog(null, "Rs "+number+" withdraw successfully");
			       setVisible(false);
			       new Transactions(pinnumber).setVisible(true);
				}
				catch(Exception ae)
				{
					System.out.println(ae);
				}
			}
		}
		else if(e.getSource() == back)
		{
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
		
		
	}

}
