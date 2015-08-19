package com.mentor.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mentor.pages.MentorAutoSuggestion;
import com.mentor.pages.SetUpYourProfile;
import com.mentor.pages.SignUpPage;
import com.mentor.pages.WelcomePage;

public class LinkedinSetupProfileTest extends SuperTestNG{
	
	@Test
	public void test_LinkedinSetupProfileTest()
	{
		WelcomePage welcome = new WelcomePage(driver);
		SignUpPage signUpPage = new SignUpPage(driver);
		MentorAutoSuggestion mentorSuggestion = new MentorAutoSuggestion(driver);
		SetUpYourProfile setupProfile = new SetUpYourProfile(driver);
		welcome.clickSignUp();
		Assert.assertTrue(signUpPage.isSignUpOverlayDisplayed(), "Sign Up overlay is displayed");
		Reporter.log("SignUp overlay", true);
		signUpPage.signUpNow();
		Assert.assertTrue(mentorSuggestion.isSuggestionOverlayDisplayed(), "Mentor suggestion is displayed");
		Reporter.log("Mentor Suggestion overlay displayed", true);
		mentorSuggestion.skipSuggestion();
		Assert.assertTrue(setupProfile.isSetupOverlayDisplayed(), "Setup Overlay Displayed");
		setupProfile.linkedinSetup();
		Reporter.log("User succesfully created profile using linkedin", true);
	}

}
