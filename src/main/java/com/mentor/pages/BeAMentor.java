package com.mentor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mentor.tests.SuperTestNG;

import junit.framework.Assert;

public class BeAMentor extends SuperTestNG 
{
	
	public BeAMentor(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Be a mentor
	@FindBy(xpath="//img[@id='bMentoricn']")
	private WebElement mentor;
		
	//write description
	@FindBy(xpath="//textarea[@ng-model='mentor.description']")
	private WebElement descrption;
		
	//tap on mentor button
	@FindBy(xpath="//button[@id='tobeMentor']")
	private WebElement mentorbutton;
	
	//tapping on news and updates
	@FindBy(xpath="//a[@class='nav-border-right']")
	
	private WebElement news;

	private WebDriver driver;
	public void MentorRequest() throws InterruptedException
	{ 
		mentor.click();
		Thread.sleep(5000);
		descrption.sendKeys("i want to be a mentor");
		mentorbutton.click();
		Thread.sleep(5000);
	
	}

}
