package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.orangehrm.common.WebDriverFactory;

public class EmployeeListPage {
	//webelement
	@FindBy(id="personal_txtEmpFirstName")
	WebElement vFirstName;
	@FindBy(id="personal_txtEmpLastName")
	WebElement vLastName;
	
	//default constructor
	public EmployeeListPage(){
		
		PageFactory.initElements(WebDriverFactory.getWebDriver(), this);
	}
	
	//generic method, readonly value in txtbox
	public EmployeeListPage checkEmployeeAdded(String first, String last){
		Assert.assertEquals(vFirstName.getAttribute("value"), first);
		Assert.assertEquals(vLastName.getAttribute("value"), last);
		
		return this;
	}

}
