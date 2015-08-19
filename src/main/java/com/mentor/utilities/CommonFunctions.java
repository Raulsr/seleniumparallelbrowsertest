package com.mentor.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;

import com.mentor.tests.SuperTestNG;


//To verify window/overlay display
public class CommonFunctions extends SuperTestNG{

	public boolean isElementDisplayed(SearchContext se, By by, int timeout) {
		Boolean toReturn = null;
		try {
			driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
			toReturn = se.findElement(by).isDisplayed();
		} catch(NoSuchElementException e) {
			toReturn = false;
		}
		return toReturn;
	}
}
