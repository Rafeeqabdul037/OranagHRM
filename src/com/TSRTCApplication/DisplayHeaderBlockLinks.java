package com.TSRTCApplication;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DisplayHeaderBlockLinks
{

	public static void main(String[] args) throws IOException, InterruptedException
	{
		String ApplicationURLAddress="https://www.tsrtconline.in/oprs-web/";
		//https://www.tsrtconline.in/oprs-web/
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	
		driver.get(ApplicationURLAddress);
		
		
		//Header Block properties
		//<div class="menu">
		
		//Header Block Link Properties
		//<a class="selectedtabcopy" href="/oprs-web/guest/home.do?h=1" target="_top" title="Home">Home</a>
		//All the Header Block Links has ANCHOR tag  properties
		
		
		WebElement headerBlock=driver.findElement(By.className("menu"));
		
		
		List<WebElement> headerBlockLinks=headerBlock.findElements(By.tagName("a"));
		
		int linksCount=headerBlockLinks.size();
		System.out.println("The No Of Links on the Header Block are "+linksCount);

		System.out.println();
		
		for(int i=0;i<linksCount;i++) 
		{
				String headerBlockLinkNames=headerBlockLinks.get(i).getText();
				headerBlockLinks.get(i).click();
				
				Thread.sleep(500);
				
				File OUScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				
				FileUtils.copyFile(OUScreenShot, new File("./ScreenShots/TSRTCHeaderLinksScreenShot"+i+".png"));
				
				/*System.out.println(i+" "+headerBlockLinkNames);
				String webPageTitle=driver.getTitle();
				System.out.println(webPageTitle);*/
				
				driver.navigate().back();
				headerBlock=driver.findElement(By.className("menu"));
				
				headerBlockLinks=headerBlock.findElements(By.tagName("a"));
				
				System.out.println("Screenshot of * "+headerBlockLinkNames+" * is Captured and Saved Successfully >> PASS");
				
		}
		driver.close();
	}

}
