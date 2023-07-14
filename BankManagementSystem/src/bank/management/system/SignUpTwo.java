package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

import com.toedter.calendar.JDateChooser;

public class SignUpTwo extends JFrame implements ActionListener
{
	long random;
	JTextField panField,aadharField;
	JButton next;
	JRadioButton socy,socn,eyes,eno;
	JComboBox<String> religionVal,categoryField,IncomeField,eduField,occupationField;
	String formno;
	
	SignUpTwo(String formno)
	{
		this.formno = formno;
		setLayout(null);
		setTitle("NEW APPLICATION FORM TWO");
		
		
		JLabel additionalDetails = new JLabel("Page - 2 : Additional Details");
		additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
		additionalDetails.setBounds(280,60,500,35);
		add(additionalDetails);
		
		JLabel religion = new JLabel("Religion :");
		religion.setFont(new Font("Raleway",Font.BOLD,20));
		religion.setBounds(100,120,100,22);
		add(religion);
		
		String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
		religionVal = new JComboBox<>(valReligion);
        religionVal.setBackground(Color.WHITE);
		religionVal.setBounds(300,120,280,23);
		add(religionVal);
		
		
		JLabel category = new JLabel("Category :");
		category.setFont(new Font("Raleway",Font.BOLD,20));
		category.setBounds(100,165,200,22);
		add(category);
		
		String valCategory[] = {"General","OBC","SC","ST","Other"};
		categoryField = new JComboBox<>(valCategory);
		categoryField.setBounds(300,165,280,23);
		categoryField.setBackground(Color.WHITE);
		add(categoryField);
		
		JLabel income = new JLabel("Income :");
		income.setFont(new Font("Raleway",Font.BOLD,20));
		income.setBounds(100,215,200,22);
		add(income);
		
		String valIncome[] = {"NULL","<1,50,000","< 2,50,00","<5,00,00","upto 10,00,000"};
		IncomeField = new JComboBox<>(valIncome);
		IncomeField.setBounds(300,215,280,22);
		IncomeField.setBackground(Color.WHITE);
		add(IncomeField);
		
		
		JLabel education = new JLabel("Educational");
		education.setFont(new Font("Raleway",Font.BOLD,20));
		education.setBounds(100,265,200,22);
		add(education);
		
		
		JLabel qualification = new JLabel("Qualification :");
		qualification.setFont(new Font("Raleway",Font.BOLD,20));
		qualification.setBounds(100,300,200,22);
		add(qualification);
		
		String valedu[] = {"Non-graduate","Graduate","Post Graduate","Doctrate","Other"};
		eduField = new JComboBox<>(valedu);
		eduField.setBounds(300,300,280,23);
		eduField.setBackground(Color.WHITE);
		add(eduField);
		
		JLabel occupation = new JLabel("Occupation :");
		occupation.setFont(new Font("Raleway",Font.BOLD,20));
		occupation.setBounds(100,355,200,22);
		add(occupation);
		
		String valoccupation[] = {"Salaried","Self-Employed","Business","Student","Retiered","Other"};
		occupationField = new JComboBox<>(valoccupation);
		occupationField.setBounds(300,355,280,23);
		occupationField.setBackground(Color.WHITE);
		add(occupationField);
		
		JLabel pan = new JLabel("PAN number :");
		pan.setFont(new Font("Raleway",Font.BOLD,20));
		pan.setBounds(100,415,200,22);
		add(pan);
		
		panField = new JTextField();
		panField.setBounds(300,415,280,23);
		panField.setFont(new Font("Raleway",Font.BOLD,14));
		add(panField);
		
		JLabel aadhar = new JLabel("Aadhar number :");
		aadhar.setFont(new Font("Raleway",Font.BOLD,20));
		aadhar.setBounds(100,465,200,22);
		add(aadhar);
		
		aadharField = new JTextField();
		aadharField.setBounds(300,465,280,23);
		aadharField.setFont(new Font("Raleway",Font.BOLD,14));
		add(aadharField);
		
		JLabel seniorCitizen = new JLabel("Senior Citizen :");
		seniorCitizen.setFont(new Font("Raleway",Font.BOLD,20));
		seniorCitizen.setBounds(100,515,200,22);
		add(seniorCitizen);
		
		socy = new JRadioButton("Yes");
		socy.setBounds(300,515,100,23);
		socy.setBackground(Color.WHITE);
		add(socy);
		
		socn = new JRadioButton("No");
		socn.setBounds(400,515,100,23);
		socn.setBackground(Color.WHITE);
		add(socn);
		
		ButtonGroup seniorGroup = new ButtonGroup();
		seniorGroup.add(socy);
		seniorGroup.add(socn);
		
		JLabel exaccount = new JLabel("Exisiting Account :");
		exaccount.setFont(new Font("Raleway",Font.BOLD,20));
		exaccount.setBounds(100,555,200,22);
		add(exaccount);
		
		eyes = new JRadioButton("Yes");
		eyes.setBounds(300,555,100,22);
		eyes.setBackground(Color.WHITE);
		add(eyes);
		
		eno = new JRadioButton("No");
		eno.setBounds(400,555,100,22);
		eno.setBackground(Color.WHITE);
		add(eno);
		
		ButtonGroup existAccount = new ButtonGroup();
		existAccount.add(eyes);
		existAccount.add(eno);
		
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
		new SignUpTwo("");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String religion = (String)religionVal.getSelectedItem();
		String category = (String)categoryField.getSelectedItem();
		String income = (String)IncomeField.getSelectedItem();
		String education = (String)eduField.getSelectedItem();
		String occupation = (String)occupationField.getSelectedItem();
		String seniorCitizen = null;
		String existingAcc = null;
		
		if(socy.isSelected())
		{
			seniorCitizen = "yes";
		}
		else if(socn.isSelected())
		{
			seniorCitizen = "no";
		}
		
		if(eyes.isSelected())
		{
			existingAcc = "yes";
		} 
		else if(eno.isSelected())
		{
			existingAcc = "no";
		}
		
		String pan = panField.getText();
		String aadhar = aadharField.getText();
		
		try {
			Conn c2 = new Conn();
			String query = "Insert into signup2 values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhar+"','"+seniorCitizen+"','"+existingAcc+"')";
			c2.s.executeUpdate(query);
			
			setVisible(false);
			new SignupThree(formno).setVisible(true);
		} catch(Exception exp) {
			System.out.println(exp);
		}
	}

	
	

}
