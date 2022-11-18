package com.TestNG;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assertion
{

	public static void main(String[] args)
	{
		String ApplicationURLAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		//http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login
		
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	
		driver.get(ApplicationURLAddress);
String expected_OrangeHRMApplicationUrlAddress="orangehrm-4.2.0.1";
String actual_OrangeHRMApplicationUrlAddress=driver.getCurrentUrl();

Assert.assertTrue(actual_OrangeHRMApplicationUrlAddress.contains(expected_OrangeHRMApplicationUrlAddress));
Assert.assert
driver.quit();
}

}
