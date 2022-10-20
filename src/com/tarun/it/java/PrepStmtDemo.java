package com.tarun.it.java;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class PrepStmtDemo {

	public static void main(String[] args) throws SQLException{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tarun", "tarumani");
			PreparedStatement pst=con.prepareStatement("select * from DAV_School where Total_Marks=?");
			pst.setInt(1, Integer.parseInt(args[0]));
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				System.out.println(rs.getString("Name") +"\t");
				System.out.println(rs.getInt("Standard"+"\t"));
				System.out.println(rs.getInt("Roll_No"+"\t"));
				System.out.println(rs.getInt("Total_Marks"));
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
