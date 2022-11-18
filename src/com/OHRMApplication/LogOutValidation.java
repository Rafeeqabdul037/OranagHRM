package com.OHRMApplication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogOutValidation 
{
	public static void main(String[] args) throws InterruptedException
	{
		String ApplicationURLAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		//http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login
		
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
	
		System.out.println("Login Successful - PASS");
		
		//<a href="#" id="welcome" class="panelTrigger activated-welcome">Welcome Admin</a>
		
		WebElement WelcomeDrop = driver.findElement(By.id("welcome"));
		WelcomeDrop.click();
		
		//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/auth/logout">Logout</a>
			
        Thread.sleep(1000);
		WebElement logOut = driver.findElement(By.linkText("Logout"));
		logOut.click();
	}

}
