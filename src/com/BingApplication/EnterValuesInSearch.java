package com.BingApplication;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnterValuesInSearch
{
	public static void main(String[] args) throws InterruptedException
	{
		// declaration and instantiation of objects/variables
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Selenium\\DriverFiles\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Launch website  
		driver.get("https://bing.com/");
		// Click on the text box and send value  
		driver.findElement(By.xpath("//*[@id=\"sb_form_q\"]")).sendKeys("google");
		// //*[@id="sb_form_q"]
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"search_icon\"]/svg")).click();
	}

}
