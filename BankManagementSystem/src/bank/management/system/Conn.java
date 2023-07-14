package bank.management.system;

import java.sql.*;

public class Conn 
{
	//create connection
	Connection c;
	Statement s;
	public Conn()
	{
		try
		{
			c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Thanmai@2224");
			s=c.createStatement();
			
		} catch(Exception e){
			System.out.println(e);
		}
	}

}
