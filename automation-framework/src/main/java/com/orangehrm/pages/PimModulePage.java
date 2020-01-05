package com.orangehrm.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.orangehrm.common.WebDriverFactory;

public class PimModulePage {
	//WebElement
	@FindBy(id="btnAdd")
	WebElement vBtnAdd;
	
	//Default constructor
	public PimModulePage(){
		PageFactory.initElements(WebDriverFactory.getWebDriver(), this);
	}
	
	
	
	//Generic method
	public AddEmployeePage navigateToAddEmployee(){
		WebDriverFactory.getWebDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//no such element issue therefore wait added
		vBtnAdd.click();
		WebDriverFactory.getWebDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		return (new AddEmployeePage());
	}
	
	

	public PimModulePage checkPimModuleLoaded(){
		Assert.assertEquals(vBtnAdd.isDisplayed(), true);
		return this;
	}

}
