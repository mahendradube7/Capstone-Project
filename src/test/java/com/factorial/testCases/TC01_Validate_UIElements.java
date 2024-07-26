package com.factorial.testCases;

import org.testng.annotations.Test;

import com.factorial.pagesObjects.HomePage;

public class TC01_Validate_UIElements extends BaseClass {

	
	@Test
	public void validateUI () {
		
		HomePage hp = new HomePage(driver);
		
		hp.calculateButtonDisplayed(true);
		hp.calculateButtonEnabled(true);
		hp.privacyDisplayed(true);
		hp.privacyEnabled(true);
		hp.termsDisplayed(true);
		hp.termsEnabled(true);
		hp.textBoxDisplayed(true);
		hp.textBoxEnabled(true);
		captureScreenshot("UI");
		
	}
	
	
	
	
}
