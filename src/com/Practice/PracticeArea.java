package com.Practice;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PracticeArea 
{
	
	public static void main(String[] args) throws IOException
	{
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Avengers");
		Row row0 = sheet.createRow(0);
		row0.createCell(0).setCellValue("IRON-MAN");
		Row row1 = sheet.createRow(1);
		row1.createCell(0).setCellValue("SPIDER-MAN");
		
		
		InputStream inputStream1 = new BufferedInputStream(new FileInputStream("C:\\Users\\Abdul Rafeeq\\OneDrive\\Desktop\\ironman.png"));
		InputStream inputStream2 = new BufferedInputStream(new FileInputStream("C:\\Users\\Abdul Rafeeq\\OneDrive\\Desktop\\spiderman.png"));
		
	//	InputStream inputStream1 = PracticeArea.class.getClassLoader().getResourceAsStream("C:\\Users\\Abdul Rafeeq\\OneDrive\\Desktop\\ironman.png");
	//	InputStream inputStream2 = PracticeArea.class.getClassLoader().getResourceAsStream("C:\\Users\\Abdul Rafeeq\\OneDrive\\Desktop\\spiderman.png");
		
			
			byte[] inputImageBytes1 = IOUtils.toByteArray(inputStream1);
			byte[] inputImageBytes2 = IOUtils.toByteArray(inputStream2);
			
			
			int inputImagePictureID1 = workbook.addPicture(inputImageBytes1, Workbook.PICTURE_TYPE_PNG);
			int inputImagePictureID2 = workbook.addPicture(inputImageBytes2, Workbook.PICTURE_TYPE_PNG);
			
			
			
			XSSFDrawing drawing = (XSSFDrawing) sheet.createDrawingPatriarch();
			
			
			XSSFClientAnchor ironManAnchor = new XSSFClientAnchor();
			XSSFClientAnchor spiderManAnchor = new XSSFClientAnchor();
			
			
			ironManAnchor.setCol1(1); // Sets the column (0 based) of the first cell.
			ironManAnchor.setCol2(2); // Sets the column (0 based) of the Second cell.
			ironManAnchor.setRow1(0); // Sets the row (0 based) of the first cell.
			ironManAnchor.setRow2(1); // Sets the row (0 based) of the Second cell.
			
			
			spiderManAnchor.setCol1(1);
			spiderManAnchor.setCol2(2);
			spiderManAnchor.setRow1(1);
			spiderManAnchor.setRow2(2);
			
			
			
			drawing.createPicture(ironManAnchor, inputImagePictureID1);
			drawing.createPicture(spiderManAnchor, inputImagePictureID2);
			
			
			for (int i = 0; i < 3; i++) 
			{
			    sheet.autoSizeColumn(i);
			}
			
			
			try (FileOutputStream saveExcel = new FileOutputStream("./ExcelFiles/ImageExport.xlsx")) {
			    workbook.write(saveExcel);
		}
	}
}
