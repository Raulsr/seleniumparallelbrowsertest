package com.mentor.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.mentor.tests.SuperTestNG;
import com.mentor.utilities.CommonFunctions;


public class PostDetailPage extends SuperTestNG{


	public PostDetailPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	CommonFunctions cf = new CommonFunctions();

	@FindBy(xpath = "//h2[@class='ng-binding']")
	private WebElement postheading;
	
	@FindBy(xpath = "//p[@class='ng-binding']")
	private WebElement postdescription;
	
	@FindBy(xpath = "//span[@class='media-heading ng-binding']")
	private WebElement postauthor;
	
	@FindBy(xpath = "//span[@class='ago ng-binding']")
	private WebElement postcreated;
	
	@FindBy(xpath = "//span[@class='counter ng-binding']")
	private WebElement postlikecount;
	
	@FindBy(xpath = "//span[@class='counter ng-binding ng-scope']")
	private WebElement postcommentcount;
	
	
	public void getPostDetails()
	{
      
      Reporter.log("PostTitle : "+ postheading.getText(), true );
      Reporter.log("postdescription : "+ postdescription.getText(), true );
      Reporter.log("postauthor : "+ postauthor.getText(), true );
      Reporter.log("postcreated : "+ postcreated.getText(), true );
      Reporter.log("postlikecount : "+ postlikecount.getText(), true );
      Reporter.log("postcommentcount : "+ postcommentcount.getText(), true );
      
	}


	public void commentPost(){
		driver.findElement(By.xpath("//textarea[@placeholder='Your Comment']")).sendKeys("This is the new comment:I am Commenting now");
		driver.findElement(By.xpath("//input[@value='Publish Comment']")).click();
	}
	
	public void editComment() throws InterruptedException{
		//Checking for number of comments
		List<WebElement> lstcmnt = driver.findElements(By.xpath("//p[@ng-bind-html='commentRecord.content']"));
		Reporter.log("Number of Comments- >"+lstcmnt.size(), true );
		
		//post a comment
		commentPost();
		Thread.sleep(5,5);
		
		//Checking foe edit icons
		List<WebElement> editicon = driver.findElements(By.xpath("//a[@class='edit-icn']"));
		Reporter.log("Number of comments with edit icons->"+editicon.size(),true);
		Thread.sleep(3000);
		
		//Edit process
		driver.findElement(By.xpath("//a[@class='edit-icn']")).click();
		driver.findElement(By.xpath("//textarea[@ng-model='editCommentctrl.commentContent']")).clear();
		driver.findElement(By.xpath("//textarea[@ng-model='editCommentctrl.commentContent']")).sendKeys("My new comment");
		driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
		Reporter.log("Edited",true);
	   
	}
	
	
	public void deletePost() throws InterruptedException{
		//Checking for number of comments
		List<WebElement> lstcmnt = driver.findElements(By.xpath("//p[@ng-bind-html='commentRecord.content']"));
		Reporter.log("Number of Comments Before  - >"+lstcmnt.size(), true );
		
		//post a comment
		commentPost();
		Thread.sleep(5,5);
	
		//going back
		driver.navigate().back();
		
		//Checking for number of comments after adding a new one//needs to be optimized
		List<WebElement> lstPosts = driver.findElements(By.xpath("//div[contains(@class,'col-md-12 col-lg-12 col-sm-12 col-xs-12 post-list-container ng-isolate-scope')]/div/div"));
		int i = 1, toBeClicked = 2;
		for(WebElement we:lstPosts)
		{
			if(i==toBeClicked)
			{
				we.findElement(By.xpath("//a[@class='continue-post']")).click();
				break;
			}
			i++;
		}
		List<WebElement> num = driver.findElements(By.xpath("//p[@ng-bind-html='commentRecord.content']"));
		Reporter.log("Comments now->"+num.size(),true);
		List<WebElement> deleteicon = driver.findElements(By.xpath("//a[@class='delete-icn']"));
		Reporter.log("Number of comments with delete icons->"+deleteicon.size(),true);
		for(WebElement we:deleteicon){
			Reporter.log(we.findElement(By.xpath("//p[@ng-bind-html='commentRecord.content']")).getText(), true);
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//a[@title='Delete'])[1]")).click();
		}
		Reporter.log("Number of Comments after deletion- >"+lstcmnt.size(), true );
		Reporter.log("TODO:Asserting if the same comment is deleted");
	}

  
}
