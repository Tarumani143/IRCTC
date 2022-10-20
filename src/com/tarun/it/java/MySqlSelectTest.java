package com.tarun.it.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class MySqlSelectTest {
public static void main(String[] args) throws Exception  {
	Connection con=null;
	Statement st=null;
	try
	{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tarun", "root", "root");
		st=con.createStatement();
		String sqlQuery="select * from student";
		ResultSet rs=st.executeQuery(sqlQuery);
		while(rs.next())
		{
			System.out.println(rs.getInt(1) + "\t" +
					rs.getString(2) + "\t" +
					rs.getString(3) + "\t" +
					rs.getInt(4) + "\t" +
					rs.getString(5) + "\t" +
					rs.getInt(6) +"\t"+
					rs.getFloat(7)
					);

		}
		con.close();
		st.close();
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(con !=null)	
		{
			con.close();
		}
	
	}
}
}
