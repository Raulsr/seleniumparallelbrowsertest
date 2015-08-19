package com.mentor.pages;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.mentor.tests.SuperTestNG;
import com.mentor.utilities.CommonFunctions;

	
public class SignUpPage extends SuperTestNG{
		
	CommonFunctions cf = new CommonFunctions();
	
	public SignUpPage(WebDriver driver)
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
	private WebElement signUpButton;
	
	public void signUpNow()
	{
		Reporter.log("Entering details to signup", true);
		fullName.sendKeys("Sharath Hatter");
		Select select = new Select(selectCountry);
		select.selectByVisibleText("India");
		Random r = new Random();
		int k = r.nextInt(100000000);
		String s = Integer.toString(k);
		phone.sendKeys(s);
		password.sendKeys("aaa111");
		Select selectInd = new Select(industry);
		selectInd.selectByVisibleText("Financial Services");
		Select selectAbout = new Select(sourceList);
		selectAbout.selectByValue("3");
		signUpButton.click();
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

