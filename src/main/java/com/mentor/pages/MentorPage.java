package com.mentor.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.mentor.tests.SuperTestNG;
import com.mentor.utilities.CommonFunctions;

public class MentorPage extends SuperTestNG{
	CommonFunctions cf = new CommonFunctions();
	public MentorPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	public void listMentors()
	{
		List<WebElement> lstMentors = driver.findElements(By.xpath("//div[@class='col-xs-12 col-sm-12 col-md-6 col-lg-4 padding-0 mentor ng-scope']"));
		for(int j=0;j<lstMentors.size();j++)
		{
			System.out.println("\n");
			WebElement eduDetails = lstMentors.get(j);
			Reporter.log(eduDetails.getText(), true);
		}
	}
	
	public void verifyMentorPage()
	{
		String ele = driver.findElement(By.xpath("//input[@placeholder='Find a mentor']")).getAttribute("placeholder");
		System.out.println(ele);
		//Assert.assertEquals("Find a men", ele);
		Assert.assertEquals("Find a mentor", ele);
		System.out.println("Mentor Page Verified");
	}
	
	//Test written by Anupama
	
	
	public void mentorClick()
	{
		
		//Fetching all the mentors into a list
		List<WebElement> lstMentor = driver.findElements(By.xpath("//h3[@class='ng-binding']"));
		//Getting the size of the list
		int sizeMentor = lstMentor.size();
		//creating a random function
		Random r = new Random();
		//storing the list into an integer variable
		int k = r.nextInt(sizeMentor);
		//Clicking the mentor.
		String str=lstMentor.get(k).getText();
		System.out.println("Clicking on a mentor"+str);
		lstMentor.get(k).click();
		String str1=driver.findElement(By.xpath("//h2[@class='ng-binding']")).getText();
		System.out.println("Clicked Mentor Profile"+str1);					
		if(str.equalsIgnoreCase(str1))
		{
			System.out.println("Mentors list passed");
			Assert.assertEquals(str, str1);			
		} 
		else
		{
			System.out.println("Fail");
			Assert.fail();			
		}
		
		
		
		
		
		
		
		
	}
}
