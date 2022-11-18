package com.OsmaniaUniversityApplication;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectLanguageByValueDynamic 
{
	public static void main(String[] args) throws InterruptedException
	{
		String ApplicationURLAddress="https://www.osmania.ac.in/";
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	
		driver.get(ApplicationURLAddress);
		
		
		WebElement headerBlock=driver.findElement(By.id("gtranslate_selector"));
		
		
		List<WebElement> headerBlockDropDownElements=headerBlock.findElements(By.tagName("option"));
		
		
		int DropDownoptionsCount=headerBlockDropDownElements.size();
		System.out.println("The No of Languages under Language Drop Down Element are "+DropDownoptionsCount);
		System.out.println();
		
		for(int i=1;i<DropDownoptionsCount;i++)
		{
			
				String DropDownOptionNames=headerBlockDropDownElements.get(i).getAttribute("value");;
								
				/*System.out.println("The Attribute values are");
				
				
				System.out.println(i+" "+DropDownOptionNames);*/
				
				Select selection = new Select(headerBlock);
				Thread.sleep(1000);
				selection.selectByValue(DropDownOptionNames);
		}
		//driver.close();
	}

}
