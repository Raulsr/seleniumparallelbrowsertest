package com.mentor.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class SuperTestNG {
	
	public static WebDriver driver = null;
	@BeforeMethod 
	@Parameters("browser")
	public void setup(String browser)
	{
		if(browser.equals("firefox")) {
			Reporter.log("Launching browser: " + browser, true);
			driver = new FirefoxDriver();
		} else if(browser.equals("chrome")) {
			Reporter.log("Launching browser: " + browser, true);
			driver = new ChromeDriver();
		}else if (browser.equals("safari")){
			Reporter.log("Launching browser: " + browser, true);
			driver = new SafariDriver();
		}
		else if(browser.equals("") || browser == null) {
			Reporter.log("No browser value is passed. Launching default browser FIREFOX", true);
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://mm-web-ppe.mara.com/");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
