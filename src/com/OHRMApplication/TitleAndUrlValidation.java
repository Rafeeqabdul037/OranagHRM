package com.OHRMApplication;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TitleAndUrlValidation 
{
	public static void main(String[] args)
	{
		String ApplicationURLAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		//http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login
		
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	
		driver.get(ApplicationURLAddress);
		
		String ExpectedOHRMTitle="OrangeHRM";
		System.out.println("The Expected Title of the OHRM  is ==>"+ExpectedOHRMTitle);
	
		String ActualOHRMTitle=driver.getTitle();
		System.out.println("The Actual Title of the OHRM is==> "+ActualOHRMTitle);
	
		if(ActualOHRMTitle.equals(ExpectedOHRMTitle))
		{
			System.out.println("Title Matched - PASS ");
		}
		else
		{
			System.out.println("Title Not Matched - FAIL ");
		}
		
		String ExpectedOHRMHomeUrlAddress="orangehrm-4.2.0.1";
		System.out.println("Expected OHRM Home Url Address is ==>"+ExpectedOHRMHomeUrlAddress);
		
		String ActualOHRMHomeUrlAddress=driver.getCurrentUrl();
		System.out.println("Actual OHRM Home Url Address is ==>"+ActualOHRMHomeUrlAddress);
		
		if(ActualOHRMHomeUrlAddress.contains(ExpectedOHRMHomeUrlAddress))
		{
			System.out.println("Part of URL Matched - PASS ");
		}
		else
		{
			System.out.println("Part of URL Not Matched - FAIL ");
		}

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("AdminRafeeq@123");
		driver.findElement(By.id( "btnLogin")).click();
		
		System.out.println("Login Successful - PASS");
		
		ExpectedOHRMTitle="OrangeHRM";
		System.out.println("The Expected Title of the OHRM  is ==>"+ExpectedOHRMTitle);
	
		ActualOHRMTitle=driver.getTitle();
		System.out.println("The Actual Title of the OHRM is==> "+ActualOHRMTitle);
	
		if(ActualOHRMTitle.equals(ExpectedOHRMTitle))
		{
			System.out.println("Title Matched - PASS ");
		}
		else
		{
			System.out.println("Title Not Matched - FAIL ");
		}
		//driver.close();
	}

}
