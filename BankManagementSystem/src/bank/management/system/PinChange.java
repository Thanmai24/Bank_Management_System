package bank.management.system;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener
{
	JButton change,back;
	JPasswordField pin,repin;
	String pinnumber;
    PinChange(String pinnumber)
    {
    	setLayout(null);
    	this.pinnumber = pinnumber;
    	ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    	Image i2 = i1.getImage().getScaledInstance(900,700,Image.SCALE_DEFAULT);
    	ImageIcon i3 = new ImageIcon(i2);
    	JLabel image = new JLabel(i3);
    	image.setBounds(0,0,900,700);
    	add(image);
    	
    	JLabel text = new JLabel("CHANGE YOUR PIN");
    	text.setForeground(Color.WHITE);
    	text.setBounds(260,150,300,30);
    	text.setFont(new Font("System",Font.BOLD,16));
    	image.add(text);
    	
    	JLabel pintext = new JLabel("New PIN:");
    	pintext.setForeground(Color.WHITE);
    	pintext.setBounds(170,200,300,30);
    	pintext.setFont(new Font("System",Font.BOLD,16));
    	image.add(pintext);
    	
    	pin = new JPasswordField();
    	pin.setFont(new Font("Raleway",Font.BOLD,16));
    	pin.setBounds(350,200,160,25);
    	image.add(pin);
    	
    	JLabel repintext = new JLabel("Re-Enter the new PIN:");
    	repintext.setForeground(Color.WHITE);
    	repintext.setBounds(170,240,300,30);
    	repintext.setFont(new Font("System",Font.BOLD,16));
    	image.add(repintext);
    	
    	repin = new JPasswordField();
    	repin.setFont(new Font("Raleway",Font.BOLD,16));
    	repin.setBounds(350,240,160,25);
    	image.add(repin);
    	
    	change = new JButton("CHANGE");
    	change.setBounds(350,320,150,30);
    	change.addActionListener(this);
    	image.add(change);
    	
    	back = new JButton("BACK");
    	back.setBounds(170,320,150,30);
    	back.addActionListener(this);
    	image.add(back);
    	
    	setVisible(true);
    	setSize(900,900);
    	setLocation(300,0);
    	
    }
	
	public static void main(String[] args) 
	{
		new PinChange("");

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		
		if(e.getSource() == change)
		{
			try
			{
				String npin = pin.getText();
				String rpin = repin.getText();
				
				if(!(npin.equals(rpin)))
				{
					JOptionPane.showMessageDialog(null, "Entered pin does not match");
					return;
				}
				
				if(npin.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please enter PIN");
					return;
				}
				
				if(rpin.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please re-enter new PIN");
					return;
				}
				
				Conn c7 = new Conn();
				String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
				String query2 ="update signup3 set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"'";
				String query3 ="update login set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"'";
			    
				c7.s.executeUpdate(query1);
				c7.s.executeUpdate(query2);
				c7.s.executeUpdate(query3);
			
				JOptionPane.showMessageDialog(null, "PIN change successfully");
				
				setVisible(false);
				new Transactions(npin).setVisible(true);
			}
			
			catch(Exception ae)
			{
				System.out.println(ae);
			}
		}
		
		else if(e.getSource() == back)
		{
			setVisible(true);
			new Transactions(pinnumber).setVisible(true);
		}
		
	}

}
