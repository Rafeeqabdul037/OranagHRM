package com.TSRTCApplication;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DisplayingAllLinks
{
	public static void main(String[] args)
	{
		String ApplicationURLAddress="https://www.tsrtconline.in/oprs-web/";
		//https://www.tsrtconline.in/oprs-web/
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	
		driver.get(ApplicationURLAddress);
		
		
		List<WebElement> AllLinksLink=driver.findElements(By.tagName("a"));
		
		int linksCount=AllLinksLink.size();
		System.out.println("The No Of Links on the Header Element are "+linksCount);
		
		System.out.println("The List of the All Links  are ");
		System.out.println();
		
		for(int i=0;i<linksCount;i++) 
		{
			String headerBlockName=AllLinksLink.get(i).getText();
			System.out.println(i+" "+headerBlockName);
		}
		driver.close();
	}
}
