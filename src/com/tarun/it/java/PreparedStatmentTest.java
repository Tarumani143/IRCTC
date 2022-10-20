package com.tarun.it.java;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.*;
public class PreparedStatmentTest {
	
	public static void main(String[] args) throws SQLException{
		Connection con=null;
		
		try{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tarun", "root", "root");
			PreparedStatement pst=con.prepareStatement("insert into Emp values(?,?,?,?,?,?,?,?)");
			pst.setInt(1,7688);//1 specifies the first parameter in the query  
			pst.setString(2,"Ratan");  
			pst.setString(3,"Peon");
			pst.setInt(4,7855);
			pst.setDate(5, null);
			pst.setDouble(6,10000.00);
			pst.setInt(7,500);
			pst.setInt(8,33);
			
			  
			int i=pst.executeUpdate();  
			System.out.println(i+" records inserted");  
		
			
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
	

