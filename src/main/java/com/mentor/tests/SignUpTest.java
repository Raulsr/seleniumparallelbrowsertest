package com.mentor.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mentor.pages.MentorAutoSuggestion;
import com.mentor.pages.SetUpYourProfile;
import com.mentor.pages.SignUpPage;
import com.mentor.pages.WelcomePage;

public class SignUpTest extends SuperTestNG{
	@Test
	public void test_SignUpTest()
	{
		Reporter.log("SignUp Test Started", true);
		new WelcomePage(driver).clickSignUp();
		SignUpPage signUpPage = new SignUpPage(driver);
		Assert.assertTrue(signUpPage.isSignUpOverlayDisplayed(), "Sign Up overlay is displayed");
		Reporter.log("SignUp overlay", true);
		/*To verify country
		String strCountry = driver.findElement(By.name("selectCountry")).getText();
		Assert.assertEquals("India", strCountry);*/
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
		}
}
