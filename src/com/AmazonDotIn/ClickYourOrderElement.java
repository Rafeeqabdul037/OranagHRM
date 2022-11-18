package com.AmazonDotIn;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickYourOrderElement
{
	public static void main(String[] args)
	{
		String ApplicationURLAddress="http://amazon.in";
		
		WebDriver driver;
	
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(ApplicationURLAddress);
		driver.manage().window().maximize();
		
		//<span id="nav-link-accountList-nav-line-1" class="nav-line-1 nav-progressive-content">Hello, sign in</span>
		
		WebElement SignInElement = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		String SignInId=SignInElement.getAttribute("id");
		System.out.println("Properties of Sign In Element is =>"+SignInId);
		
		Actions action=new Actions(driver);
		action.moveToElement(SignInElement).build().perform();
		
		//<span class="nav-text">Your Orders</span>
		
		WebElement YourOrderElement = driver.findElement(By.linkText("Your Orders"));
		YourOrderElement.click();
		
		driver.close();
	}

}
