package com.factorial.testCases;

import org.testng.annotations.Test;

import com.factorial.pagesObjects.HomePage;

public class TC04_PrivacyBug extends BaseClass{

	@Test
	public void bug() {
		HomePage hp = new HomePage(driver);
		hp.privacyBug("This is the privacy document. We are not yet ready with it. Stay tuned!");
		captureScreenshot("Privacy Bug");
	}
	
	
}
