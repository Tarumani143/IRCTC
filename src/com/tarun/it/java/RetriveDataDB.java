package com.tarun.it.java;
import java.sql.*;
public class RetriveDataDB {
public static void main(String[] args) throws SQLException {
	try
	{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tarun", "tarumani");
	System.out.println("connection");
	Statement stmt=con.createStatement();
	ResultSet rs=stmt.executeQuery("Select * from DAV_School");
	ResultSetMetaData rm=rs.getMetaData();
	int n=rm.getColumnCount();
	for(int i=1;i<=n;i++)
	{
		System.out.println(rm.getColumnClassName(i)+"\t");
	}
	System.out.println();
	while(rs.next())
		{
		System.out.println (rs.getString(1));
		System.out.println (rs.getInt(2));
		System.out.println(rs.getInt(3));
		System.out.println(rs.getInt(4));
		}
	con.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}