package com.tarun.it.java;
import java.sql.*;
public class CSDemo {
public static void main(String[] args) {
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tarun","tarumani");
		CallableStatement cs=con.prepareCall("{call insertpro(?,?,?)}");
		cs.setString(1, args[0]);
			cs.setInt(2,Integer.parseInt(args[1]));
				cs.setInt(3,Integer.parseInt(args[2]));
	
cs.execute();
		System.out.println("One Record inserted sucessfully");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}
