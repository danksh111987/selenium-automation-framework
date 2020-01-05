package com.orangehrm.pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.orangehrm.common.WebDriverFactory;

public class AddUserPage {
//Webelement
	@FindBy(id="systemUser_userType")
	WebElement vUserRole;
	@FindBy(xpath="//input[@id='systemUser_employeeName_empName']")
	WebElement vEmpName;
	@FindBy(xpath ="//input[@id='systemUser_userName']")
	WebElement vUserName;
	@FindBy(id="systemUser_status")
	WebElement vStatus;
	@FindBy(id="systemUser_password")
	WebElement vPaswd;
	@FindBy(id="systemUser_confirmPassword")
	WebElement vCpaswd;
	@FindBy(id="btnSave")
	WebElement vBtnSave;
	@FindBy(id="btnCancel")
	WebElement vBtnCancel;
	
	
	
	public static String StrNewUSerValue;
	
	//default constructor to initialize webelements
	public AddUserPage(){
		PageFactory.initElements(WebDriverFactory.getWebDriver(), this);
	}
	
	
	//generic methods
	//it goes to adminmodule page on used addition thrfore return AdminModule page
	public AdminModulePage addNewUser(String role, String empname, String status, String paswd, String cpaswd){
		
		Select vSelRole = new Select(vUserRole);
		vSelRole.selectByVisibleText(role);
		
		vEmpName.sendKeys(empname);
		
		StrNewUSerValue = GenerateDynamicUserName();
		vUserName.sendKeys(StrNewUSerValue);
		
		Select vSelStatus = new Select(vStatus);
		vSelStatus.selectByVisibleText(status);
		
		vPaswd.sendKeys(paswd);
		vCpaswd.sendKeys(cpaswd);
		vBtnSave.click();
		
		WebDriverFactory.getWebDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		return (new AdminModulePage());
		
	}
	
public AdminModulePage cancelNewUser(){
		
		vBtnCancel.click();
		
		WebDriverFactory.getWebDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		return (new AdminModulePage());
		
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
