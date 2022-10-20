package com.jdbc.json.imp.emp;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import com.jdbc.csv.empl.impo.Employee;

public class JSONGenerator {
public void generateJSONFile( List<com.jdbc.json.imp.emp.Employee> emplDataList, String jsonFilePath) throws IOException {
		
		
		FileOutputStream fos = null;
		
		DataOutputStream dos = null;
		
		
		try
		{
		
			File filePath = new File(jsonFilePath);
			
			fos = new FileOutputStream(filePath);
			
			dos = new DataOutputStream(fos);			
			
			
			Iterator<com.jdbc.json.imp.emp.Employee> iterator = emplDataList.iterator();
			
			StringBuffer buffer = new StringBuffer();
			
			buffer.append("[");
			
			while(iterator.hasNext())
			{	
				com.jdbc.json.imp.emp.Employee employee = iterator.next();
				
				ObjectMapper mapper = new ObjectMapper();
				
			      //Converting the Object to JSONString
			    String jsonString = mapper.writeValueAsString(employee);	
			     
			     buffer.append(jsonString+",");
			     
			     		
			}
			
			buffer.setLength(buffer.length()-1);
			
			buffer.append("]");
			
			dos.writeBytes( buffer.toString() );	
			
			dos.close();
			
			fos.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
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
