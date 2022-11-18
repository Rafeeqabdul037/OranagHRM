package com.OHRMApplication;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginUsingTestNG 
{
WebDriver driver;
	
	@BeforeTest
	public void applicationLaunch()
	{
		
		String ApplicationURLAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(ApplicationURLAddress);
		driver.manage().window().maximize();
	}
	
	@Test
	public void logInTest()
	{
		WebElement password=driver.findElement(By.id("txtUsername"));
		password.sendKeys("Admin");
		
		WebElement logIn=driver.findElement(By.id("txtPassword"));
		logIn.sendKeys("AdminRafeeq@123");
		
		WebElement logInBtn=driver.findElement(By.id( "btnLogin"));
		logInBtn.click();
	}
	@Test
	public void welComeTest()
	{
	//<a href="#" id="welcome" class="panelTrigger activated-welcome">Welcome Admin</a>
		
	WebElement WelcomeDrop = driver.findElement(By.id("welcome"));
	WelcomeDrop.click();
	}
	//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/auth/logout">Logout</a>
		
	@Test
	public void logOutTest()
	{
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Thread.sleep(1000);
		WebElement logOut = driver.findElement(By.linkText("Logout"));
		logOut.click();
	}
	
	@AfterTest
	public void applicationClose()
	{
		driver.close();
	}

}
