package com.orangehrm.tests;

import org.testng.annotations.Test;

import com.orangehrm.common.BaseSelenium;
import com.orangehrm.pages.LoginPage;

public class AddEmployeeTests extends BaseSelenium {
	
	@Test
	public void TC1VerifyAddedEmployee(){
		
		LoginPage lp = new LoginPage();
		lp.checkLoginCredential("admin", "admin")
			.checkWelcomeText("Welcome Admin")
				.navigateToPIMModule()
					.navigateToAddEmployee()
						.addEmployee("Amar", "Singh", "AdminPaswd", "AdminPaswd", "Enabled")
							.checkEmployeeAdded("Amar", "Singh");

						
	}

}
