package com.jdbc.csv.empl.impo;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbGenerateCSVFile {
	public static void main(String[] args) throws SQLException, IOException {

		
		Connection con=null;
		
		FileOutputStream fos=null;
		
		DataOutputStream dos=null;

if(args.length!=1){
			
			System.out.println("Missing output file ");
			
			System.exit(0);
		}
		
		try 
		{
			File outputPath = new File(args[0]);
			
			fos = new FileOutputStream(outputPath);
			
			dos = new DataOutputStream(fos);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
				
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tarumani", "root", "root");

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM empl");

			ResultSet rs = stmt.executeQuery();

			while ( rs.next() ) 
			{
				String record = rs.getInt(1) + "," +
						rs.getString(2) + "," +
						rs.getString(3) + "," +
						rs.getInt(4) + "," +
						rs.getString(5) + "," +
						rs.getString(6) + "," +
						rs.getDouble(7);
				
				dos.writeBytes(record+"\n");
				
			}
			
			fos.close();
			dos.close();
			con.close();
			
			System.out.println("Generated CSV file successfully ");

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
		    	if(con!=null)
		    	{
		    		con.close();
		    	}
		    	if(dos!=null)
		    	{
		    		dos.close();
		    	}
		    	if(fos!=null)
		    	{
		    		fos.close();
		    	}
		}
		
	}

}


