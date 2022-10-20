package com.tarun.it.java;
import java.sql.*;
public class PrepStatement {
public static void main(String[] args) {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tarun", "tarumani");
		PreparedStatement pst=con.prepareStatement("insert into DAV_School values (?,?,?,?)");
		pst.setString(1,"Milli");
		pst.setInt(2, 8);
		pst.setInt(3, 246);
		pst.setInt(4, 400);
		int i=pst.executeUpdate();  
		System.out.println("One Record inserted Sucessfully");
		con.close();
	} catch (Exception e) {
		
		e.printStackTrace();
	}
}
}
