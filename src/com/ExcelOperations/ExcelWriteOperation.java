package com.ExcelOperations;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriteOperation 
{
	public static void main(String[] args) throws IOException
	{
		
		//Identify the Excel File
		FileInputStream file=new FileInputStream("./ExcelFiles/WriteData.xlsx");
		
		//Identify the WorkBook in the Excel File
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		//Identity the Sheet in the WorkBook
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		//Create Row in the Sheet
		Row row=sheet.createRow(1);
		
		//Create Cell in the Row
		Cell cell=row.createCell(2);
		
		//Setting value in to the Row of a Cell
		cell.setCellValue("Selenium");
		
		//Saving the Excel file
		FileOutputStream file1=new FileOutputStream("./ExcelFiles/WriteData.xlsx");
		workbook.write(file1);
		//workbook.close();
	}
}
