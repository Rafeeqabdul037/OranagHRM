package com.OHRMApplication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AddEmployeeDetailsValidation
{
	public static void main(String[] args) throws InterruptedException
	{
		String ApplicationURLAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		//http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(ApplicationURLAddress);
		driver.manage().window().maximize();
		
		
		//OHRM Main Page Title Validation
		
		String ExpectedOHRMMainPageTitle="OrangeHRM";
		System.out.println("The Expected Title of the OHRM Main Page is >>"+ExpectedOHRMMainPageTitle);
	
		String ActualOHRMMainPageTitle=driver.getTitle();
		System.out.println("The Actual Title of the OHRM Main Page is >> "+ActualOHRMMainPageTitle);
	
		if(ActualOHRMMainPageTitle.equals(ExpectedOHRMMainPageTitle))
		{
			System.out.println("Orange HRM Main Page Title Matched - PASS ");
		}
		else
		{
			System.out.println("Orange HRM Main Page Title Not Matched - FAIL ");
		}
		System.out.println("********");
		
		
		//OHRM Main Page URL Address Part Validation
		
		String ExpectedOHRMMainPageUrlAddress="orangehrm-4.2.0.1";
		System.out.println("The Expected Part of  OHRM Main Page Url Address is >>"+ExpectedOHRMMainPageUrlAddress);
		
		String ActualOHRMMainPageUrlAddress=driver.getCurrentUrl();
		System.out.println("The Actual OHRM Main Page Url Address is >>"+ActualOHRMMainPageUrlAddress);
		
		if(ActualOHRMMainPageUrlAddress.contains(ExpectedOHRMMainPageUrlAddress))
		{
			System.out.println("The Part of  OHRM Main Page URL Address Matched - PASS ");
		}
		else
		{
			System.out.println("Part of OHRM Main Page URL Address Not Matched - FAIL ");
		}
		System.out.println("********");
		
		
		// Login Validation
		
		//Properties of User Name Element
		//<input name="txtUsername" id="txtUsername" type="text">
		
		WebElement UserName=driver.findElement(By.id("txtUsername"));
		UserName.sendKeys("Admin");
		
		//Properties of Password Element
		//<input name="txtPassword" id="txtPassword" autocomplete="off" type="password">
		
		WebElement PassWord=driver.findElement(By.id("txtPassword"));
		PassWord.sendKeys("AdminRafeeq@123");
		
		//Properties of Login Button
		//<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
		
		WebElement logInBtn=driver.findElement(By.id( "btnLogin"));
		logInBtn.click();
	
		System.out.println("Login Successful - PASS");
		
		System.out.println("********");
		
		System.out.println("This is Orange HRM Home Page");
		
		
		
		//OHRM Home Page Title Validation
		
		String  ExpectedOHRMHomePageTitle="OrangeHRM";
		System.out.println("The Expected Title of the OHRM Home Page  is >>"+ExpectedOHRMHomePageTitle);
	
		String ActualOHRMHomePageTitle=driver.getTitle();
		System.out.println("The Actual Title of the OHRM Home Page is >> "+ActualOHRMHomePageTitle);
	
		if(ActualOHRMHomePageTitle.equals(ExpectedOHRMHomePageTitle))
		{
			System.out.println("OHRM Home Page Title Matched - PASS ");
		}
		else
		{
			System.out.println("OHRM Home Page Title Not Matched - FAIL ");
		}
		System.out.println("********");
		
		
		//Validate Admin Text
		
		//Properties of Admin Element
		/*<a href="/orangehrm-4.2.0.1/symfony/web/index.php/admin/viewAdminModule" 
		id="menu_admin_viewAdminModule" class="firstLevelMenu"><b>Admin</b></a>*/
		
		WebElement AdminElementText=driver.findElement(By.id("menu_admin_viewAdminModule"));
		String ActualAdminElementText=AdminElementText.getText();
		System.out.println("The Actual Admin Element Text is >> "+ActualAdminElementText);
		
		String ExpectedAdminElementText="Admin";
		System.out.println("The Expected Admin Element Text is >> "+ExpectedAdminElementText);
		
		if(ActualAdminElementText.equals(ExpectedAdminElementText))
		{
			System.out.println("Admin Element Text Matched >> PASS");
		}
		else
		{
			System.out.println("Admin Element Text Not Matched >> FAIL");
		}
		System.out.println("********");
		
		
		//Navigating to PIM Element by Mouse Hovering on it
		
		//Properties of PIM Element
		/*<a href="/orangehrm-4.2.0.1/symfony/web/index.php/pim/viewPimModule"
		 *  id="menu_pim_viewPimModule" class="firstLevelMenu"><b>PIM</b></a>*/
		
		WebElement PIMElement = driver.findElement(By.id("menu_pim_viewPimModule"));
		
		Actions action=new Actions(driver);
		action.moveToElement(PIMElement).build().perform();
		
		
		//Finding  and Clicking on Add Employee
		
		//Properties of Add Emplyee
		//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/pim/addEmployee" id="menu_pim_addEmployee">Add Employee</a>
		
		WebElement AddEmployee = driver.findElement(By.id("menu_pim_addEmployee"));
		AddEmployee.click();
		
		System.out.println("This is Add Empoyee Page");
		System.out.println("********");
		 
		
		//Entering Details into Add Employee
		
		//Properties of Pre First Name Element 
		/*<input class="formInputText" maxlength="30" type="text" name="firstName" id="firstName">*/
		
		
		WebElement preFirstName=driver.findElement(By.id("firstName"));
		preFirstName.sendKeys("Abdul");
		
		//Properties of Pre Middle Name Element
		//<input class="formInputText" maxlength="30" type="text" name="middleName" id="middleName">
		
		WebElement preMiddleName=driver.findElement(By.id("middleName"));
		preMiddleName.sendKeys("  ");
		
		//Properties of Pre Last Name Element
		//<input class="formInputText" maxlength="30" type="text" name="lastName" id="lastName">
		
		WebElement preLastName=driver.findElement(By.id("lastName"));
		preLastName.sendKeys("Rafeeq");
		
		
		//Validating Employee ID
		
		//Properties of Pre Employee ID, Auto Generated
		//<input class="formInputText" maxlength="10" type="text" name="employeeId" value="0008" id="employeeId">
		
		WebElement preEmpIDText=driver.findElement(By.id("employeeId"));
		String ActualpreEmpIDText=preEmpIDText.getAttribute("value");
		System.out.println("The Actual Pre Employee ID  is >> "+ActualpreEmpIDText);
				
		String ExpectedpreEmpIDText="0023"; //Manually Increment ExpectedpreEmployeeIDText value by 1 on each Compilation of the Script
		System.out.println("The Expected Pre Employee ID is >> "+ExpectedpreEmpIDText);
				
		if(ActualpreEmpIDText.equals(ExpectedpreEmpIDText))
		{
			System.out.println("The Pre Employee ID Text Matched >> PASS");
		}
		else
		{
			System.out.println("The Pre Employee ID Text Not Matched >> FAIL");
		}
		
		
		//Properties of Save Button
		//<input type="button" class="" id="btnSave" value="Save">
		
		WebElement saveBtn=driver.findElement(By.id( "btnSave"));
		saveBtn.click();
		
		Thread.sleep(1000);
		
		System.out.println("********");
		
		System.out.println("Employee details added Successfully - PASS");
		System.out.println("This is a Employee Details Page");
		
		System.out.println();
		//Validating Employee Details		
		
		
		//Properties of Employee Full Name on side Panel
		/*<div id="sidebar">

	   	<div id="profile-pic">
	    
		<h1>Abdul Rafeeq</h1>*/
		
		WebElement sideBar=driver.findElement(By.id("sidebar"));
		
		WebElement sideBarHeader=sideBar.findElement(By.tagName("h1"));
		
		String FullName=sideBarHeader.getText();
		
		System.out.println("The Employee Full Name is >>"+FullName);
		
		System.out.println("********");
		
		//Propreties of Post First Name
		/*<input value="Abdul" type="text" name="personal[txtEmpFirstName]" class="block default editable" maxlength="30" title="First Name
				id="personal_txtEmpFirstName" disabled="disabled">*/
			
		WebElement PostFirstName=driver.findElement(By.id("personal_txtEmpFirstName"));
		
		String ActualPostFirstNameText=PostFirstName.getAttribute("value");
		System.out.println("The Actual Post First Name  is >> "+ActualPostFirstNameText);
		
		String ExpectedPostFirstNameText="Abdul";
		System.out.println("The Expected Post First  Name is >> "+ExpectedPostFirstNameText);
		
		if(ActualPostFirstNameText.equals(ExpectedPostFirstNameText))
		{
			System.out.println("Post First Name Matched >> PASS");
		}
		else
		{
			System.out.println("Post First Name Not Matched >> FAIL");
		}
		System.out.println("********");
		
		//Validating Employee Middle Name
		/*<input value="" type="text" name="personal[txtEmpMiddleName]" class="block default editable" maxlength="30" title="Middle Name" 
		 * id="personal_txtEmpMiddleName" disabled="disabled">*/
		
		WebElement PostMiddleName=driver.findElement(By.id("personal_txtEmpMiddleName"));
		String ActualPostMiddleNameText=PostMiddleName.getAttribute("value");
		
		System.out.println("The Actual Post Middle Name  is >> "+ActualPostMiddleNameText);
		
		String ExpectedPostMiddleNameText="";
		System.out.println("The Expected Post Middle  Name is >> "+ExpectedPostMiddleNameText);
		
		if(ActualPostMiddleNameText.equals(ExpectedPostMiddleNameText))
		{
			System.out.println("Post Middle Name Matched >> PASS");
		}
		else
		{
			System.out.println("Post Middle Name Not Matched >> FAIL");
		}
		System.out.println("********");
		
		
		//Validating Post Employee Last Name
		
		/*<input value="Rafeeq" type="text" name="personal[txtEmpLastName]" class="block default editable" maxlength="30" title="Last Name"
		 id="personal_txtEmpLastName" disabled="disabled"> */
		
		WebElement PostLastName=driver.findElement(By.id("personal_txtEmpLastName"));
		String ActualPostLastNameText=PostLastName.getAttribute("value");
		
		System.out.println("The Actual Post Last Name is >> "+ActualPostLastNameText);
				
		String ExpectedPostLastNameText="Rafeeq";
		System.out.println("The Expected Post Last Name is >> "+ExpectedPostLastNameText);
				
		if(ActualPostLastNameText.equals(ExpectedPostLastNameText))
		{
			System.out.println("Post Last Name Matched >> PASS");
		}
		else
		{
			System.out.println("Post Last Name Not Matched >> FAIL");
		}
		System.out.println("********");
		
		
		
		//Validating Post Employee ID
		
		/*<input value="0014" type="text" name="personal[txtEmployeeId]" maxlength="10" class="editable" 
		 * id="personal_txtEmployeeId" disabled="disabled">*/
		
		WebElement PostEmployeeID=driver.findElement(By.id("personal_txtEmployeeId"));
		String ActualPostEmployeeIDText=PostEmployeeID.getAttribute("value");

		System.out.println("The Actual Post Employee ID Text is >> "+ActualPostEmployeeIDText);
				
		String ExpectedPostEmployeeIDText=ExpectedpreEmpIDText;
		System.out.println("The Expected Post Employee ID is >> "+ExpectedPostEmployeeIDText);
				
		if(ActualPostEmployeeIDText.equals(ExpectedPostEmployeeIDText))
		{
			System.out.println("Post Employee ID Text Matched >> PASS");
		}
		else
		{
			System.out.println("Post Employee ID Text Not Matched >> FAIL");
		}
		System.out.println("********");
		
		
		//Clicking on Welcome Admin
		
		//<a href="#" id="welcome" class="panelTrigger activated-welcome">Welcome Admin</a>
		
		WebElement WelcomeAdminElement = driver.findElement(By.id("welcome"));
		WelcomeAdminElement.click();
		
		
		
		// Logout Validation
		
		//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/auth/logout">Logout</a>
		
		
       Thread.sleep(1000);
		WebElement logOut = driver.findElement(By.linkText("Logout"));
		logOut.click();
		System.out.println("Log out Successful - PASS");
		
		System.out.println("********");
		
		
		//Validating Login Panel Text
		//<div id="logInPanelHeading">LOGIN Panel</div>
		
		WebElement loginPanelElement=driver.findElement(By.id("logInPanelHeading"));
		String ActualloginPanelText=loginPanelElement.getText();
		System.out.println("The Actual Login Panel Text is >> "+ActualloginPanelText);
		
		String ExpectedLoginPanelText="LOGIN Panel";
		System.out.println("The Expected Login Panel Text is >> "+ExpectedLoginPanelText);
		
		if(ActualloginPanelText.equals(ExpectedLoginPanelText))
		{
			System.out.println("Login Panel Text Matched >> PASS");
		}
		else
		{
			System.out.println("Login Panel Text Not Matched >> FAIL");
		}		
		driver.close();
	}

}
