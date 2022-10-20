package com.tarun.it.java;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcOracleDb {
public static void main(String[] args) throws Exception {
	Connection con=null;
	Statement stmt=null;
	try
	{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Loaded");
		con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tarun","tarumani");
		System.out.println("Connection Established");
		stmt=con.createStatement();
		String sqlQuery="Select * from emp";
		ResultSet rs=stmt.executeQuery(sqlQuery);
		while(rs.next())
		{
			int eno=rs.getInt("EMPNO");
			String ename=rs.getString("ENAME");
			String job=rs.getString("JOB");
			int mgr=rs.getInt("MGR");
			Date hiredate=rs.getDate("HIREDATE");
			double salary=rs.getDouble("SAL");
			float commision=rs.getFloat("COMM");
			int deptno=rs.getInt("DEPTNO");
			System.out.println(eno+"\t"+ename+"\t"+job+"\t"+mgr+"\t"+hiredate+"\t"+salary+"\t"+commision+"\t"+deptno);
			
		}
		stmt.close();
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
