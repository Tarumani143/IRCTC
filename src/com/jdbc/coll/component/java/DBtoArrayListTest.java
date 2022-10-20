//Example to read data from database table, convert into Java Object ( Employee ) and load into Collection Component(ArrayList)

package com.jdbc.coll.component.java;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
public class DBtoArrayListTest {
public static void main(String[] args) throws SQLException ,IOException{
	Connection con=null;
	ArrayList<Employee> empRecordList = null;
	try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tarun", "root", "root");
	PreparedStatement pst=con.prepareStatement("select *from emp");
	ResultSet rs=pst.executeQuery();
	empRecordList = new ArrayList<Employee>();
	while(rs.next())
	{
		Employee empl = new Employee();
		
		empl.setEmpno(rs.getInt(1));
		
		empl.setEname(rs.getString(2));
		
		empl.setJob(rs.getString(3));
		
		empl.setMgr(rs.getInt(4));
		
		empl.setHiredate(rs.getDate(5));
		
		empl.setSal(rs.getDouble(6));
		empl.setComm(rs.getDouble(7));
		empl.setDeptno(rs.getInt(8));
		
		empRecordList.add(empl);
		

	}
	con.close();
	System.out.println("Loaded into Array List Successfully ");
	
	System.out.println("ArrayList Records are ");

	
	Iterator<Employee> iterator = empRecordList.iterator();
	
	while(iterator.hasNext()){
		
		Employee empl = iterator.next();
		
		System.out.println(
							empl.getEmpno()+","+
		
							empl.getEname()+","+
							
							empl.getJob()+","+
							
							empl.getMgr()+","+
							
							empl.getHiredate()+","+
							
							empl.getSal()+","+
							empl.getComm()+","+
							empl.getDeptno()
							
							);
	//	System.out.println("Record");
	}

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
