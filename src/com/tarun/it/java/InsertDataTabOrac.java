package com.tarun.it.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDataTabOrac {
public static void main(String[] args) throws SQLException {
	
	Connection con=null;
	Statement stmt=null;
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tarun", "tarumani");
		System.out.println("Connection Established Sucessfully");
		stmt=con.createStatement();
		stmt.executeUpdate("insert into DAV_School values('Tiru',9,245,455)");
		System.out.println("One record inserted into the table");
		con.close();
		stmt.close();
	}
	catch(Exception e)
	{
		System.err.println(e);
	}
	finally
	{
		if(con!=null)
		{
			con.close();
		}
	}
}

}
