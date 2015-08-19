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

public class WelcomePage extends SuperTestNG{
	
	CommonFunctions cf = new CommonFunctions();
	
	public WelcomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='name']")
	private WebElement fullName;
	
	@FindBy(name="selectCountry")
	private WebElement selectCountry;
	
	@FindBy(name="phone")
	private WebElement phone;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(name="selectIndustry")
	private WebElement industry;
	
	@FindBy(name="sourceList")
	private WebElement sourceList;
	
	@FindBy(xpath="//button[contains(text(),'SIGN UP NOW')]")
	private WebElement signUpNowButton;
	
	
	@FindBy(xpath="//span[contains(text(),'GET STARTED')]")
	private WebElement getStarted;
	
	@FindBy(xpath="//a[contains(text(),'SIGN UP')]")
	private WebElement signUpButton;
	
	@FindBy(xpath="//a[contains(text(),'LOGIN')]")
	private WebElement loginButton;
	
	public void clickGetStarted()
	{
		getStarted.click();
	}
	
	public void clickSignUp()
	{
		signUpButton.click();
	}
	
	public void clickLogin()
	{
		loginButton.click();
	}
	
	public void signUpNow()
	{
		Reporter.log("Entering details to signup", true);
		fullName.sendKeys("Sharath");
		Select select = new Select(selectCountry);
		select.selectByVisibleText("India");
		phone.sendKeys("996699664");
		password.sendKeys("aaa111");
		Select selectInd = new Select(industry);
		selectInd.selectByVisibleText("Financial Services");
		Select selectAbout = new Select(sourceList);
		selectAbout.selectByValue("3");
		signUpNowButton.click();
	}
	
	public boolean isSignUpOverlayDisplayed() 
	{
		boolean isSignUpOverlay = false;
		if(cf.isElementDisplayed(driver, By.xpath("//div[@id='composeModal']"), 30)) 
		{
			isSignUpOverlay = true;
		} 
		return isSignUpOverlay;
	}
}
