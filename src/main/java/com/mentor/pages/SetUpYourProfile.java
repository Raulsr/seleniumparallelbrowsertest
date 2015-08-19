package com.mentor.pages;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.mentor.tests.SuperTestNG;
import com.mentor.utilities.CommonFunctions;

public class SetUpYourProfile extends SuperTestNG{
	CommonFunctions cf = new CommonFunctions();
	public SetUpYourProfile(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@class='cls-btn']")
	private WebElement skipSetup;
	
	@FindBy(xpath="//a[text()='SETUP WITH LINKEDIN']")
	private WebElement linkedinSetupButton;
	
	
	public boolean isSetupOverlayDisplayed()
	{
		boolean setupOverlay= false;
		if(cf.isElementDisplayed(driver, By.xpath("//div[@id='setup-profile']"), 30))
			setupOverlay = true;
		return setupOverlay;
	}
	
	public void skipSetup()
	{
		skipSetup.click();
	}
	
	public void linkedinSetup()
	{
		linkedinSetupButton.click();
		//Other method to handle windows
		/*for(String windows:driver.getWindowHandles())
		{
			driver.switchTo().window(windows);
			WebElement element = driver.findElement(By.id("session_key-oauthAuthorizeForm"));
			if(element!=null){ break;}
		}
		
		driver.findElement(By.id("session_key-oauthAuthorizeForm")).sendKeys("sharath1203@gmail.com");
		driver.findElement(By.id("session_password-oauthAuthorizeForm")).sendKeys("sharaththeking");
		driver.findElement(By.name("authorize")).click();
		driver.switchTo().defaultContent();*/
	
	Set<String> allwhs = driver.getWindowHandles();
	Iterator<String> iterator = allwhs.iterator();
	String MwinID = iterator.next();// Window Handle of Mentor page
	String LwinID = iterator.next();// Window Handle of Mentor page
	driver.switchTo().window(LwinID);// Switch to Linkedin Window
	Reporter.log(driver.getTitle(), true);
	driver.findElement(By.id("session_key-oauthAuthorizeForm")).sendKeys("rahulr.rawat81@gmail.com");
	driver.findElement(By.id("session_password-oauthAuthorizeForm")).sendKeys("hash@222");
	driver.findElement(By.name("authorize")).click();
	driver.switchTo().window(MwinID); // Swithing to main window
	}
	
	public void getLinkedinDetails()
	{
		
	}
	
}
