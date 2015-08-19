package com.mentor.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mentor.pages.Compose;
import com.mentor.pages.LeftSideNavigation;
import com.mentor.pages.LogInPage;
import com.mentor.pages.WelcomePage;

public class ComposeDefQuestionTest extends SuperTestNG
{

	@Test	
	public void test_ComposeDefQuestion() throws InterruptedException
	{
		WelcomePage welcomePage = new WelcomePage(driver);
		LogInPage loginPage = new LogInPage(driver);
		LeftSideNavigation leftSideNav = new LeftSideNavigation(driver);
		Compose compose = new Compose(driver);
		welcomePage.clickLogin();
		loginPage.getTitle();
		
		Assert.assertTrue(loginPage.isLoginOverlayDisplayed(), "Login Overlay Displayed");
		Reporter.log("LogIn Overlay", true);
		loginPage.login();	
		leftSideNav.clickCompose();
		compose.gotocomposeQuestion();
		compose.composeQuestion();
		
		Assert.assertTrue(compose.isQuestionPosted(), "Post Title and description Verified");
		Reporter.log("New Question created successfully", true);
		
}
}
