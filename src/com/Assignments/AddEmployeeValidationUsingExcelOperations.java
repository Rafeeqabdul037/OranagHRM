package com.Assignments;

import java.io.FileInputStream;
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
import org.openqa.selenium.interactions.Actions;

public class AddEmployeeValidationUsingExcelOperations 
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
		
		//OHRM Main Page Title Validation
		
		String ExpectedOHRMMainPageTitle="OrangeHRM";
		System.out.println("The Expected Title of the OHRM Main Page is >>"+ExpectedOHRMMainPageTitle);
			
		String ActualOHRMMainPageTitle=driver.getTitle();
		System.out.println("The Actual Title of the OHRM Main Page is >> "+ActualOHRMMainPageTitle);
			
		if(ActualOHRMMainPageTitle.equals(ExpectedOHRMMainPageTitle))
		{
			System.out.println("Orange HRM Main Page Title Matched - PASS ");
		}
		else
		{
			System.out.println("Orange HRM Main Page Title Not Matched - FAIL ");
		}
		System.out.println("********");
				
		
		//Identify the Excel File
		FileInputStream file=new FileInputStream("./ExcelFiles/AddEmployee.xlsx");
		
		//Identify the WorkBook in the Excel File
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		//Identity the Sheet in the WorkBook
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		int rowcount=sheet.getLastRowNum();
		
		for(int i=2;i<=2;i++)
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
				
				row=sheet.getRow(2);
				
				//Create Cell in the Row
				Cell cell=row.createCell(10);
				
				//Setting value in to the Row of a Cell
				cell.setCellValue("PASS");
				
				//Saving the Excel file
				FileOutputStream file1=new FileOutputStream("./ExcelFiles/AddEmployee.xlsx");
				workbook.write(file1);
			}
			else
			{
				System.out.println("Login Unsuccessful >> FAIL ");
			}
			System.out.println("********");

		}
				
		WebElement PIMElement = driver.findElement(By.id("menu_pim_viewPimModule"));
				
		Actions action=new Actions(driver);
		action.moveToElement(PIMElement).build().perform();
		
				
		WebElement AddEmployee = driver.findElement(By.id("menu_pim_addEmployee"));
		AddEmployee.click();
				
		System.out.println("This is Add Empoyee Page");
		System.out.println("********");
				 
				
		
		//Entering Details into Add Employee
		
		sheet=workbook.getSheet("Sheet1");
		
		rowcount=sheet.getLastRowNum();
		
		for(int i=3;i<=3;i++)
		{
			//int cellcount=sheet.getRow(i).getLastCellNum();

				Row row=sheet.getRow(i);
				String FirstName=row.getCell(2).getStringCellValue();
				String MiddleName=row.getCell(3).getStringCellValue();
				String LastName=row.getCell(4).getStringCellValue();
				
				
				WebElement preEmpIDText=driver.findElement(By.id("employeeId"));
				String ExpectedpreEmpIDText=preEmpIDText.getAttribute("value");
				System.out.println("The Actual Pre Employee ID  is >> "+ExpectedpreEmpIDText);
				
				row=sheet.getRow(3);
				
				//Create Cell in the Row
				Cell cell=row.createCell(5);
				
				//Setting value in to the Row of a Cell
				cell.setCellValue(ExpectedpreEmpIDText);

				//Saving the Excel file
				FileOutputStream file1=new FileOutputStream("./ExcelFiles/AddEmployee.xlsx");
				workbook.write(file1);
				
				WebElement preFirstName=driver.findElement(By.id("firstName"));
				preFirstName.sendKeys(FirstName);
				
				WebElement preMiddleName=driver.findElement(By.id("middleName"));
				preMiddleName.sendKeys(MiddleName);
				
				WebElement preLastName=driver.findElement(By.id("lastName"));
				preLastName.sendKeys(LastName);
				
				WebElement saveBtn=driver.findElement(By.id( "btnSave"));
				saveBtn.click();
				
				Thread.sleep(1000);
				
				System.out.println("********");
				
				System.out.println("Employee details added Successfully - PASS");
				System.out.println("This is a Employee Details Page");
				
				System.out.println();
				
			
				
				//Post Middle Name Element Properties
				
				/*<input value="Abdul" type="text" name="personal[txtEmpMiddleName]" class="block default editable" maxlength="30" title="Middle Name"
				id="personal_txtEmpMiddleName" disabled="disabled">*/
				
				
				
				//Propreties of Post First Name
				/*<input value="Abdul" type="text" name="personal[txtEmpFirstName]" class="block default editable" maxlength="30" title="First Name
						id="personal_txtEmpFirstName" disabled="disabled">*/
					
				WebElement PostFirstName=driver.findElement(By.id("personal_txtEmpFirstName"));
				
				String ActualPostFirstNameText=PostFirstName.getAttribute("value");
				System.out.println("The Actual Post First Name  is >> "+ActualPostFirstNameText);
				
				String ExpectedPostFirstNameText=FirstName;
				System.out.println("The Expected Post First  Name is >> "+ExpectedPostFirstNameText);
				
				
				
				
				if(ActualPostFirstNameText.equals(ExpectedPostFirstNameText))
				{
					
					row=sheet.getRow(3);
					
					//Create Cell in the Row
					cell=row.createCell(6);
					
					//Setting value in to the Row of a Cell
					cell.setCellValue(ActualPostFirstNameText);
					
					cell=row.createCell(10);
					
					cell.setCellValue("PASS");
					//Saving the Excel file
					file1=new FileOutputStream("./ExcelFiles/AddEmployee.xlsx");
					workbook.write(file1);
					
					
					System.out.println("Post First Name Matched >> PASS");
				}
				else
				{
					System.out.println("Post First Name Not Matched >> FAIL");
				}
				System.out.println("********");
				
				//Validating Employee Middle Name
				/*<input value="" type="text" name="personal[txtEmpMiddleName]" class="block default editable" maxlength="30" title="Middle Name" 
				 * id="personal_txtEmpMiddleName" disabled="disabled">*/
				
				WebElement PostMiddleName=driver.findElement(By.id("personal_txtEmpMiddleName"));
				String ActualPostMiddleNameText=PostMiddleName.getAttribute("value");
				
				System.out.println("The Actual Post Middle Name  is >> "+ActualPostMiddleNameText);
				
				String ExpectedPostMiddleNameText=MiddleName;
				System.out.println("The Expected Post Middle  Name is >> "+ExpectedPostMiddleNameText);
				
				if(ActualPostMiddleNameText.equals(ExpectedPostMiddleNameText))
				{
					row=sheet.getRow(3);
					
					//Create Cell in the Row
					cell=row.createCell(7);
					
					//Setting value in to the Row of a Cell
					cell.setCellValue(ActualPostMiddleNameText);
					
					cell=row.createCell(11);
					
					cell.setCellValue("PASS");
					//Saving the Excel file
					file1=new FileOutputStream("./ExcelFiles/AddEmployee.xlsx");
					workbook.write(file1);
					
					
					System.out.println("Post Middle Name Matched >> PASS");
				}
				else
				{
					System.out.println("Post Middle Name Not Matched >> FAIL");
				}
				System.out.println("********");
				
				
				//Validating Post Employee Last Name
				
				/*<input value="Rafeeq" type="text" name="personal[txtEmpLastName]" class="block default editable" maxlength="30" title="Last Name"
				 id="personal_txtEmpLastName" disabled="disabled"> */
				
				WebElement PostLastName=driver.findElement(By.id("personal_txtEmpLastName"));
				String ActualPostLastNameText=PostLastName.getAttribute("value");
				
				System.out.println("The Actual Post Last Name is >> "+ActualPostLastNameText);
						
				String ExpectedPostLastNameText=LastName;
				System.out.println("The Expected Post Last Name is >> "+ExpectedPostLastNameText);
						
				if(ActualPostLastNameText.equals(ExpectedPostLastNameText))
				{
					row=sheet.getRow(3);
					
					//Create Cell in the Row
					cell=row.createCell(8);
					
					//Setting value in to the Row of a Cell
					cell.setCellValue(ActualPostLastNameText);
					
					cell=row.createCell(12);
					
					cell.setCellValue("PASS");
					//Saving the Excel file
					file1=new FileOutputStream("./ExcelFiles/AddEmployee.xlsx");
					workbook.write(file1);
					
					
					System.out.println("Post Last Name Matched >> PASS");
				}
				else
				{
					System.out.println("Post Last Name Not Matched >> FAIL");
				}
				System.out.println("********");
				
				
				WebElement PostEmployeeID=driver.findElement(By.id("personal_txtEmployeeId"));
				String ActualPostEmployeeIDText=PostEmployeeID.getAttribute("value");

				System.out.println("The Actual Post Employee ID Text is >> "+ActualPostEmployeeIDText);
						
				if(ActualPostEmployeeIDText.equals(ExpectedpreEmpIDText))
				{
					row=sheet.getRow(3);
					
					//Create Cell in the Row
					cell=row.createCell(9);
					
					//Setting value in to the Row of a Cell
					cell.setCellValue(ActualPostEmployeeIDText);
					
					cell=row.createCell(13);
					
					cell.setCellValue("PASS");
					

					//Saving the Excel file
					file1=new FileOutputStream("./ExcelFiles/AddEmployee.xlsx");
					workbook.write(file1);
					
					System.out.println("Post Employee ID Text Matched >> PASS");
				}
				else
				{
					System.out.println("Post Employee ID Text Not Matched >> FAIL");
				}
				System.out.println("********");
		}
		//Clicking on Welcome Admin
		
		//<a href="#" id="welcome" class="panelTrigger activated-welcome">Welcome Admin</a>
				
		WebElement WelcomeAdminElement = driver.findElement(By.id("welcome"));
		WelcomeAdminElement.click();
				
		// Logout Validation
				
		//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/auth/logout">Logout</a>
				
				
		Thread.sleep(1000);
		WebElement logOut = driver.findElement(By.linkText("Logout"));
		logOut.click();
		System.out.println("Log out Successful - PASS");
	}
}