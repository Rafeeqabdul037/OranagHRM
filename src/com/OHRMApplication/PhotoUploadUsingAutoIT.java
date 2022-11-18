package com.OHRMApplication;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PhotoUploadUsingAutoIT 
{
	
	WebDriver driver;
	String applicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";

	@BeforeTest
	public void setUp()
	{
	//System.setProperty("webdriver.gecko.driver", "./driverFiles/geckodriver.exe");

	//driver = new FirefoxDriver();

	System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");

	driver= new ChromeDriver();
	//driver = new FirefoxDriver();
	driver.get(applicationUrlAddress);

	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}


	@Test(priority=1)
	public void logInTest()
	{
	// Validating LogIn Page
	// id="txtUsername"
	//WebElement userName=driver.findElement(By.id("txtUsername"));

	// Creating Xpath Expression Using Single Property
	//tagName[@attribute='value']
	//*[@attribute='value']

	//WebElement userName=driver.findElement(By.xpath("//input[@id='txtUsername']"));
	WebElement userName=driver.findElement(By.xpath("//*[@id='txtUsername']"));
	userName.clear();
	userName.sendKeys("Admin");

	WebElement password=driver.findElement(By.name("txtPassword"));
	password.clear();
	password.sendKeys("AdminRafeeq@123");

	WebElement logInButton=driver.findElement(By.className("button"));
	logInButton.click();
	}


	@Test(priority=2)
	public void pimTest()
	{
	WebElement pim=driver.findElement(By.id("menu_pim_viewPimModule"));

	Actions action = new Actions(driver);
	action.moveToElement(pim).build().perform();

	}

	@Test(priority=3)
	public void addEmployeeTest()
	{

	// Explicit wait

	WebDriverWait wait = new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_addEmployee")));

	WebElement addEmployee=driver.findElement(By.id("menu_pim_addEmployee"));
	addEmployee.click();

	}

	@Test(priority=4)
	public void addNewEmployeeTest() throws InterruptedException, IOException
	{
	WebElement firstName=driver.findElement(By.id("firstName"));
	firstName.sendKeys("Mohd");

	Actions act = new Actions(driver);

	act.sendKeys(Keys.TAB).build().perform();
	act.sendKeys("Abdul").build().perform();

	act.sendKeys(Keys.TAB).build().perform();
	act.sendKeys("Rafeeq").build().perform();

	WebElement empId=driver.findElement(By.xpath("//*[@id='employeeId']"));
	String employeeId=empId.getAttribute("value");
	System.out.println("The Employee ID is :"+employeeId);

	act.sendKeys(Keys.TAB).build().perform();
	act.sendKeys(Keys.TAB).build().perform();

	act.sendKeys(Keys.ENTER).build().perform();

	Thread.sleep(10000);
	
	
	
	//It works only for input tag
	//driver.findElement(By.id("photofile")).sendKeys("./Images/Orange-HRM-logo-1-770x577.jpg");

	Runtime.getRuntime().exec("./AutoIT/OrangeHRM.exe");

	Thread.sleep(5000);

	driver.findElement(By.id("btnSave")).click();




	}

}
