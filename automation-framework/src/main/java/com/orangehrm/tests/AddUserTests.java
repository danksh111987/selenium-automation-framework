package com.orangehrm.tests;

import org.testng.annotations.Test;

import com.orangehrm.common.BaseSelenium;
import com.orangehrm.pages.LoginPage;

public class AddUserTests extends BaseSelenium{

	@Test(enabled=true)
	public void TC1VerifyAddNewUser(){
		
		LoginPage lp = new LoginPage();
		lp.checkLoginCredential("admin", "admin")
			.checkWelcomeText("Welcome Admin")
				.navigateToAdminModule()
					.navigateToAddUser()
						.addNewUser("ESS", "Anup Bagal", "Enabled", "Ramk123", "Ramk123")
							.checkAddedUser();
	}
	
	//check cancel button navigating to adminModule page from Adduser page
	@Test(enabled=true)
	public void TC2VerifyCancelButton(){
		LoginPage lp = new LoginPage();
		lp.checkLoginCredential("admin", "admin")
			.checkWelcomeText("Welcome Admin")
				.navigateToAdminModule()
					.navigateToAddUser()
						.cancelNewUser()
							.checkAdminModulePageLoaded();
	}
}
