package com.TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
		/*driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);*/
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
	public void logOutTest() throws InterruptedException
	{
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/auth/logout">Logout</a>
		
		//Thread.sleep(10000);
		//WebElement logOut = driver.findElement(By.linkText("Logout"));
		WebDriverWait wait=new WebDriverWait(driver, 10);
		WebElement logOut; 
		logOut	=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
		logOut.click();
		
	
	}
	
	/*@AfterTest
	public void applicationClose()
	{
		driver.close();
	}*/

}
