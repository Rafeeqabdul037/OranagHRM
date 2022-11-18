package com.Log4j;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OHRMLogin
{
	
	Logger log = Logger.getLogger(OHRMLogin.class);

	WebDriver driver;
	String applicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";

	@BeforeTest
	public void orangeHRMApplicationLaunch()
	{
		PropertyConfigurator.configure("./LogFiles/Log4j.properties");
		
	 
		driver = new ChromeDriver();
		driver.get(applicationUrlAddress);
		driver.manage().window().maximize();
		log.info("Chrome Browser Opened Successfully");

		log.info("Naviagted to OrangeHRM Application Successfully");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}


	@Test(priority=1)
	public void logInTest()
	{
		WebElement userName=driver.findElement(By.id("txtUsername"));
		userName.clear();
		userName.sendKeys("Admin");

		log.info("Entered UserName Successfully");

		WebElement password=driver.findElement(By.name("txtPassword"));
		password.clear();
		password.sendKeys("AdminRafeeq@123");

		log.info("Entered Password Successfully");

		WebElement logInButton=driver.findElement(By.className("button"));
		logInButton.click();

		log.info("Clicked on LogIn Button Successfully");

	}

	@Test(priority=2)
	public void welComeAdminTest() 
	{
		WebElement welComeAdminElement=driver.findElement(By.id("welcome"));
		welComeAdminElement.click();

		log.info("Clicked on WelCome Admin link");
		

	}

	@Test(priority=3)
	public void logOutTest() throws InterruptedException
	{
		
		WebElement logOut=driver.findElement(By.linkText("Logout"));
		logOut.click();

		log.info("Successfully LogOut from the Application");
	}

	@AfterTest
	public void OrangeHRMApplicationClose()
	{
		driver.close();

		log.info("OrangeHRM Application Closed Successfully");
	}
}
