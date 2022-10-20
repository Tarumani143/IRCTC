package com.tarun.it.java;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class SelectByFieldsAliasNameOrderChange {
public static void main(String[] args) throws SQLException{
	Connection con=null;
	Statement st=null;
	try{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tarun", "tarumani");
	
	 st=con.createStatement();
		ResultSet rs=st.executeQuery("select EMPNO as eno,ENAME as name,MGR as mgrid,JOB as role,SAL as salary, HIREDATE as hdate, COMM as commission,DEPTNO as dno  from emp");
		
		while(rs.next())
		{
			int EMPNO=rs.getInt("eno");
			String ENAME=rs.getString("name");
			double SAL=rs.getDouble("salary");
			int MGR=rs.getInt("mgrid");
			String JOB=rs.getString("role");
			
			Date HIREDATE=rs.getDate("hdate");
			int COMM=rs.getInt("commission");
			int DEPTNO=rs.getInt("dno");
			System.out.println(EMPNO+"\t"+ENAME+"\t"+MGR+"\t"+JOB+"\t"+SAL+"\t"+HIREDATE+"\t"+COMM+"\t"+DEPTNO);
			
			
			
					}
	}
		catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(con !=null)
		{
			st.close();
			con.close();
		}
	}
	}
}
