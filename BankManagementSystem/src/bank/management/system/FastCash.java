package bank.management.system;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;
public class FastCash extends JFrame implements ActionListener{

	JButton b1,b2,b3,b4,b5,b6,b7;
	String pinnumber;
	FastCash(String pinnumber)
	{
		setLayout(null);
		this.pinnumber = pinnumber;
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900,720,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,720);
		add(image);
		
		JLabel text = new JLabel("Select withdrawl amount");
		text.setBounds(240,150,700,35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text);
		
		b1 = new JButton("Rs 100");
		b1.setBounds(170,270,150,25);
		b1.addActionListener(this);
		image.add(b1);
		
		b2 = new JButton("Rs 500");
		b2.setBounds(355,270,150,25);
		b2.addActionListener(this);
		image.add(b2);
		
		b3 = new JButton("Rs 1000");
		b3.setBounds(170,305,150,25);
		b3.addActionListener(this);
		image.add(b3);
		
		b4 = new JButton("Rs 2000");
		b4.setBounds(355,305,150,25);
		b4.addActionListener(this);
		image.add(b4);
		
		b5 = new JButton("Rs 5000");
		b5.setBounds(170,340,150,25);
		b5.addActionListener(this);
		image.add(b5);
		
		b6 = new JButton("Rs 10000");
		b6.setBounds(355,340,150,25);
		b6.addActionListener(this);
		image.add(b6);
		
		b7 = new JButton("Back");
		b7.setBounds(355,375,150,25);
		b7.addActionListener(this);
		image.add(b7);
		
		setSize(900,900);
		setLocation(300,0);
//		setUndecorated(true);
		setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		new FastCash("");
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == b7 )
		{
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
		else
		{
			String amount = ((JButton)e.getSource()).getText().substring(3);
			
			try
			{
				Conn c6 = new Conn();
				ResultSet rs = c6.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
				int balance = 0;
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
					if(e.getSource()!= b7 && balance< Integer.parseInt(amount))
					{
						JOptionPane.showMessageDialog(null, "Insufficient Balance");
						return;
					}
					
					Date date = new Date();
					String query = "insert into bank values('"+pinnumber+"','"+date+"','withdraw','"+amount+"')";
					c6.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs "+amount+" withdraw successfully");
					
					setVisible(false);
					new Transactions(pinnumber).setVisible(true);
			}
			catch(Exception ae)
			{
				System.out.println(ae);
			}
		}
	}

}
