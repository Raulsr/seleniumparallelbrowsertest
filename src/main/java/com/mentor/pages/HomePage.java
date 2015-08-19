package com.mentor.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.mentor.tests.SuperTestNG;
import com.mentor.utilities.CommonFunctions;

public class HomePage extends SuperTestNG{
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	CommonFunctions cf = new CommonFunctions();
	
@FindBy(xpath="")
private WebElement readFurtherLink;

@FindBy(xpath=".//a[contains(@class,'heart-bg-like')]")
private WebElement likeButton;
	
@FindBy(className="dropdown-toggle")
private WebElement reportDropdown;

@FindBy(className="dropdown-menu")
private WebElement clickReport;

@FindBy(xpath=".//a[(text()='Delete this Post')]")
private WebElement deletePost;

//To click on Username
public void userNameClick()
{
	List<WebElement> lstPosts = driver.findElements(By.xpath("//div[contains(@class,'col-md-12 col-lg-12 col-sm-12 col-xs-12 post-list-container ng-isolate-scope')]/div/div"));
	Reporter.log("Number of User Thumbnails ->"+lstPosts.size(), true );
	List<WebElement> lstNames = driver.findElements(By.xpath("//div[contains(@class,'col-md-12 col-lg-12 col-sm-12 col-xs-12 post-list-container ng-isolate-scope')]//div/div//div[contains(@class,'user-data')]"));
	for(int j=0;j<lstNames.size();j++)
	{
		WebElement names = lstNames.get(j);
		String listNames = names.getText();
		Reporter.log(listNames, true);
	}
	int i = 1, toBeClicked = 5;
	for(WebElement we: lstPosts) 
	{
		if(i == toBeClicked) {
			//String userName = we.findElement(By.xpath("//div[contains(@class,'col-md-12 col-lg-12 col-sm-12 col-xs-12 post-list-container ng-isolate-scope')]/div/div//div[contains(@class,'user-name ng-binding')]")).getText();
			we.findElement(By.xpath("//div[contains(@class,'col-md-12 col-lg-12 col-sm-12 col-xs-12 post-list-container ng-isolate-scope')]/div/div//div[contains(@class,'user-name ng-binding')]")).click();
		}
		i++;
	}
}

//To like on 5th post	
//To verify post is already liked or not
public void likePost()
{
	List<WebElement> lstPosts = driver.findElements(By.xpath("//div[contains(@class,'col-md-12 col-lg-12 col-sm-12 col-xs-12 post-list-container ng-isolate-scope')]/div/div"));
	//System.out.println(lstPosts.size());
	Reporter.log("Number of User Thumbnails ->"+lstPosts.size(), true );
	List<WebElement> lstNames = driver.findElements(By.xpath("//div[contains(@class,'col-md-12 col-lg-12 col-sm-12 col-xs-12 post-list-container ng-isolate-scope')]//div/div//div[contains(@class,'user-data')]"));
	for(int j=0;j<lstNames.size();j++)
	{
		WebElement names = lstNames.get(j);
		String listNames = names.getText();
		Reporter.log(listNames, true);
	}
	Reporter.log(driver.findElement(By.xpath("//div[contains(@class,'col-md-12 col-lg-12 col-sm-12 col-xs-12 post-list-container ng-isolate-scope')]/div/div//div[contains(@class,'user-name ng-binding')]")).getText(), true);
	int i = 1, toBeClicked = 5;
	for(WebElement we: lstPosts) 
	{
		
		Reporter.log("Post posted by user ->"+we.findElement(By.xpath(".//div[contains(@class,'user-name ng-binding')]")).getText(),true);	
		if(i == toBeClicked) {
			if(cf.isElementDisplayed(we, By.xpath(".//a[contains(@class,'heart-bg-like')]"), 30)){
				we.findElement(By.xpath(".//a[contains(@class,'heart-bg-like')]")).click();
				Reporter.log("Tapped on Like Button", true);
				}
			else if(cf.isElementDisplayed(we, By.xpath(".//a[contains(@class,'heart-bg-unlike')]"), 30)){
				we.findElement(By.xpath(".//a[contains(@class,'heart-bg-unlike')]")).click();
				Reporter.log("This post is already liked", true);
				}
		}
		i++;
	}
}

//To click on any post
public void clickPost()
{
	List<WebElement> lstPosts = driver.findElements(By.xpath("//div[contains(@class,'col-md-12 col-lg-12 col-sm-12 col-xs-12 post-list-container ng-isolate-scope')]/div/div"));
	//Reporter.log("Number of User Thumbnails - >"+lstPosts.size(), true );
	int i = 1, toBeClicked = 5;
	for(WebElement we:lstPosts)
	{
		Reporter.log(we.findElement(By.xpath(".//div[contains(@class,'user-name ng-binding')]")).getText(), true);
		Reporter.log(we.findElement(By.xpath(".//div[contains(@class,'user-title')]")).getText(), true);
		//Reporter.log(we.findElement(By.xpath(".//div[contains(@class,'ago-news ng-binding')]")).getText(), true);
		if(i==toBeClicked)
		{
			we.findElement(By.xpath("//a[@class='ng-binding']")).click();
			break;
		}
		i++;
	}
}

//To delete any post
public void deletePost()
{
	//To get the list of posts on NEws & Updates page
	List<WebElement> lstPosts = driver.findElements(By.xpath("//div[contains(@class,'col-md-12 col-lg-12 col-sm-12 col-xs-12 post-list-container ng-isolate-scope')]/div/div"));
	//To get Name of the logged in user 
	String s = driver.findElement(By.xpath("//div[@class='user-block ng-scope']//img[@class='img-responsive']")).getAttribute("alt");
	System.out.println("Logged In User Name ->"+s);
	//int i = 1;
	
	for(WebElement we:lstPosts)
	{
		//To get User Name, Jobtitle and Timestamp of the post
		Reporter.log(we.findElement(By.xpath(".//div[contains(@class,'user-data')]")).getText(), true);
		//To store user name of the Post
		String s1 =  we.findElement(By.xpath(".//div[contains(@class,'user-name ng-binding')]")).getText();
		
		//To delete particular post
		/*if(i==toBeClicked)
		{
			Reporter.log("Following post will be deleted ->"+we.findElement(By.xpath(".//div[contains(@class,'post-header-block')]")).getText(), true);
			driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
			we.findElement(By.xpath("//a[(text()='Delete this Post')]")).click();
			//we.findElement(By.xpath("//a[(text()='Delete this Post')]")
		}
		i++;*/
		if(s.equalsIgnoreCase(s1))
		{
			String postHeader = we.findElement(By.xpath(".//div[contains(@class,'post-header-block')]")).getText();
			Reporter.log("Following post will be deleted ->"+postHeader, true);
			we.findElement(By.xpath(".//a[@class='dropdown-toggle']")).click();
			we.findElement(By.xpath(".//a[contains(text(),'Delete this Post')]")).click();
			Reporter.log("Post Deleted Successfully", true);
			Alert alert = driver.switchTo().alert();
			alert.accept();
			break;
		}
	}
}

// To report a post
public void reportPost() throws InterruptedException
{
	//To get the list of posts on NEws & Updates page
		List<WebElement> lstPosts = driver.findElements(By.xpath("//div[contains(@class,'col-md-12 col-lg-12 col-sm-12 col-xs-12 post-list-container ng-isolate-scope')]/div/div"));
		//To get Name of the logged in user 
		String s = driver.findElement(By.xpath("//div[@class='user-block ng-scope']//img[@class='img-responsive']")).getAttribute("alt");
		System.out.println(s);
		for(WebElement we:lstPosts)
		{
			Reporter.log(we.findElement(By.xpath(".//div[contains(@class,'user-data')]")).getText(), true);
			String s1 =  we.findElement(By.xpath(".//div[contains(@class,'user-name ng-binding')]")).getText();
			if(!s.equalsIgnoreCase(s1))
			{
				System.out.println("inside if check");
				String postHeader = we.findElement(By.xpath(".//div[contains(@class,'post-header-block')]")).getText();
				Reporter.log("Following post will be reported ->"+postHeader, true);
				we.findElement(By.xpath(".//a[@class='dropdown-toggle']")).click();
				//WebElement element = we.findElement(By.xpath(".//ul[@class='dropdown-menu']/li"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", we.findElement(By.xpath(".//a[contains(text(),'Report this Post')]")));
				Thread.sleep(5000);
				Reporter.log("This Post is reported Successfully", true);
				break;
			}
		}
}

public void readFurtherPost()
{
	System.out.println("Inside readFurther");
	readFurtherLink.click();
}

public void getLikeCommentcount()
{
	List<WebElement> lstPosts = driver.findElements(By.xpath("//div[contains(@class,'col-md-12 col-lg-12 col-sm-12 col-xs-12 post-list-container ng-isolate-scope')]/div/div"));
	int i=1, toBeClicked =3;
	for(WebElement we:lstPosts)
	{
		if(i==toBeClicked)
		{
			String countLike = we.findElement(By.xpath("//div[contains(@class,'col-md-12 col-lg-12 col-sm-12 col-xs-12 post-list-container ng-isolate-scope')]/div/div//a[contains(@class,'counter ng-binding')]")).getText();
			Reporter.log("Number of Likes for the post - >"+countLike, true);
			String countComment = we.findElement(By.xpath("//div[contains(@class,'col-md-12 col-lg-12 col-sm-12 col-xs-12 post-list-container ng-isolate-scope')]/div/div//a[contains(@class,'counter ng-binding')][2]")).getText();
			Reporter.log("Number of Comment for the post - >"+countComment, true);
		}
		i++;
	}
}

//To get feature tags list
//Tapping on random tag list

public void featuredTags()
{
	System.out.println("tagsList");
	List<WebElement> tagsList = driver.findElements(By.xpath(".//a[@class='ng-binding ng-scope']"));
	int k=tagsList.size();
	Reporter.log("Featured Tags are displayed below -> ", true);
	for(int i =0 ;i < tagsList.size() ;i++){
		WebElement tags = tagsList.get(i);
		Reporter.log(tags.getText(), true);
	}
	Random random = new Random();
	int j=0, toBeClicked = random.nextInt(k);
	System.out.println(toBeClicked);
	for(WebElement we:tagsList)
	{
		if(j==toBeClicked)
		{
			we.findElement(By.xpath("//a[@class='ng-binding ng-scope']")).click();
			break;
		}
		j++;
	}
}

//Scroll to bottom of page
public void scrollingToBottomofAPage() {
	 ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
}

//scroll to particular element
public void scrollingToElementofAPage() {
	WebElement element = driver.findElement(By.xpath(""));
	((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView();", element);
}

//scroll by coordinates
public void scrollingByCoordinatesofAPage() {
	((JavascriptExecutor) driver).executeScript("javascript:window.scrollBy(20,1800)");
}

//scroll by Robot class
public void scrollingByRobot() throws AWTException {
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
}


}
