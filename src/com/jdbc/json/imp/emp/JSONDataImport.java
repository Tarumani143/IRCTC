package com.jdbc.json.imp.emp;

import java.util.List;




public class JSONDataImport {
public static void main(String[] args) {
	if( args.length!=1)
	{
		System.out.println("missing output file");
		
		System.exit(0);
	}
	
	String jsonFilePath = args[0];
	
	try
	{
		
		DataImport dataImport = new DataImport();			
		
		List<Employee> emplDataList =  dataImport.importEmplData();
		
		
		JSONGenerator generator = new JSONGenerator();
		
		generator.generateJSONFile(emplDataList, jsonFilePath);
		
		System.out.println("Successfully JSON file generated at "+jsonFilePath);	
		
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
}


}



