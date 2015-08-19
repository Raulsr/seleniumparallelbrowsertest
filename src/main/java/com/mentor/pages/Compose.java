package com.mentor.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.mentor.tests.SuperTestNG;
import com.mentor.utilities.CommonFunctions;

public class Compose extends SuperTestNG{
	
	public Compose(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	CommonFunctions cf = new CommonFunctions();
	Robot robot = null;
	
	@FindBy(name="title")
	private WebElement titleField;
	
	@FindBy(name="desc")
	private WebElement descField;
	
	@FindBy(name="tags")
	private WebElement tagsField;
	
	@FindBy(xpath="//a[text()='PHOTO']")
	private WebElement addPhotoButton;
	
	@FindBy(xpath="//a[text()='VIDEO']")
	private WebElement addVideoButton;
	
	@FindBy(xpath="//input[@name='video']")
	private WebElement addVideoField;
	
	@FindBy(xpath="//a[text()='LINK']")
	private WebElement addLinkButton;
	
	@FindBy(xpath="//input[@name='link']")
	private WebElement addLinkField;
	
	@FindBy(xpath="//input[@value='DONE']")
	private WebElement doneButton; 
	
	@FindBy(xpath="//a[@class='compose-close']")
	private WebElement closeButton;
	
	//Elements for question
	@FindBy(name="tags")
	private WebElement hashtagField;
	
	
	@FindBy(xpath="//h4[@class='modal-title']")
	private WebElement composeheading;
	
	
	
	public void getPageTitle()
	{
		System.out.println(driver.getTitle());
		Reporter.log(driver.getTitle(), true);
	}
	
	/*public boolean isVisible()
	{
		if(cf.isElementDisplayed(driver, By.xpath("//div[@id='composeModal']//div[@class='toggle-post-container']//a"), 30) 
	}*/
	
	//div[contains(@class,'col-md-12 col-lg-12 col-sm-12 col-xs-12 post-list-container ng-isolate-scope')]/div[1]/div//div[@class='post-header-block']
	public boolean isPosted() {
		boolean isPosted = false;;
		WebElement xpathTest = driver.findElement(By.xpath("//div[contains(@class,'col-md-12 col-lg-12 col-sm-12 col-xs-12 post-list-container ng-isolate-scope')]//div[1]//div//div[@class='post-header-block']"));
		String s = xpathTest.getText();
		Reporter.log(s, true);
		if(cf.isElementDisplayed(driver, By.xpath("//div[contains(@class,'col-md-12 col-lg-12 col-sm-12 col-xs-12 post-list-container ng-isolate-scope')]//div[1]//div//div[@class='post-header-block']"), 30) && driver.findElement(By.xpath("//div[contains(@class,'col-md-12 col-lg-12 col-sm-12 col-xs-12 post-list-container ng-isolate-scope')]//div[1]//div//div[@class='post-header-block']")).getText().equals("AUTOMATING POST")) {
	//verify description		
			isPosted = true;
		} else
			isPosted = false;
		return isPosted;
	}
	
	
	
	
	//Compose post without adding attachments
		public void composePost()
		{
			Reporter.log("Composing post without attachment", true);
			titleField.sendKeys("automating post");
			descField.sendKeys("test description field");
			doneButton.click();
		}
		
	//Compose post with image and link
		public void composeImagePost() throws InterruptedException
		{
			Reporter.log("Composing post with image and link" , true);
			titleField.sendKeys("automating post");
			descField.sendKeys("test description field");
			try{
				robot = new Robot();
			}catch(AWTException e)
			{
				Reporter.log(e+"exception", true);
			}
			addPhotoButton.click();
			robot.mouseMove(460, 460);
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
			robot.mouseMove(1075, 750);
			Thread.sleep(5000);
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
			//Thread.sleep(30000);
			
			try{
		        WebDriverWait wait = new WebDriverWait(driver,30);
		        Thread.sleep(40000);
		    	/*addLinkButton.click();
				addLinkField.sendKeys("https://www.youtube.com/watch?v=DO8KVe00kcU");*/
		        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='DONE']")));
		        System.out.println(element);
		        element.click();
		    }catch(Throwable e){
		        System.err.println("Error came while waiting and clicking the element. "+e.getMessage());
		    }
		}
	
	//compose post with video and link
	public void composePostVideo()
	{
		Reporter.log("Composing post by adding photo and link",true);
		titleField.sendKeys("automating post");
		descField.sendKeys("adding description");
		addVideoButton.click();
		addVideoField.sendKeys("https://www.youtube.com/watch?v=DO8KVe00kcU");
		addLinkButton.click();
		addLinkField.sendKeys("https://www.youtube.com/watch?v=DO8KVe00kcU");
		doneButton.click();
	}
	
	
	
	//***************************Questions********************************************
	//Tap on comose a question
	
		public void gotocomposeQuestion()
		{
			driver.findElement(By.xpath("//a[@ng-click='addPost.togglewindow()']")).click();
		}
	
		
	public boolean isQuestionPosted() {
		boolean isQuestionPosted = false;;
		WebElement xpathTest = driver.findElement(By.xpath("(//a[contains(@href,'#/converse/details')])[1]"));
		String s = xpathTest.getText();
		Reporter.log(s, true);
		if(cf.isElementDisplayed(driver, By.xpath("(//a[contains(@href,'#/converse/details')])[1]"), 30) && driver.findElement(By.xpath("(//a[contains(@href,'#/converse/details')])[1]")).getText().contains("AUTOMATING QUESTION")) {
	//verify description		
			isQuestionPosted = true;
		} else
			isQuestionPosted = false;
		return isQuestionPosted;
	}
	
	//Compose Question without adding attachments
			public void composeQuestion()
			{
				Reporter.log("Composing Question without attachment", true);
				titleField.sendKeys("Automating Question");
				hashtagField.sendKeys(" hashtag1 hashtag2 hashtag3 hashtag4 hashtag5");
				doneButton.click(); 
			}
			
			//Compose Question with image and link
			public void composeImageQuestion() throws InterruptedException
			{
				Reporter.log("Composing post with image and link" , true);
				titleField.sendKeys("Automating Question with image and link");
				hashtagField.sendKeys(" Hashtag Image Link");
				try{
					robot = new Robot();
				}catch(AWTException e)
				{
					Reporter.log(e+"exception", true);
				}
				addPhotoButton.click();
				robot.mouseMove(460, 460);
				robot.mousePress(InputEvent.BUTTON1_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_MASK);
				robot.mouseMove(1075, 750);
				Thread.sleep(5000);
				robot.mousePress(InputEvent.BUTTON1_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_MASK);
				//Thread.sleep(30000);
				
				try{
			        WebDriverWait wait = new WebDriverWait(driver,30);
			        Thread.sleep(40000);
			    	addLinkButton.click();
					addLinkField.sendKeys("https://www.google.com");
			        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='DONE']")));
			        System.out.println(element);
			        element.click();
			    }catch(Throwable e){
			        System.err.println("Error came while waiting and clicking the element. "+e.getMessage());
			    }
			}
			
			//compose Question with video and link
			public void composeQuestionVideo()
			{
				Reporter.log("Composing post by adding photo and link",true);
				titleField.sendKeys("Automating Question with video and link");
				hashtagField.sendKeys(" Hashtag Video And Link");
				addVideoButton.click();
				addVideoField.sendKeys("https://www.youtube.com/watch?v=DO8KVe00kcU");
				addLinkButton.click();
				addLinkField.sendKeys("https://www.google.com");
				doneButton.click();
			}
			
			
}


