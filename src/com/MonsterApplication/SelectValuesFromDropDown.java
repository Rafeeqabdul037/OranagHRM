package com.MonsterApplication;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectValuesFromDropDown
{
	public static void main(String[] args)
	{
		String ApplicationURLAddress="https://my.monsterindia.com/sponsered_popup.html";
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	
		driver.get(ApplicationURLAddress);
		
		
		WebElement currentLocation=driver.findElement(By.className("border_grey1"));
		
		
		List<WebElement> currentLocationList=currentLocation.findElements(By.tagName("option"));
		
		/*int locationListCount=currentLocationList.size();
		System.out.println("The No of Locations under Current Locaton Drop Down Element are "+locationListCount);
		System.out.println();
		
		for(int i=1;i<locationListCount;i++) //Listing only the Language Names
		{
				String currentLocationListName=currentLocationList.get(i).getText();
				System.out.println(i+" "+currentLocationListName);
		}*/
		
		Select selection =new Select(currentLocation);
		
		selection.selectByIndex(3);
		driver.close();
		
	}
}
