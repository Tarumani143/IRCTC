package com.tarun.it.java;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.*;

public class Student_Detail_Insert {

	public static void main(String[] args) {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tarun", "tarumani");
			PreparedStatement pst=con.prepareStatement("insert into student values(?,?,?)");
			pst.setString(1, args[0]);
			pst.setInt(2, Integer.parseInt(args[1]));
			pst.setInt(3, Integer.parseInt(args[2]));
			System.out.println("one record insert sucessfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
