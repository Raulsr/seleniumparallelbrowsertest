package com.mentor.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mentor.pages.LogInPage;
import com.mentor.pages.WelcomePage;

public class LoginTest extends SuperTestNG{
	
	@Test
	public void test_LoginTest()
	{
		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.clickLogin();
		LogInPage loginPage = new LogInPage(driver);
		loginPage.getTitle();
		Assert.assertTrue(loginPage.isLoginOverlayDisplayed(), "Login Overlay Displayed");
		Reporter.log("LogIn Overlay", true);
		loginPage.login();
	}

	@Test
	public void test_invalid_LoginTest()
	{
		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.clickLogin();
		LogInPage loginPage = new LogInPage(driver);
		loginPage.getTitle();
		loginPage.invalidpassword();
		String ele = driver.findElement(By.xpath("//div[@class='form-login-container login-form']//div[text()='Password is incorrect']")).getText();
		System.out.println(ele);
		Assert.assertEquals("Password is incorrect", ele);
		System.out.println("Password incorrect verified");



	}
}
