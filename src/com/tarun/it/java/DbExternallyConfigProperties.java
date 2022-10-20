package com.tarun.it.java;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbExternallyConfigProperties {
public static void main(String[] args) throws SQLException {
	Connection con=null;
	

	try{

		
    	File filePath=new File(args[0]);
    	 FileReader freader = new FileReader(filePath);
    	 Properties dbProp = new Properties();
    	
    	 dbProp.load(freader);
    	freader.close(); 
    	
    	String driver = dbProp.getProperty("dbDriver");	
       	String host = dbProp.getProperty("dbHost");
    	String port=dbProp.getProperty("dbPort");	    		
       	String uid = dbProp.getProperty("dbUid");
        String passwd=dbProp.getProperty("dbPasswd");
        String name=dbProp.getProperty("dbName");
       	Class.forName(driver);
       	String url="jdbc:mysql://"+host+":"+port+"/"+name;
       	con = DriverManager.getConnection(url,uid,passwd);
       	Statement st = con.createStatement();
    	String sqlQuery="select * from emp";
    	ResultSet rs = st.executeQuery(sqlQuery);
    	while(rs.next())
    	{
    		System.out.println(
    		rs.getInt(1)+"\t"+
    		rs.getString(2)+"\t"+
    		rs.getString(3)+"\t"+
    		rs.getInt(4)+"\t"+
    		rs.getDate(5)+"\t"+
    		rs.getDouble(6)+"\t"+
    		rs.getDouble(7)+"\t"+
    		rs.getInt(8)
    		);
    	}

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
