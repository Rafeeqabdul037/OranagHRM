package com.Assignments;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.util.List;

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class ExportWebTableToExcelSheet 
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
			
			// /html/body/div[5]/section[1]/div/section/div[1]/div/table/thead/tr
			
			
			///html/body/div[5]/section[1]/div/section/div[1]/div/table/thead/tr/th
					
			// /html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]
					
			// "/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr["+i+"]/td["+j+"]"
			WebElement webTableElement=driver.findElement(By.xpath("/html/body/div[5]/section[1]/div"));
					
			List<WebElement>tableRows=webTableElement.findElements(By.tagName("tr"));
						
			for(int i=1;i<=tableRows.size();i++)
			{
				Row row=sheet.createRow(i);
				List<WebElement>tableRowOfCells=tableRows.get(i).findElements(By.tagName("td"));
						
				for(int j=0;j<tableRowOfCells.size();j++)
				{
					Cell cell=row.createCell(j);
					String tableData=tableRowOfCells.get(j).getText();
					cell.setCellValue(tableData);
					
					System.out.print(tableData+" ");
			
					FileOutputStream file1=new FileOutputStream("./ExcelFiles/WorldTime.xlsx");
					workbook.write(file1);
				}
				System.out.println();
			}
			driver.quit();
		}
	}