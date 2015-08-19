package com.mentor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LeftSideNavigation {
	
	public LeftSideNavigation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@title='Compose Post/Question']")
	private WebElement composePost; 
	
	@FindBy(xpath="//div[@class='img-rel']")
	private WebElement clickUserProfile; 
	
	@FindBy(xpath="(//a[@href='#/converse'])[2]")
	private WebElement clickConversation;
	
	@FindBy(xpath="//button[@title='logout']")
	private WebElement clickLogoutButton;
	
	@FindBy(xpath="//img[@id='mentorsicn']")
	private WebElement clickMentorsButton;

	
	public void clickCompose()
	{
		Reporter.log("Clicking on Compose", true);
		composePost.click();
	}
	
	public void clickMentor()
	{
		Reporter.log("Tapping on Mentor button", true);
		clickMentorsButton.click();
	}
	
	public void clickUser()
	{
		Reporter.log("Tapping on User", true);
		clickUserProfile.click();
	}
	
	public void clickConversation()
	{
		Reporter.log("Tapping on Conversation", true);
		clickConversation.click();
	}
	
	public void clickLogout()
	{
		Reporter.log("Clicking on logout", true);
		clickLogoutButton.click();
	}
}
