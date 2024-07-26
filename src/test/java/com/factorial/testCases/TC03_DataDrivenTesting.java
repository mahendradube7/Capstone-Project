package com.factorial.testCases;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.factorial.pagesObjects.HomePage;

public class TC03_DataDrivenTesting extends BaseClass {

	@DataProvider(name = "Factorial Data")
	public Object[] data() {

		Object[] obj = new Object[7];

		obj[0] = "4";
		obj[1] = "5";
		obj[2] = "6";
		obj[3] = "7";
		obj[4] = "8";
		obj[5] = "9";
		obj[6] = "10";

		return obj;

	}

	@Test(dataProvider = "Factorial Data")
	public void factorialDDT(String fact) {
		HomePage hp = new HomePage(driver);
		hp.enterFact(fact);
		captureScreenshot("Factorial Result");
	}

}
