package com.jdbc.csv.emp.impor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;
public class CSVFileExportTest {
public static void main(String[] args) throws Exception {
	if(args.length !=1)
	{
		System.out.println("Missing file input");
		System.exit(0);
	}
	String csvFilePath=args[0];
	Connection con=null;
	PreparedStatement pst=null;
	try{
		CSVFileParser parser=new CSVFileParser();
		List <Employee>emplDataList=parser.parseCSVData (csvFilePath);
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tarumani","root","root");
		pst=con.prepareStatement("INSERT INTO empl values (?,?,?,?,?,?,?)");
		Iterator<Employee> iterator=emplDataList.iterator();
		int count=0;
		while(iterator.hasNext())
		{
			Employee empl=iterator.next();
			pst.setInt(1, empl.getEno());
			pst.setString(2,empl.getEname()) ;
			pst.setString(3,empl.getEadd());
			pst.setInt(4, empl.getEage());
			pst.setString(5,empl.getEdept());
			pst.setString(6, empl.getEpost());
			pst.setDouble(7, empl.getEsal());
			pst.executeUpdate();
			count++;
		}
		System.out.println(count+ "records exported");
		pst.close();
		con.close();
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(pst!=null)
		{
			pst.close();
		}
		if(con!=null)
		{
			con.close();
		}
	}
	 
	 
	
}    
}
