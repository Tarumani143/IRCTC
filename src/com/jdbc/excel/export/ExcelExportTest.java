package com.jdbc.excel.export;

import java.io.IOException;
import java.util.List;

public class ExcelExportTest {
public static void main(String[] args) throws IOException {
		
		if( args.length!=1)
		{
			System.out.println("Missing input Excel file");
			
			System.exit(0);
		}
	try
	{
		String excelFilePath = args[0];
		
		ExcelParser parser  = new ExcelParser();
		
		List<Employee> emplDataList = parser.parseExcelData(excelFilePath);
		
		DataLoader loader = new DataLoader();
		
		int count = loader.exportData(emplDataList);
		
		System.out.println(count+" Records Exported Successfully");
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}		
		
	}

}
