package com.OHRMApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ExportEmployeeListToExcel
{
	public static void main(String[] args) throws IOException
	{
		String ApplicationURLAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(ApplicationURLAddress);
		driver.manage().window().maximize();
		
		
		
		WebElement password=driver.findElement(By.id("txtUsername"));
		password.sendKeys("Admin");
		
		WebElement logIn=driver.findElement(By.id("txtPassword"));
		logIn.sendKeys("AdminRafeeq@123");
		
		WebElement logInBtn=driver.findElement(By.id( "btnLogin"));
		logInBtn.click();
	
		WebElement PIMElement = driver.findElement(By.id("menu_pim_viewPimModule"));
		
		Actions action=new Actions(driver);
		action.moveToElement(PIMElement).build().perform();
		
		
		//Finding  and Clicking on Add Employee
		
		//Properties of Add Emplyee
		//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/pim/addEmployee" id="menu_pim_addEmployee">Add Employee</a>
		
		WebElement AddEmployee = driver.findElement(By.id("menu_pim_viewEmployeeList"));
		AddEmployee.click();
		
		
		
		
		FileInputStream file=new FileInputStream("./ExcelFiles/EmployeeList.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
	
		WebElement webTableElement=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form"));
				
		List<WebElement>tableRows=webTableElement.findElements(By.tagName("tr"));
					
		for(int i=0;i<=tableRows.size();i++)
		{
			Row row=sheet.createRow(i);
			List<WebElement>tableRowOfCells=tableRows.get(i).findElements(By.tagName("td"));
					
			for(int j=0;j<tableRowOfCells.size();j++)
			{
				Cell cell=row.createCell(j);
				String tableData=tableRowOfCells.get(j).getText();
				cell.setCellValue(tableData);
				
				System.out.print(tableData+" ");
		
				FileOutputStream file1=new FileOutputStream("./ExcelFiles/EmployeeList.xlsx");
				workbook.write(file1);
			}
			System.out.println();
		}
		driver.quit();
	}

}
