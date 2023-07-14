package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener
{
	long random;
	JTextField nameField,fnameField,emailField,addressField,cityField,stateField,pinField;
	JButton next;
	JRadioButton male,female,other,married,unmarried;
	JDateChooser datechooser;
	
	
	SignupOne()
	{
		
		Random rand = new Random();
		random=(Math.abs((rand.nextLong() % 9000L) + 1000L));
		setLayout(null);
		
		
		JLabel formno = new JLabel("APPLICATION FORM NO. "+random);
		formno.setFont(new Font("Raleway",Font.BOLD,38));
		formno.setBounds(140,10,600,40);
		add(formno);
		
		JLabel personDetails = new JLabel("Page - 1: Personal Details");
		personDetails.setFont(new Font("Raleway",Font.BOLD,22));
		personDetails.setBounds(280,60,500,35);
		add(personDetails);
		
		JLabel name = new JLabel("Name :");
		name.setFont(new Font("Raleway",Font.BOLD,20));
		name.setBounds(100,120,100,22);
		add(name);
		
		nameField = new JTextField();
		nameField.setBounds(300,120,280,23);
		nameField.setFont(new Font("Raleway",Font.BOLD,14));
		add(nameField);
		
		JLabel fname = new JLabel("Father's Name :");
		fname.setFont(new Font("Raleway",Font.BOLD,20));
		fname.setBounds(100,165,200,22);
		add(fname);
		
		fnameField = new JTextField();
		fnameField.setBounds(300,165,280,23);
		fnameField.setFont(new Font("Raleway",Font.BOLD,14));
		add(fnameField);
		
		JLabel dob = new JLabel("Date of Birth :");
		dob.setFont(new Font("Raleway",Font.BOLD,20));
		dob.setBounds(100,215,200,22);
		add(dob);
		
		datechooser = new JDateChooser();
		datechooser.setBounds(300,215,280,22);
		datechooser.setForeground(Color.black);
		add(datechooser);
		
		
		JLabel gender = new JLabel("Gender :");
		gender.setFont(new Font("Raleway",Font.BOLD,20));
		gender.setBounds(100,265,200,22);
		add(gender);
		
		male = new JRadioButton("Male");
		male.setBounds(300,265,80,24);
		male.setFont(new Font("Raleway",Font.BOLD,15));
		male.setBackground(Color.white);
		male.setForeground(Color.black);
		add(male);
		
		female = new JRadioButton("Female");
		female.setBounds(450,265,80,24);	
		female.setFont(new Font("Raleway",Font.BOLD,15));
		female.setBackground(Color.white);
		female.setForeground(Color.black);
		add(female);
		
		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(male);
		genderGroup.add(female);
		
		JLabel email = new JLabel("Email Address :");
		email.setFont(new Font("Raleway",Font.BOLD,20));
		email.setBounds(100,315,200,22);
		add(email);
		
		emailField = new JTextField();
        emailField.setBounds(300,315,280,23);
		emailField.setFont(new Font("Raleway",Font.BOLD,14));
		add(emailField);
		
		JLabel marital = new JLabel("Marital Status :");
		marital.setFont(new Font("Raleway",Font.BOLD,20));
		marital.setBounds(100,365,200,22);
		add(marital);
		
		married = new JRadioButton("Married");
		married.setBounds(300,365,100,24);
		married.setFont(new Font("Raleway",Font.BOLD,15));
		married.setBackground(Color.white);
		married.setForeground(Color.black);
		add(married);
		
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(400,365,120,24);	
		unmarried.setFont(new Font("Raleway",Font.BOLD,15));
		unmarried.setBackground(Color.white);
		unmarried.setForeground(Color.black);
		add(unmarried);
		
		other = new JRadioButton("other");
		other.setBounds(520,365,80,24);	
		other.setFont(new Font("Raleway",Font.BOLD,15));
		other.setBackground(Color.white);
		other.setForeground(Color.black);
		add(other);
		
		ButtonGroup maritalGroup = new ButtonGroup();
		maritalGroup.add(married);
		maritalGroup.add(unmarried);
		maritalGroup.add(other);
		
		JLabel address = new JLabel("Address :");
		address.setFont(new Font("Raleway",Font.BOLD,20));
		address.setBounds(100,415,200,22);
		add(address);
		
		addressField = new JTextField();
		addressField.setBounds(300,415,280,23);
		addressField.setFont(new Font("Raleway",Font.BOLD,14));
		add(addressField);
		
		JLabel city = new JLabel("City :");
		city.setFont(new Font("Raleway",Font.BOLD,20));
		city.setBounds(100,465,200,22);
		add(city);
		
		cityField = new JTextField();
		cityField.setBounds(300,465,280,23);
		cityField.setFont(new Font("Raleway",Font.BOLD,14));
		add(cityField);
		
		JLabel state = new JLabel("State :");
		state.setFont(new Font("Raleway",Font.BOLD,20));
		state.setBounds(100,515,200,22);
		add(state);
		
		stateField = new JTextField();
		stateField.setBounds(300,515,280,23);
		stateField.setFont(new Font("Raleway",Font.BOLD,14));
		add(stateField);
		
		JLabel pinCode = new JLabel("Pincode :");
		pinCode.setFont(new Font("Raleway",Font.BOLD,20));
		pinCode.setBounds(100,565,200,22);
		add(pinCode);
		
		pinField = new JTextField();
		pinField.setBounds(300,565,280,23);
		pinField.setFont(new Font("Raleway",Font.BOLD,14));
		add(pinField);
		
		JButton next = new JButton("Next");
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setFont(new Font("Raleway",Font.BOLD,14));
		next.setBounds(620,575,80,30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.white);
		
		
		
		setSize(850,800);
		setLocation(250,10);
		setVisible(true);
		
	}
	
	public static void main(String[] args)
	{
		new SignupOne();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String formno = ""+random;
		String name = nameField.getText();
		String fname= fnameField.getText();
		String email = emailField.getText();
		String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
		String gender = null;
		System.out.println(formno);
		
		if(male.isSelected())
		{
			gender = "male";
		}
		else if(female.isSelected())
		{
			gender="female";
		}
		String marital=null;
		if(married.isSelected())
		{
			marital = "Married";
		}
		else if(unmarried.isSelected())
		{
			marital = "Unmarried";
		}
		else if(other.isSelected())
		{
			marital = "Other";
		}
		
		String address = addressField.getText();
		String city = cityField.getText();
		String state = stateField.getText();
		String pin = pinField.getText();
		
		try {
			if(name.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Name is required");
			}
			if(fname.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Father's Name is required");
			}
			else
			{
				Conn c = new Conn();
				String query = "Insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
				c.s.executeUpdate(query);
				
				setVisible(false);
				new SignUpTwo(formno).setVisible(true);
			}
			
			
		} catch(Exception ep) {
			System.out.println(ep);
		}
		
		
	}
	
	

}
