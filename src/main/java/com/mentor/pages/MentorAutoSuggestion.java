package com.mentor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mentor.tests.SuperTestNG;
import com.mentor.utilities.CommonFunctions;

public class MentorAutoSuggestion extends SuperTestNG{
	
	CommonFunctions cf = new CommonFunctions();
	public MentorAutoSuggestion(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'NEXT')]")
	private WebElement nextButton;
	
	public boolean isSuggestionOverlayDisplayed() 
	{
		boolean isSuggestionOverlay = false;
		if(cf.isElementDisplayed(driver, By.xpath("//div[@id='composeModal']"), 30)) 
		{
			isSuggestionOverlay = true;
		} 
		return isSuggestionOverlay;
	}
	
	public void skipSuggestion()
	{
		nextButton.click();
	}
}
