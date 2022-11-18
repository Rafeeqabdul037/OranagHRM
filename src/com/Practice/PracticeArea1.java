package com.Practice;

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
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeArea1 
{
	
	public static void main(String[] args) throws IOException, InterruptedException
	{
		
		String ApplicationURLAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		//http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(ApplicationURLAddress);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Identify the Excel File
		FileInputStream file=new FileInputStream("./ExcelFiles/LoginWithMultipleDataSets.xlsx");
		
		//Identify the WorkBook in the Excel File
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		//Identity the Sheet in the WorkBook
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		int rowcount=sheet.getLastRowNum();
		
		for(int i=2;i<=rowcount;i++)
		{
			/*int cellcount=sheet.getRow(i).getLastCellNum();
			
			System.out.println(cellcount);*/
			Row row=sheet.getRow(i);
			String UserName=row.getCell(0).getStringCellValue();
			String PassWord=row.getCell(1).getStringCellValue();
				
			WebElement userName=driver.findElement(By.id("txtUsername"));
			userName.sendKeys(UserName);
			
			WebElement passWord=driver.findElement(By.id("txtPassword"));
			passWord.sendKeys(PassWord);
			
			WebElement logInBtn=driver.findElement(By.id( "btnLogin"));
			logInBtn.click();
		
			String ExpectedOHRMHomePageUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";
			System.out.println("The Expected Part of  OHRM Home Page Url Address is >>"+ExpectedOHRMHomePageUrlAddress);
			
			String ActualOHRMHomePageUrlAddress=driver.getCurrentUrl();
			System.out.println("The Actual OHRM Home Page Url Address is >>"+ActualOHRMHomePageUrlAddress);
			
			if(ActualOHRMHomePageUrlAddress.contains(ExpectedOHRMHomePageUrlAddress))
			{
				System.out.println("Login Successful >> PASS");
				
				row=sheet.getRow(i);
				
				//Create Cell in the Row
				Cell cell=row.createCell(2);
				
				//Setting value in to the Row of a Cell
				cell.setCellValue("PASS");
				
				WebElement WelcomeAdminElement = driver.findElement(By.id("welcome"));
				WelcomeAdminElement.click();
						
				// Logout Validation
						
				//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/auth/logout">Logout</a>
				WebElement logOut = driver.findElement(By.linkText("Logout"));
				logOut.click();
				System.out.println("Log out Successful - PASS");
			}
			else
			{
				row=sheet.getRow(i);
				
				//Create Cell in the Row
				Cell cell=row.createCell(2);
				
				//Setting value in to the Row of a Cell
				cell.setCellValue("FAIL");
				
				
				String ScreenShot="TestCase";
				
				File OUScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				
				FileUtils.copyFile(OUScreenShot, new File("./ScreenShots/Login_"+ScreenShot+"_"+i+".png"));
				
				InputStream inputStream1 = PracticeArea1.class.getClassLoader().getResourceAsStream("./ScreenShots/Login_\"+ScreenShot+\"_\"+i+\".png");
				
				byte[] inputImageBytes1 = IOUtils.toByteArray(inputStream1);
				
				int loginFailedSS= workbook.addPicture(inputImageBytes1, Workbook.PICTURE_TYPE_PNG);
				
				XSSFDrawing drawing = (XSSFDrawing) sheet.createDrawingPatriarch();
				
				XSSFClientAnchor loginFail= new XSSFClientAnchor();
				
				/*loginFail.setCol1(5);
				loginFail.setCol2(6);
				loginFail.setRow1(5);
				loginFail.setRow2(6);*/
				
				row=sheet.getRow(i);
				
				//Create Cell in the Row
				cell=row.createCell(3);
				
				//Setting value in to the Row of a Cell
				cell.setCellValue(loginFailedSS);
				
				
				
				drawing.createPicture(loginFail, loginFailedSS);
				
				for (int k= 0; k<i; k++) 
				{
				    sheet.autoSizeColumn(k);
				}
				
				
				
				
				row=sheet.getRow(i);
				
				//Create Cell in the Row
				cell=row.createCell(3);
				
				//Setting value in to the Row of a Cell
				cell.setCellValue(loginFailedSS);
				
				System.out.println("Login Unsuccessful >> FAIL ");
			}
			System.out.println("********");
			
			/*driver.navigate().back();
			
			driver.findElement(By.id("txtUsername")).clear();
			
			driver.findElement(By.id("txtPassword")).clear();*/
		}
				
		FileOutputStream file1=new FileOutputStream("./ExcelFiles/LoginWithMultipleDataSets.xlsx");
		workbook.write(file1);
	}

}
