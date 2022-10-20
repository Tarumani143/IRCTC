package com.jdbc.json.imp.emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataImport extends JSONDataImport {
	public List<Employee> importEmplData() throws SQLException
	{
		Connection con = null;
		
		PreparedStatement pst = null;
		
		List<Employee> list = null;
		
		
		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tarumani","root", "root");
			
			pst = con.prepareStatement("select * from empl");
			
			ResultSet rs = pst.executeQuery();
			
			list = new ArrayList<Employee>();
			
			while( rs.next() )
			{
				Employee employee = new Employee();
				
				employee.setEno( rs.getInt(1) );
				
				employee.setEname(rs.getString(2));
				
				employee.setEadd(rs.getString(3));
				
				employee.setEdept(rs.getString(4));
				
				employee.setEsal(rs.getDouble(7));
				
				employee.setEpost(rs.getString(6));

				employee.setEage(rs.getInt(4));
				
				
				list.add(employee);	
				
			}
			
			pst.close();
			
			con.close();	
			
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
		finally
		{
			if( pst!=null)
			{
				pst.close();
			}
			
			if(con!=null)
			{
				con.close();
			}
		}
		return list;
		
	}

}


