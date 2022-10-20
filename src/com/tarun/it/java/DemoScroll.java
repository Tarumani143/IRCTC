package com.tarun.it.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DemoScroll {
public static void main(String[] args) {
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tarun", "tarumani");
		Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=stmt.executeQuery("Select name,roll_no,marks from student");
		rs.absolute(2);
		rs.updateInt(2, 3);
		rs.updateRow();
		System.out.println("one record updated successfully");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}
