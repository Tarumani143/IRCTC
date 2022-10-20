package com.tarun.it.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;



public class JdbcMysqlDbTest {
public static void main(String[] args) throws Exception{
	Connection con=null;
	Statement stmt=null;
	try
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	System.out.println("Class Loaded");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tarun", "root", "root");
	System.out.println("Connection Established");
	stmt=con.createStatement();
		//Statement Created
	String sqlQuery = "select *  from student";
	
	ResultSet rs = stmt.executeQuery(sqlQuery);
	while(rs.next())
	{
		int stdno=rs.getInt(1);
		String ename=rs.getString(2);
		String gender=rs.getString(3);
		int age=rs.getInt(4);
		String school=rs.getString(5);
		int Class=rs.getInt(6);
		float marks=rs.getFloat(7);
		System.out.println(stdno+"\t"+ename+"\t"+gender+"\t"+age+"\t"+school+"\t"+Class+"\t"+marks);
		
		
	}
		stmt.close();
		con.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
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
