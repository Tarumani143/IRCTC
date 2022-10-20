package com.jdbc.excel.export;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;

public class DataLoader {
	public int exportData(List<Employee> empDataList)
	{
		
		Connection con = null;
		
		int count = 0;
		
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tarumani", "root", "root");
			
			PreparedStatement pst = con.prepareStatement("INSERT INTO empl VALUES(?,?,?,?,?,?,?)");
			
			Iterator<Employee> iterator = empDataList.iterator();
			
			
			while( iterator.hasNext() )
			{
				Employee empl = iterator.next();
				
				pst.setInt(1, empl.getEno());
				
				pst.setString(2, empl.getEname());
				
				pst.setString(3, empl.getEadd());	
				
				pst.setInt(4, empl.getEage());
				
				pst.setString(5, empl.getEdept());
				
				pst.setString(6, empl.getEpost());
				
				pst.setDouble(7, empl.getEsal());
				
				pst.executeUpdate();
				
				count++;
				
			}
			
			pst.close();
			
			con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return count;
	}


}
 