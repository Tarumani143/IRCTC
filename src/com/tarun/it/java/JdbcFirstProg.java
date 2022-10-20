package com.tarun.it.java;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcFirstProg {
public static void main(String[] args) throws Exception{
	Connection con=null;
	Statement stmt=null;
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tarun", "tarumani");
		System.out.println("Connection Established");
		stmt=con.createStatement();
		stmt.execute("create table DAV_School(name varchar2(30),standard number(2),Roll_No number(10),Total_Marks number (3))");
	System.out.println("Table Created Sucessfully");
	
	con.close();
	stmt.close();
	}
	
	catch (Exception e)
	{
		System.err.print(e);
	}
}
}
