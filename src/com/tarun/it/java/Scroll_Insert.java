package com.tarun.it.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.*;

public class Scroll_Insert {

	public static void main(String[] args) {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tarun","tarumani");
			Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=stmt.executeQuery("Select name,roll_no,marks from student");
			rs.moveToInsertRow();
			rs.updateString(1, "tiru");
			rs.updateInt(2, 3);
			rs.updateInt(3,500);
			rs.insertRow();
			System.out.println("one record insert successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
