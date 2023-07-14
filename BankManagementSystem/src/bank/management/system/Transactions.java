package bank.management.system;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Transactions extends JFrame implements ActionListener{

	JButton deposit,withdrawl,miniStatement,pinchange,fastcash,balanceenquiry,exit;
	String pinnumber;
	Transactions(String pinnumber)
	{
		setLayout(null);
		this.pinnumber = pinnumber;
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900,720,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,720);
		add(image);
		
		JLabel text = new JLabel("Please select your transaction");
		text.setBounds(220,150,700,35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(170,270,150,25);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdrawl = new JButton("Cash Withdrawl");
		withdrawl.setBounds(355,270,150,25);
		withdrawl.addActionListener(this);
		image.add(withdrawl);
		
		fastcash = new JButton("Fast Cash");
		fastcash.setBounds(170,305,150,25);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		miniStatement = new JButton("Mini Statement");
		miniStatement.setBounds(355,305,150,25);
		miniStatement.addActionListener(this);
		image.add(miniStatement);
		
		pinchange = new JButton("Pin Change");
		pinchange.setBounds(170,340,150,25);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balanceenquiry = new JButton("Balance enquiry");
		balanceenquiry.setBounds(355,340,150,25);
		balanceenquiry.addActionListener(this);
		image.add(balanceenquiry);
		
		exit = new JButton("Exit");
		exit.setBounds(355,375,150,25);
		exit.addActionListener(this);
		image.add(exit);
		
		setSize(900,900);
		setLocation(300,0);
//		setUndecorated(true);
		setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		new Transactions("");
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == exit)
		{
			System.exit(0);
		}
		else if(e.getSource()==deposit)
		{
			setVisible(false);
			new Deposit(pinnumber).setVisible(true);
		}
		else if(e.getSource()==withdrawl)
		{
			setVisible(false);
			new Withdrawl(pinnumber).setVisible(true);
		}
		else if(e.getSource() == fastcash)
		{
			setVisible(false);
			new FastCash(pinnumber).setVisible(true);
		}
		else if(e.getSource() == pinchange)
		{
			setVisible(false);
			new PinChange(pinnumber).setVisible(true);
		}
		else if(e.getSource() == balanceenquiry)
		{
			setVisible(false);
			new BalanceEnquiry(pinnumber).setVisible(true);
		}
		else if(e.getSource() == miniStatement)
		{
			new MiniStatement(pinnumber).setVisible(true);
		}
	}

}
