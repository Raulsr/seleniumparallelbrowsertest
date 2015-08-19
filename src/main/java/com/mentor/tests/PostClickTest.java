package com.mentor.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mentor.pages.HomePage;
import com.mentor.pages.LogInPage;
import com.mentor.pages.PostDetailPage;
import com.mentor.pages.WelcomePage;

public class PostClickTest extends SuperTestNG {
	
	@Test
	public void test_PostClickTest() throws InterruptedException
	{
		WelcomePage welcomePage = new WelcomePage(driver);
		LogInPage loginPage = new LogInPage(driver);
		HomePage homePage = new HomePage(driver);
		welcomePage.clickLogin();
		loginPage.getTitle();
		Assert.assertTrue(loginPage.isLoginOverlayDisplayed(), "Login Overlay Displayed");
		Reporter.log("LogIn Overlay", true);
		loginPage.login();
		homePage.clickPost();
		PostDetailPage detail=new PostDetailPage(driver);
		//detail.commentPost();
		//detail.deletePost();
		detail.editComment();
	}
}
