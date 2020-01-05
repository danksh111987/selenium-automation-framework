package com.orangehrm.tests;

import org.testng.annotations.Test;

import com.orangehrm.common.BaseSelenium;
import com.orangehrm.pages.LoginPage;

public class LoginPageTests extends BaseSelenium  {
	
	@Test
	public void TC1VerifyValidAdminUser(){
		
		LoginPage lp = new LoginPage();
		lp.checkLoginCredential("admin", "admin")
			.checkWelcomeText("Welcome Admin");
		
	}
	
	@Test
	public void TC2VerifyInvalidCredential(){
		LoginPage lp = new LoginPage();
		lp.inValidLogin("admin", "1234", "Invalid credentials");
		
	}
	
	@Test
	public void TC3VerifyEmptyPaswd(){
		LoginPage lp = new LoginPage();
		lp.inValidLogin("admin", "", "Password cannot be empty");
	}
	
	@Test
	public void TC4VerifyEmptyUser(){
		LoginPage lp = new LoginPage();
		lp.inValidLogin("admin", "", "Password cannot be empty");
	}

}
