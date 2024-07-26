package com.factorial.testCases;

import org.testng.annotations.Test;

import com.factorial.pagesObjects.HomePage;

public class TC02_ValidatePlaceholder extends BaseClass {

	@Test
	public void verifyPlaceholder() {
		HomePage hp = new HomePage(driver);
		hp.textBoxPlaceholder("Enter an integer");
		captureScreenshot("Placeholder");
	}

	@Test
	public void verifyURL() {
		HomePage hp = new HomePage(driver);
		hp.urlContains("https");
		captureScreenshot("URL");

	}

	@Test
	public void verifyTitle() {
		captureScreenshot("Title");
		HomePage hp = new HomePage(driver);
		hp.title("Factorial");

	}

}
