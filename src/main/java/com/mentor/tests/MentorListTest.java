package com.mentor.tests;

import org.testng.annotations.Test;

import com.mentor.pages.LeftSideNavigation;
import com.mentor.pages.LogInPage;
import com.mentor.pages.MentorPage;
import com.mentor.pages.WelcomePage;

public class MentorListTest extends SuperTestNG{

	@Test
	public void test_MentorListTest()
	{
		WelcomePage welcomePage = new WelcomePage(driver);
		LogInPage loginPage = new LogInPage(driver);
		LeftSideNavigation leftSideNav = new LeftSideNavigation(driver);
		MentorPage mentorPage = new MentorPage(driver);
		welcomePage.clickLogin();
		loginPage.getTitle();
		loginPage.login();	
		leftSideNav.clickMentor();
		//mentorPage.listMentors();
		mentorPage.verifyMentorPage();
	}
	
	@Test
	public void test_navigateToMentorProfile()
	{
		
		WelcomePage welcomePage = new WelcomePage(driver);
		LogInPage loginPage = new LogInPage(driver);
		LeftSideNavigation leftSideNav = new LeftSideNavigation(driver);
		MentorPage mentorPage = new MentorPage(driver);
		welcomePage.clickLogin();
		loginPage.getTitle();
		loginPage.login();	
		leftSideNav.clickMentor();
		mentorPage.mentorClick();
		
		
		
	}
}
