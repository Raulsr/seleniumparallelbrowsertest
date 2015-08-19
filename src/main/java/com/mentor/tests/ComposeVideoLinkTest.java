package com.mentor.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mentor.pages.Compose;
import com.mentor.pages.LeftSideNavigation;
import com.mentor.pages.LogInPage;
import com.mentor.pages.WelcomePage;

public class ComposeVideoLinkTest extends SuperTestNG{
	
	@Test
	public void test_ComposeVideoLinkTest()
	{
		WelcomePage welcomePage = new WelcomePage(driver);
		LogInPage loginPage = new LogInPage(driver);
		LeftSideNavigation leftSideNavigation = new LeftSideNavigation(driver);
		Compose compose = new Compose(driver);
		welcomePage.clickLogin();
		loginPage.getTitle();
		Assert.assertTrue(loginPage.isLoginOverlayDisplayed(), "Login Overlay Displayed");
		Reporter.log("LogIn Overlay", true);
		loginPage.login();
		leftSideNavigation.clickCompose();
		compose.composePostVideo();
		Reporter.log("Content posted with video", true);
		/*Assert.assertEquals(compose.isPosted(), "AUTOMATING POST");
		Reporter.log("Content verified after post", true);*/
	}

}
