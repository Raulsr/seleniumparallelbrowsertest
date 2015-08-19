package com.mentor.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mentor.pages.BeAMentor;
import com.mentor.pages.LeftSideNavigation;
import com.mentor.pages.LogInPage;
import com.mentor.pages.MentorAutoSuggestion;
import com.mentor.pages.SetUpYourProfile;
import com.mentor.pages.SignUpPage;
import com.mentor.pages.WelcomePage;

public class BeAMentorTest extends SuperTestNG
{

	@Test
	
	public void test_ClickBeAMentor() throws InterruptedException
	{
		//to test this we are signing up
		Reporter.log("SignUp Test Started", true);
		new WelcomePage(driver).clickSignUp();
		SignUpPage signUpPage = new SignUpPage(driver);
		Assert.assertTrue(signUpPage.isSignUpOverlayDisplayed(), "Sign Up overlay is displayed");
		Reporter.log("SignUp overlay", true);
		signUpPage.signUpNow();
		MentorAutoSuggestion mentorSuggestion = new MentorAutoSuggestion(driver);
		Assert.assertTrue(mentorSuggestion.isSuggestionOverlayDisplayed(), "Mentor suggestion is displayed");
		Reporter.log("Mentor Suggestion overlay displayed", true);
		new MentorAutoSuggestion(driver).skipSuggestion();
		SetUpYourProfile setupProfile = new SetUpYourProfile(driver);
		Assert.assertTrue(setupProfile.isSetupOverlayDisplayed(), "Setup Overlay Displayed");
		Reporter.log("Setup Overlay Displayed", true);
		setupProfile.skipSetup();
		Reporter.log("USer created successfully", true);
		//validating be a mentor.
		BeAMentor beamentor=new BeAMentor(driver);
		beamentor.MentorRequest();
		String ele = driver.findElement(By.xpath("//div[text()='request submitted successfully']")).getText();
		System.out.println(ele);
		Assert.assertEquals("request submitted successfully", ele);
		System.out.println("Applied for Mentorship");
		
	}	
	
}
