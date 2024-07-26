package com.factorial.testCases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.factorial.utilities.ReadConfig;
import com.google.common.io.Files;


public class BaseClass {

	ReadConfig readconfig = new ReadConfig();
	
	public String baseURL = readconfig.getApplicationURL() ;
	public static WebDriver driver;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		if (br.equals("chrome")) {
		System.setProperty("Webdriver.chrome.driver",readconfig.getChromePath());
		driver = new ChromeDriver();
		}
		
		else if (br.equals("edge")) {
			driver = new EdgeDriver();
		}
		driver.get(baseURL);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreenshot (String name) {
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(f, new File("C:\\Users\\Admin\\Desktop\\GrowSkill IT\\GS IT Batch Codes\\CapstoneProject\\Screenshots\\" + name + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
