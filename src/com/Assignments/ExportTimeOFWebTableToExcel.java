package com.Assignments;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExportTimeOFWebTableToExcel 
{
	public static void main(String[] args) throws IOException
	{
		String ApplicationURLAddress="https://www.timeanddate.com/worldclock/";
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(ApplicationURLAddress);
		driver.manage().window().maximize();
		
		FileInputStream file=new FileInputStream("./ExcelFiles/WorldTime.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		//int rowcount=sheet.getLastRowNum();
		
		for(int i=1;i<=36;i++)
		{
			//int cellcount=sheet.getRow(i).getLastCellNum();
			for(int j=1;j<=8;j++)
			{
				
				// /html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]
				
				// "/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr["+i+"]/td["+j+"]"
				WebElement webTableElement=driver.findElement(By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr["+i+"]/td["+j+"]"));
				String cityName=webTableElement.getText();
				
				Row row=sheet.createRow(i);
				Cell cell=row.createCell(j);
				cell.setCellValue(cityName);
				
				FileOutputStream file1=new FileOutputStream("./ExcelFiles/WorldTime.xlsx");
				workbook.write(file1);
				
				System.out.print(cityName+" ");			
			}
			System.out.println();
		}
		driver.close();
		
	}

}
