package com.tarun.it.java;

import java.sql.*;
public class Demo1st_Jdbc {
public static void main(String[] args) throws Exception{
	try{
		//Jdbc Driver loaded
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tarun", "tarumani");
		Statement stmt=con.createStatement();
		stmt.execute("create table student(name varchar2(20),roll_no number(4),marks number(4))");
		System.out.println("Table created sucessfully");
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}
