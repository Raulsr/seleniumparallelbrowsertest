package com.mentor.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mentor.pages.HomePage;
import com.mentor.pages.LogInPage;
import com.mentor.pages.WelcomePage;

public class LikeCommentCountTest extends SuperTestNG{
	
	@Test
	public void test_LikePostTest()
	{
		WelcomePage welcomePage = new WelcomePage(driver);
		LogInPage loginPage = new LogInPage(driver);
		HomePage homePage = new HomePage(driver);
		welcomePage.clickLogin();
		loginPage.getTitle();
		Assert.assertTrue(loginPage.isLoginOverlayDisplayed(), "Login Overlay Displayed");
		Reporter.log("LogIn Overlay", true);
		loginPage.login();
		homePage.getLikeCommentcount();
		//homePage.clickPost();
	}
}
