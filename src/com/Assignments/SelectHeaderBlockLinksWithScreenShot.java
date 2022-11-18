package com.Assignments;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectHeaderBlockLinksWithScreenShot 
{
	public static void main(String[] args) throws IOException, InterruptedException
	{
		String ApplicationURLAddress="https://www.tsrtconline.in/oprs-web/";
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	
		driver.get(ApplicationURLAddress);
		
		
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
				
				FileUtils.copyFile(OUScreenShot, new File("./ScreenShots/TSRTC_"+headerBlockLinks+".png"));
				
				driver.navigate().back();
				headerBlock=driver.findElement(By.className("menu"));
				
				headerBlockLinks=headerBlock.findElements(By.tagName("a"));
				
				System.out.println("Screenshot of * "+headerBlockLinkNames+" * is Captured and Saved Successfully >> PASS");
				
		}
		driver.close();
	}

}
