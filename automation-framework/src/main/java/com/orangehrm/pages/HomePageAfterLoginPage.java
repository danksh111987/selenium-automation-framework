package com.orangehrm.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.orangehrm.common.WebDriverFactory;

public class HomePageAfterLoginPage {
	//WebElement here
	@FindBy(id="welcome")
	WebElement vWelcometxt;
	@FindBy(xpath="//a[@id='menu_admin_viewAdminModule']")
	WebElement vAdminLink;
	@FindBy(xpath ="//a[@id ='menu_pim_viewPimModule']")
	WebElement vPimLink;
	
	//default constructor to initialize Weblement
	public HomePageAfterLoginPage(){
		PageFactory.initElements(WebDriverFactory.getWebDriver(), this);
	}
	
	//after check, it will remain on home page, thrfor return homepage
	public HomePageAfterLoginPage checkWelcomeText(String txt){
		Assert.assertEquals(vWelcometxt.getText(), txt);
		return this;
	}
	
	public AdminModulePage navigateToAdminModule(){
		vAdminLink.click();
		WebDriverFactory.getWebDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		return (new AdminModulePage());
	}

	
	public PimModulePage navigateToPIMModule(){
		vPimLink.click();
		WebDriverFactory.getWebDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		return (new PimModulePage());
	}
}
