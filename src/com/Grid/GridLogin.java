package com.Grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridLogin
{
	Logger log = Logger.getLogger(GridLogin.class);
	
	@Parameters("Browser")
	
	@Test
	public void LoginTest(String browserName) throws MalformedURLException
	{
		
		PropertyConfigurator.configure("./LogFiles/Log4j.properties");
		
		System.out.println("The Browser Name is "+browserName);
		
		log.info("Chrome Browser Opened Successfully");
		
		DesiredCapabilities cap=null;
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			cap=DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
		}
		else
			if(browserName.equalsIgnoreCase("chrome"))
			{
				cap=DesiredCapabilities.firefox();
				cap.setBrowserName("firefox");
				cap.setPlatform(Platform.WINDOWS);
			}
		RemoteWebDriver driver=new RemoteWebDriver(new URL("http://192.168.227.1:4444/wd/hub"), cap);
		String applicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";
		driver.get(applicationUrlAddress);
		driver.manage().window().maximize();
		log.info("Chrome Browser Opened Successfully");

		log.info("Naviagted to OrangeHRM Application Successfully");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
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

}
