package com.orangehrm.pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.common.WebDriverFactory;

public class AddEmployeePage {
	//webelement
	@FindBy(xpath="//input[@id='firstName']")
	WebElement vFirstName;
	@FindBy(id="lastName")
	WebElement vLastName;
	@FindBy(xpath="//input[@id='chkLogin']")
	WebElement vCheckbox;
	@FindBy(xpath = "//input[@id='user_name']")
	WebElement vUserName;
	@FindBy(xpath="//input[@id='user_password']")
	WebElement vPaswd;
	@FindBy(xpath="//input[@id='re_password']")
	WebElement vCPaswd;
	@FindBy(id ="status")
	WebElement vStatus;
	@FindBy(id ="btnSave")
	WebElement vBtnSave;
	
	public static String StrNewUSerValue;
	
	//default constructor
	public AddEmployeePage(){
		PageFactory.initElements(WebDriverFactory.getWebDriver(), this);
	}
	
	//generic method
	
	public EmployeeListPage addEmployee(String FirstName, String LastName, String paswd, String cpaswd, String status){
		WebDriverFactory.getWebDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//not able to find element therefore adding wait
		vFirstName.sendKeys(FirstName);
		vLastName.sendKeys(LastName);
		vCheckbox.click();
		StrNewUSerValue = GenerateDynamicUserName();
		vUserName.sendKeys(StrNewUSerValue);
		vPaswd.sendKeys(paswd);
		vCPaswd.sendKeys(cpaswd);
		vStatus.sendKeys(status);
		vBtnSave.click();
		
		return (new EmployeeListPage());
	}
	
	//Random user generation
			public String GenerateDynamicUserName(){
				
				// Create object of SimpleDateFormat class and decide the format
						Date now = new Date();
					    SimpleDateFormat dateFormatter = new SimpleDateFormat("yMdhms");
					    System.out.println("Format 1:   " + dateFormatter.format(now));
					    // Shows value 2019111911912 = 2019-nov-19,11h,9m,12s"		 	 
						 // Now format the date
						 String date1= dateFormatter.format(now);
						 System.out.println("Current date and time is " +date1);
						 
						 //global variable
						  StrNewUSerValue = "Aman1"+ date1;
						 
						 return StrNewUSerValue;
				
			}

}
