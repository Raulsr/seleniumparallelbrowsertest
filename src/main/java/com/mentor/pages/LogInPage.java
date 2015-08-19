package com.mentor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.mentor.tests.SuperTestNG;
import com.mentor.utilities.CommonFunctions;

public class LogInPage extends SuperTestNG {
	
	CommonFunctions cf = new CommonFunctions();
	public LogInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
//	@FindBy(name="selectCountry")
//	private WebElement selectCountry;
	
	@FindBy(xpath="//form[@name='loginForm']//select[@name='selectCountry']")
	private WebElement selectCountry;
	
	@FindBy(xpath="//form[@name='loginForm']//input[@name='phone']")
	private WebElement phone;
	
	@FindBy(xpath="//form[@name='loginForm']//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'LOG IN NOW')]")
	private WebElement loginButton;
	
	public void login()
	{
		Reporter.log("Login Process Started", true);
		Select select = new Select(selectCountry);
		select.selectByVisibleText("India");
		phone.sendKeys("9739739792");
		password.sendKeys("aaa111");
		loginButton.click();
		Reporter.log("Login Process Completed", true);
	}
	public void invalidpassword()
	{
		Reporter.log("Login Process Started", true);
		Select select = new Select(selectCountry);
		select.selectByVisibleText("India");
		phone.sendKeys("9739739792");
		password.sendKeys("xxx111");
		loginButton.click();
		Reporter.log("Login Process Completed", true);
	}

	public void getTitle()
	{
		Reporter.log(driver.getTitle(), true);
	}
	
	public boolean isLoginOverlayDisplayed() 
	{
		boolean isLoginOverlay = false;
		if(cf.isElementDisplayed(driver, By.xpath("//div[@id='composeModal']"), 30)) 
		{
			isLoginOverlay = true;
		} 
		return isLoginOverlay;
	}
}
