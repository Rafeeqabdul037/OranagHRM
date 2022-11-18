package com.OsmaniaUniversityApplication;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ListDropDownValueNames
{
	public static void main(String[] args)
	{
		String ApplicationURLAddress="https://www.osmania.ac.in/";
		//https://www.osmania.ac.in/
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	
		driver.get(ApplicationURLAddress);
		
		
		WebElement headerBlock=driver.findElement(By.id("gtranslate_selector"));
		
		
		List<WebElement> headerBlockDropDownElements=headerBlock.findElements(By.tagName("option"));
		
		Select select=new Select(headerBlock);
		
		int DropDownoptionsCount=headerBlockDropDownElements.size();
		System.out.println("The No of Languages under Language Drop Down Element are "+DropDownoptionsCount);
		
		System.out.println("The List Excluding the default option are");
		System.out.println();
		
		select.selectByIndex(2);
		
		for(int i=1;i<DropDownoptionsCount;i++)
		{
				String DropDownOptionNames=headerBlockDropDownElements.get(i).getText();
				
				System.out.println(i+" "+DropDownOptionNames);
				
				Select selection = new Select(headerBlock);
				selection.selectByVisibleText(DropDownOptionNames);
				
				//headerBlock=driver.findElement(By.id("gtranslate_selector"));
				
		}
		//driver.close();
	}	

}
