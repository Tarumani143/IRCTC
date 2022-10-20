package com.tarun.it.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class MySqlJdbcCurdOprTest {
public static void main(String[] args) throws Exception {
	Connection con=null;
	
	try
	{
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tarun", "root", "root");
	Statement	stmt=con.createStatement();

		String insertQuery = "insert into student values(106,'scott','male',28,'SBM',11,333.33)";

		

		System.out.println(" rows were inserted ");
		
		String updateQuery = "update student set marks=marks+50.00 where ename='mani'";

		int n=stmt.executeUpdate(updateQuery);

		System.out.println(n+" rows were updated ");

		String deleteQuery = "delete from student";

		n=stmt.executeUpdate(deleteQuery);

		System.out.println(n+" rows were deleted ");



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
