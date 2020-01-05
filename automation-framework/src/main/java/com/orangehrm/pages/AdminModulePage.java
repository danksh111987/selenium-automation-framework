package com.orangehrm.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.orangehrm.common.WebDriverFactory;

public class AdminModulePage {
//WebElements
	@FindBy(id="btnAdd")
	WebElement vBtnAdd;
	
	
	//default constructor to initialize webelements
	
	public AdminModulePage(){
		PageFactory.initElements(WebDriverFactory.getWebDriver(), this);
	}
	
	//move to adduser page therefore return is AddUserPage
	public AddUserPage navigateToAddUser(){
		vBtnAdd.click();
		WebDriverFactory.getWebDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		return (new AddUserPage());
	}
	
	public AdminModulePage checkAddedUser(){
		//use static string value 
		WebElement vAddedUser = WebDriverFactory.getWebDriver().findElement(By.xpath("//a[contains(text(),'"+AddUserPage.StrNewUSerValue+"')]"));
		Assert.assertEquals(vAddedUser.isDisplayed(),true );
		
		return this;
	}
	
	public AdminModulePage checkAdminModulePageLoaded(){
		
		Assert.assertEquals(vBtnAdd.isDisplayed(), true);
		return this;
	}
}
