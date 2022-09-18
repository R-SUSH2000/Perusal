package com.person;
import java.sql.*;
import com.connection.DBConnection;
public class Person {

	public void AddPerson(String username, String password, String role) {
		try {
		Connection con=DBConnection.getConection();
		String query="INSERT INTO person (`Name`, `password`, `role`) VALUES (?, ?, ?); ";
		PreparedStatement ps= con.prepareStatement(query);
		ps.setString(1,username);
		ps.setString(2,password);
		ps.setString(3,role);
		ps.executeUpdate();
		}
		catch(Exception  e)
		{
			e.printStackTrace();
		}		
	}
	public static void main(String args[])
	{
		Person p = new Person();
		p.AddPerson("t1", "123", "a");
	}
	
}
