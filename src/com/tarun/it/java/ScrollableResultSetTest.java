package com.tarun.it.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollableResultSetTest {
public static void main(String[] args) throws SQLException {
	Connection con=null;
	try
	{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tarun", "root", "root");
		Statement stmt=con.createStatement(
		ResultSet.TYPE_SCROLL_INSENSITIVE,
		ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = stmt.executeQuery("Select * from employee");
		if(rs.first()){
			
			System.out.println("First Record");
			
			System.out.println(
					rs.getInt(1) + "\t" +
					rs.getString(2) + "\t" +
					rs.getDouble(3) + "\t" +
					rs.getString(4) + "\t" +
					rs.getString(5) + "\t" +
					rs.getInt(6)
					);
		}
		else
		{
			System.out.println("empty result, no rows found");
		}
		
		if(rs.last()){
			
			System.out.println("Last Record");
			
			System.out.println(
					rs.getInt(1) + "\t" +
					rs.getString(2) + "\t" +
					rs.getDouble(3) + "\t" +
					rs.getString(4) + "\t" +
					rs.getString(5) + "\t" +
					rs.getInt(6)
					);
		}
		else
		{
			System.out.println("empty result, no rows found");
		}
		
		if(rs.absolute(5)){
			
			System.out.println("Fifth Record");
			
			System.out.println(
					rs.getInt(1) + "\t" +
					rs.getString(2) + "\t" +
					rs.getDouble(3) + "\t" +
					rs.getString(4) + "\t" +
					rs.getString(5) + "\t" +
					rs.getInt(6)
					);
		}
		else
		{
			System.out.println("no Fift record");
		}
		
		if(rs.absolute(5)){
			
			System.out.println("Fifth Record");
			
			System.out.println(
					rs.getInt(1) + "\t" +
					rs.getString(2) + "\t" +
					rs.getDouble(3) + "\t" +
					rs.getString(4) + "\t" +
					rs.getString(5) + "\t" +
					rs.getInt(6)
					);
		}
		else
		{
			System.out.println("no Fifth record");
		}
		
		if(rs.relative(-2)){
			
			System.out.println("Third Record");
			
			System.out.println(
					rs.getInt(1) + "\t" +
					rs.getString(2) + "\t" +
					rs.getDouble(3) + "\t" +
					rs.getString(4) + "\t" +
					rs.getString(5) + "\t" +
					rs.getInt(6)
					);
		}
		else
		{
			System.out.println("no third record");
		}
		
		if(rs.relative(3)){
			
			System.out.println("Sixth Record");
			
			System.out.println(
					rs.getInt(1) + "\t" +
					rs.getString(2) + "\t" +
					rs.getDouble(3) + "\t" +
					rs.getString(4) + "\t" +
					rs.getString(5) + "\t" +
					rs.getInt(6)
					);
		}
		else
		{
			System.out.println("no sixth record");
		}
		
		if(rs.next()){
			
			System.out.println("Next Record");
			
			System.out.println(
					rs.getInt(1) + "\t" +
					rs.getString(2) + "\t" +
					rs.getDouble(3) + "\t" +
					rs.getString(4) + "\t" +
					rs.getString(5) + "\t" +
					rs.getInt(6)
					);
		}
		else
		{
			System.out.println("Next record not found");
		}
		
		if(rs.previous()){
			
			System.out.println("Previous Record");
			
			System.out.println(
					rs.getInt(1) + "\t" +
					rs.getString(2) + "\t" +
					rs.getDouble(3) + "\t" +
					rs.getString(4) + "\t" +
					rs.getString(5) + "\t" +
					rs.getInt(6)
					);
		}
		else
		{
			System.out.println("Previous record not found");
		}
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
