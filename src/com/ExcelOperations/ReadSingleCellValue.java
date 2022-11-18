package com.ExcelOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadSingleCellValue
{
	public static void main(String[] args) throws IOException
	{
		
		//Identify the Excel File
		FileInputStream file=new FileInputStream("./ExcelFiles/ReadData.xlsx");
		
		//Identify the WorkBook in the Excel File
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		//Identity the Sheet in the WorkBook
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		//Identify the Row in the Sheet
		Row r=sheet.getRow(0);
		
		//Identify the Cell in the Row
		Cell c=r.getCell(0);
		
		//Get the data from Row of the Cell
		String data=c.getStringCellValue();
		System.out.println(data);
	}

}
