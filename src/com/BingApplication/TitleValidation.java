package com.BingApplication;

import org.openqa.selenium.chrome.ChromeDriver;

public class TitleValidation
{
public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	
		driver.get("http://bing.com");
		
		String ExpectedBingTitle="Bing";
		System.out.println(" The Expected Title of the Bing  is ==>"+ExpectedBingTitle);
	
		String ActualBingTitle=driver.getTitle();
		System.out.println(" The Actual Title of the Bing is==> "+ActualBingTitle);
	
	if(ActualBingTitle.equals(ExpectedBingTitle))
	{
		System.out.println(" Title Matched - PASS ");
	}
	else
	{
		System.out.println(" Title Not Matched - FAIL ");
	}
	driver.quit();
	}

}
