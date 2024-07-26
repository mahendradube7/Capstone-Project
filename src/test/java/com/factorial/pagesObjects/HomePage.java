package com.factorial.pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class HomePage {

	WebDriver ldriver;

	public HomePage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "number") WebElement textBox;
	@FindBy(xpath = "//button[text()='Calculate!']") WebElement calculateButton;
	@FindBy(xpath = "//a[text() = 'Terms and Conditions']") WebElement terms;
	@FindBy(xpath = "//a[text() = 'Privacy']") WebElement privacy;
	@FindBy(xpath = "//p[@id = 'resultDiv']") WebElement factorial ;
	@FindBy(xpath = "//body[text()]") WebElement privacyText ;
	

	public void textBoxDisplayed(boolean exp) {
		boolean tbDisplayed = textBox.isDisplayed();
		Assert.assertEquals(tbDisplayed, exp);
	}

	public void textBoxEnabled(boolean exp) {
		boolean tbEnabled = textBox.isEnabled();
		Assert.assertEquals(tbEnabled, exp);
	}

	public void calculateButtonDisplayed(boolean exp) {
		boolean cbDisplayed = calculateButton.isDisplayed();
		Assert.assertEquals(cbDisplayed, exp);
	}

	public void calculateButtonEnabled(boolean exp) {
		boolean cbEnabled = calculateButton.isEnabled();
		Assert.assertEquals(cbEnabled, exp);
	}

	public void termsDisplayed(boolean exp) {
		boolean termDisplayed = terms.isDisplayed();
		Assert.assertEquals(termDisplayed, exp);
	}

	public void termsEnabled(boolean exp) {
		boolean termEnabled = terms.isEnabled();
		Assert.assertEquals(termEnabled, exp);
	}

	public void privacyDisplayed(boolean exp) {
		boolean priDisplayed = privacy.isDisplayed();
		Assert.assertEquals(priDisplayed, exp);
	}

	public void privacyEnabled(boolean exp) {
		boolean priEnabled = privacy.isEnabled();
		Assert.assertEquals(priEnabled, exp);
	}

	public void title(String exp) {
		String title = ldriver.getTitle();
		System.out.println("Title = " + title);
		Assert.assertEquals(title, exp);
	}

	public void textBoxPlaceholder(String exp) {
		String placeHolder = textBox.getAttribute("placeholder");
		System.out.println("Placeholder for Textbox = " + placeHolder);
		Assert.assertEquals(placeHolder, exp);
	}

	public void urlContains(String exp) {
		String curl = ldriver.getCurrentUrl();
		System.out.println("URL = " + curl);
		Assert.assertEquals(curl.contains(exp), true);
	}

	public void enterFact(String fact) {
		textBox.sendKeys(fact);
		calculateButton.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String result = factorial.getText();
		System.out.println(result);
		int num = Integer.parseInt(fact);
		int f = 1;
		while (num != 0) {

			f = num * f;
			num--;
		}
		
		String expectedResult = "The factorial of " + fact + " is: " + f;
		System.out.println(expectedResult);
		textBox.clear();
		Assert.assertEquals(result , expectedResult );
	}
	
	public void privacyBug(String exp) {
		
		privacy.click();
		String privacyMessage = privacyText.getText();
		System.out.println("Privacy Message = " + privacyMessage);
		Assert.assertEquals(privacyMessage , exp );
	}

}
