package com.jdbc.excel.export;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class ExcelParser {
	public List<Employee> parseExcelData(String excelFilePath) throws IOException
	{										
		
		FileInputStream fis = null;
		
		DataInputStream dis = null;
		
		List<Employee> list = null;
		
		XSSFWorkbook workBook = null;
		
		
		
		try
		{
			
			list = new ArrayList<Employee>();
			
			File filePath = new File(excelFilePath);
			
			fis = new FileInputStream(excelFilePath);
			
			dis = new DataInputStream(fis);
			
			workBook = new XSSFWorkbook(dis);
			
			XSSFSheet sheet  = workBook.getSheetAt(0);
			
			Iterator<Row> rowIterator = sheet.rowIterator();			
			
			while( rowIterator.hasNext() )
			{		
				
				Row row = rowIterator.next();
			
				Cell cell = row.getCell(0);
				
				int emplEno = (int) cell.getNumericCellValue();
				
				
				cell = row.getCell(1);
				
				String emplEname = cell.getStringCellValue();
				
				
				cell = row.getCell(2);
				
				String emplEadd = cell.getStringCellValue();
				
				
				cell = row.getCell(3);
				
				int emplEage =(int) cell.getNumericCellValue();
				
				
				cell = row.getCell(4);
				
				String emplEdept = cell.getStringCellValue();
				
				
				cell = row.getCell(5);
				
				String emplEpost = cell.getStringCellValue();
				
				
				cell = row.getCell(6); 
				
				double emplEsal = (double) cell.getNumericCellValue();
				
				Employee employee = new Employee();
				
				employee.setEno(emplEno);
				
				employee.setEname(emplEname);
				
				employee.setEadd(emplEadd);
				
				employee.setEage(emplEage);
				
				employee.setEdept(emplEdept);
				
				employee.setEpost(emplEpost);
				
				employee.setEsal(emplEsal);
				
				list.add(employee);
			}
			
			workBook.close();
			
			dis.close();
			
			fis.close();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(workBook!=null)
			{				
				workBook.close();
			}
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
