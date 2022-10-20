package com.tarun.it.java;
import java.sql.*;
public class MoveCurserDemo {
public static void main(String[] args) {
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tarun","tarumani");
		System.out.println("Connection established"); 
		
		Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=stmt.executeQuery("select * from DAV_School");
		rs.absolute(5);
		System.out.print(rs.getString("name")+"\t");
		System.out.print(rs.getInt("standard")+"\t");
		System.out.print(rs.getInt("Roll_No")+"\t");
		System.out.println(rs.getInt("Total_Marks"));
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}
