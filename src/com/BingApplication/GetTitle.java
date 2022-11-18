package com.BingApplication;

import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitle
{
public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// Navigating to Bing HomePage
		driver.get("http://bing.com");
		
		// Identify the title of Bing Home Page
	String ActualBingTitle=driver.getTitle();
	System.out.println(" The Actual Title of the Bing HomePage is=> "+ActualBingTitle);
	
	driver.quit();
		
	}

}
