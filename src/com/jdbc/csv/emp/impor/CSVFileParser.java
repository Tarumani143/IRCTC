package com.jdbc.csv.emp.impor;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFileParser {

	public List<Employee> parseCSVData(String csvFilePath) throws IOException {
		File FilePath=new File(csvFilePath);
		FileInputStream fis=null;
		DataInputStream dis=null;
		List<Employee > list=null;
		try{
			 list=new ArrayList<Employee>();  
			fis= new FileInputStream(FilePath);
			dis = new DataInputStream(fis);
			String record=dis.readLine();
			while(record!=null &&record.isEmpty())
			{
				String [] fields=record.split(",");
				Employee emplo=new Employee();
				emplo.setEno(Integer.parseInt (fields[0]));
				emplo.setEname(fields[1]);
				emplo.setEadd(fields[2]);
				emplo.setEage(Integer.parseInt (fields[3]));
				emplo.setEdept(fields[4]);
				emplo.setEpost(fields[5]);
				emplo.setEsal(Double.parseDouble(fields[6]));
				list.add(emplo);
			}
			fis.close();
			dis.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(dis!=null)
			{
				dis.close();
			}
			if(fis!=null)
			{
				fis.close();
			}
				
		}
		return list;
	}

}
