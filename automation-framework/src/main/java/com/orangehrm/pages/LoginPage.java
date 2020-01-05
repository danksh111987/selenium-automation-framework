package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.orangehrm.common.WebDriverFactory;

public class LoginPage {
	//define elements here
	@FindBy(id="txtUsername")
	WebElement vUserName;
	@FindBy(id="txtPassword")
	WebElement vPaswd;
	@FindBy(id="btnLogin")
	WebElement vBtnLogin;
	
	@FindBy(xpath="//span[@id='spanMessage']")
	WebElement vInvalidCred;
	
	//default constructor
	public LoginPage(){
		
		//initial weblement to avoid nummpointer exception
		PageFactory.initElements(WebDriverFactory.getWebDriver(), this);

	}
	
	//this method should take to homepage
	public HomePageAfterLoginPage checkLoginCredential(String user, String paswd){
		vUserName.sendKeys(user);
		vPaswd.sendKeys(paswd);
		vBtnLogin.click();
		
		return (new HomePageAfterLoginPage());
	}
	
	//this method checks msg on same login page therefore return this.
	public LoginPage inValidLogin(String user, String paswd, String txt ){
		vUserName.sendKeys(user);
		vPaswd.sendKeys(paswd);
		vBtnLogin.click();
		//wrong credentials
		if((user.isEmpty()==false) && (paswd.isEmpty()==false)){
			Assert.assertEquals(vInvalidCred.getText(), txt);
		}
		//paswd is empty
		if((user.isEmpty()==false) && (paswd.isEmpty()==true)){
			Assert.assertEquals(vInvalidCred.getText(), txt);
		}
		
		//user is empty
		if((user.isEmpty()==false) && (paswd.isEmpty()==true)){
			Assert.assertEquals(vInvalidCred.getText(), txt);
		}
		
		return this;
		
		
	}
	

}
