package com.mentor.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mentor.pages.LeftSideNavigation;
import com.mentor.pages.LogInPage;
import com.mentor.pages.ProfilePage;
import com.mentor.pages.WelcomePage;

public class EditProfilePageTest extends SuperTestNG{
	@Test
	public void test_EditProfilePageTest()
	{
		WelcomePage welcomePage = new WelcomePage(driver);
		LogInPage loginPage = new LogInPage(driver);
		LeftSideNavigation leftSideNav = new LeftSideNavigation(driver);
		ProfilePage profilePage = new ProfilePage(driver);
		welcomePage.clickLogin();
		loginPage.getTitle();
		Assert.assertTrue(loginPage.isLoginOverlayDisplayed(), "Login Overlay Displayed");
		Reporter.log("LogIn Overlay", true);
		loginPage.login();	
		leftSideNav.clickUser();
		profilePage.clickEdit();
		//profilePage.addExperience();
		profilePage.addSkills();
		//profilePage.addEducation();
		
	}
}
