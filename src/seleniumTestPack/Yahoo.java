package seleniumTestPack;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class Yahoo
	{
		public static void main(String[] args) throws InterruptedException
		{
			// declaration and instantiation of objects/variables
			System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Selenium\\DriverFiles\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// Launch website  
			driver.get("https://login.yahoo.com/");
			// Click on the text box and send value  
			driver.findElement(By.xpath("//*[@id=\"login-username\"]")).sendKeys("Rafeeq@yahoo.com");
			// //*[@id="sb_form_q"]
			//Thread.sleep(1000);
			driver.findElement(By.xpath("//html/body/div[1]/div[2]/div[1]/div[2]/div[2]/form/div[2]/input")).click();
		}

	} 
