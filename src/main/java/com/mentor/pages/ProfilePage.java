package com.mentor.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.mentor.tests.SuperTestNG;
import com.mentor.utilities.CommonFunctions;

public class ProfilePage extends SuperTestNG{
	public ProfilePage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	CommonFunctions cf = new CommonFunctions();
	
	@FindBy(xpath="//a[text()='Edit Profile']")
	private WebElement clickEditProfile;
	
	public void getExistingUserDetails() throws InterruptedException
	{
		//To get page Title
		Reporter.log("Page Title -> "+driver.getTitle(), true);
		Thread.sleep(5000);
		
		//To get UserName
		Reporter.log("Username -> "+driver.findElement(By.xpath("//h2[@class='ng-binding']")).getText(), true);
		
		//To get Country
		Reporter.log("Country -> "+driver.findElement(By.xpath("//h4[@class='ng-binding ng-scope']")).getText(), true);
		
		//To get Industry
		Reporter.log("Indudtry -> "+driver.findElement(By.xpath("//h5[@class='ng-binding']")).getText(), true);
		
		//To get Followers
		Reporter.log("Number of Followers -> "+driver.findElement(By.xpath("//a[@title='View followers']")).getText(), true);
		
		//To get Following
		Reporter.log("Number of Following -> "+driver.findElement(By.xpath("//a[@title='View followings']")).getText(), true);
		
		//To get Activity
		Reporter.log("Number of Activities -> "+driver.findElement(By.xpath("//a[@title='View Activity']")).getText(), true);
	
		//To get about me
		if(cf.isElementDisplayed(driver, By.xpath("//div[@class='col-xs-12 col-sm-12 col-md-12 col-lg-12 padding-0']/div[@class='about-user']//p[@class='ng-binding ng-scope']"), 10))
			Reporter.log("User Summary ->"+driver.findElement(By.xpath("//p[@class='ng-binding ng-scope']")).getText(),true);
		else
			//Reporter.log("User Summary"+driver.findElement(By.xpath("//div[@class='col-xs-12 col-sm-12 col-md-12 col-lg-12 padding-0']/div[@class='about-user']/p[@class='ng-scope']")), true);
			Reporter.log("No summary added by user", true);


		//To get Date of Birth
		if(cf.isElementDisplayed(driver, By.xpath("//div[@class='ng-scope']//div[@class='ng-scope']//div[@class='about-user'][1]/p"), 10))
			Reporter.log("User DOB details ->"+driver.findElement(By.xpath("//div[@class='ng-scope']//div[@class='ng-scope']//div[@class='about-user'][1]/p")).getText() , true);

		//To get Email
		if(cf.isElementDisplayed(driver, By.xpath("//div[@class='ng-scope']//div[@class='ng-scope']//div[@class='about-user'][2]/p"), 10))
			Reporter.log("User Email details ->"+driver.findElement(By.xpath("//div[@class='ng-scope']//div[@class='ng-scope']//div[@class='about-user'][2]/p")).getText() , true);
		
		//To get Gender
		if(cf.isElementDisplayed(driver, By.xpath("//div[@class='ng-scope']//div[@class='ng-scope']//div[@class='about-user'][3]/p"), 10))
			Reporter.log("User Gender details->"+driver.findElement(By.xpath("//div[@class='ng-scope']//div[@class='ng-scope']//div[@class='about-user'][3]/p")).getText() , true);
		
		//To get Experience Details
		if(cf.isElementDisplayed(driver, By.xpath("//div[@class='usr-experience-block'][1]//div[@class='col-xs-12 col-sm-12 col-md-12 col-lg-12 ng-scope']"), 10))
			Reporter.log("No experience records found", true);
		else
		{
			List<WebElement> listExp = driver.findElements(By.xpath(".//div[@ng-class='experience.className']"));
			Reporter.log("Number of Experience details added by user ->"+listExp.size(), true);
			Reporter.log("User Experience Details displayed below ->", true);
			for(int j=0;j<listExp.size();j++)
			{
				WebElement expDetails = listExp.get(j);
				Reporter.log(expDetails.getText(), true);
			}
		}	
		//To get Education
		if(cf.isElementDisplayed(driver, By.xpath("//div[@class='col-xs-12 col-sm-12 col-md-12 col-lg-12 ng-scope']"), 10))
			Reporter.log("No education records found", true);
		else
		{
			List<WebElement> listEdu = driver.findElements(By.xpath(".//div[@class='ng-scope col-xs-6 col-sm-6 col-md-6 col-lg-6']"));
			Reporter.log("Number of Education details added by user ->"+listEdu.size(), true);
			Reporter.log("User Education Details displayed below ->", true);
			for(int j=0;j<listEdu.size();j++)
			{
				WebElement eduDetails = listEdu.get(j);
				Reporter.log(eduDetails.getText(), true);
			}
		}
		//To get Skills
		if(cf.isElementDisplayed(driver, By.xpath("//div[@class='usr-experience-block'][3]//div[@class='col-xs-12 col-sm-12 col-md-12 col-lg-12']"), 10))
			Reporter.log("No skills found", true);
		else
		{
			List<WebElement> listSkills = driver.findElements(By.xpath(".//div[@class='usr-experience-block'][3]//li[@class='ng-binding ng-scope']"));
			Reporter.log("Number of Skills added by user ->"+listSkills.size(), true);
			Reporter.log("Below are the Skills added by user ->", true);
			for(int j=0;j<listSkills.size();j++)
			{
				WebElement eduDetails = listSkills.get(j);
				Reporter.log(eduDetails.getText(), true);
			}
		}
		//To get Languages
		if(cf.isElementDisplayed(driver, By.xpath("//div[@class='usr-experience-block'][4]//div[@class='col-xs-12 col-sm-12 col-md-12 col-lg-12']"), 10))
			Reporter.log("No Languages found", true);
		else
		{
			List<WebElement> listLanguages = driver.findElements(By.xpath(".//div[@class='usr-experience-block'][4]//li[@class='ng-binding ng-scope']"));
			Reporter.log("Number of Languages added by user ->"+listLanguages.size(), true);
			Reporter.log("Below are the Languages added by user ->", true);
			for(int j=0;j<listLanguages.size();j++)
			{
				WebElement eduDetails = listLanguages.get(j);
				Reporter.log(eduDetails.getText(), true);
			}
		}
	}
		
	//To click on edit profile
	public void clickEdit()
	{
		clickEditProfile.click();
	}
	
	public void addExperience()
	{
		List<WebElement> lstExperience = driver.findElements(By.xpath("//div[@class='container-fluid']//div[@class='container-fluid']/div[3]/div[2]/div"));
		int countExp = lstExperience.size();
		Reporter.log("Number of Experience exists ->"+countExp, true);
		int i;
		if(countExp < 10) {
			for (i=lstExperience.size();i<=10;i++)
			{
				//To click on 'Add New Job'
				driver.findElement(By.xpath("//a[contains(text(),'ADD NEW JOB')]")).click();
				//To add company name
				driver.findElement(By.xpath("//input[@name='company']")).sendKeys("Company 1");
				//click on From datepicker
				driver.findElement(By.xpath("//input[@placeholder='From (mm/yyyy) ']")).click();
				//To click on Month and year to view Months
				driver.findElement(By.xpath("//div[@class='container-fluid']//div[@class='container-fluid']/div[3]/div[2]/form/div//button[contains(@id,'datepicker')]")).click();
				//To Click on Month and year to view Year
				driver.findElement(By.xpath("//div[@class='container-fluid']//div[@class='container-fluid']/div[3]/div[2]/form/div//button[contains(@id,'datepicker')]")).click();
				//To select an Year
				WebElement fromYear = driver.findElement(By.xpath("//div[@class='container-fluid']//div[@class='container-fluid']/div[3]/div[2]/form/div//tr[1]//span[contains(text(),'02')]"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", fromYear);
				//To select month
				WebElement fromMonth = driver.findElement(By.xpath("//div[@class='container-fluid']//div[@class='container-fluid']/div[3]/div[2]/form/div//span[contains(text(),'May')]"));
				executor.executeScript("arguments[0].click();", fromMonth);
				//To click on Date
				driver.findElement(By.xpath("//div[@class='container-fluid']//div[@class='container-fluid']/div[3]/div[2]/form/div//span[contains(text(),'01')]")).click();

				//Click on  To datepicker
				driver.findElement(By.xpath("//input[@placeholder='To (mm/yyyy) ']")).click();
				//To click on Month
				driver.findElement(By.xpath("//div[@class='container-fluid']//div[@class='container-fluid']/div[3]/div[2]/form/div//ul[2]//button[contains(@id,'datepicker')]")).click();
				//To click on Month and Year
				driver.findElement(By.xpath("//div[@class='container-fluid']//div[@class='container-fluid']/div[3]/div[2]/form/div//ul[2]//button[contains(@id,'datepicker')]")).click();
				//To select an Year
				WebElement toYear = driver.findElement(By.xpath("//div[@class='container-fluid']//div[@class='container-fluid']/div[3]/div[2]/form/div//ul[2]//span[contains(text(),'14')]"));
				executor.executeScript("arguments[0].click();", toYear);
				//To select month
				WebElement toMonth = driver.findElement(By.xpath("//div[@class='container-fluid']//div[@class='container-fluid']/div[3]/div[2]/form/div//ul[2]//span[contains(text(),'June')]"));
				executor.executeScript("arguments[0].click();", toMonth);
				//To click on Date
				driver.findElement(By.xpath("//div[@class='container-fluid']//div[@class='container-fluid']/div[3]/div[2]/form/div//ul[2]//span[contains(text(),'05')]")).click();
				//Adding Job Titile
				driver.findElement(By.xpath("//input[@name='designantion']")).sendKeys("Tester, ScrewDriver");
				//Addind location
				driver.findElement(By.xpath("//input[@name='location']")).sendKeys("Namma Bengaluru");
				//driver.findElement(By.xpath("//a[@name='isCurrent']")).click();
				//Adding experience
				driver.findElement(By.xpath("//button[text()='ADD EXPERIENCE']")).click();
			}
		}
		else
		{
			Reporter.log("Maximum Number of Experience are already exist", true);
		}
	}
	
	public void addEducation()
	{
		List<WebElement> lstEducation = driver.findElements(By.xpath("//div[@class='container-fluid']//div[@class='container-fluid']/div[4]/div[2]/div"));
		int countEdu = lstEducation.size();
		Reporter.log("Number of Experience exists ->"+countEdu, true);
		//int i;
		if(countEdu < 5) {
			//To click on 'Add New Education'
			driver.findElement(By.xpath("//a[contains(text(),'ADD NEW EDUCATION')]")).click();
			//To add School Name
			driver.findElement(By.xpath("//input[@placeholder='School name']")).sendKeys("Kendriya Vidyalaya");
			//To select date from date picker
			//To select from datepicker placeholder 
			driver.findElement(By.xpath("//input[@placeholder='From (mm/yyyy)']")).click();
			//To click on Month and Year to view Months
			driver.findElement(By.xpath("//div[@class='container-fluid']//div[@class='container-fluid']/div[4]/div[2]/form/div//div[contains(@class,'edit-exp-form')]/ul[1]//button[contains(@id,'datepicker')]")).click();
			//div[@class='container-fluid']//div[@class='container-fluid']/div[4]/div[2]/form/div//div[contains(@class,'edit-exp-form')]/ul[1]
			//To Click on Month and year to view Year
			driver.findElement(By.xpath("//div[@class='container-fluid']//div[@class='container-fluid']/div[4]/div[2]/form/div//div[contains(@class,'edit-exp-form')]/ul[1]//button[contains(@id,'datepicker')]")).click();
			//To select an Year
			WebElement fromYear = driver.findElement(By.xpath("//div[@class='container-fluid']//div[@class='container-fluid']/div[4]/div[2]/form/div//div[contains(@class,'edit-exp-form')]/ul[1]//span[contains(text(),'02')]"));
			//div[@class='container-fluid']//div[@class='container-fluid']/div[4]/div[2]/form/div//div[contains(@class,'edit-exp-form')]/ul[1]//button[contains(@id,'datepicker')]
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", fromYear);
			//To select month
			WebElement fromMonth = driver.findElement(By.xpath("//div[@class='container-fluid']//div[@class='container-fluid']/div[4]/div[2]/form/div//div[contains(@class,'edit-exp-form')]/ul[1]//span[contains(text(),'June')]"));
			executor.executeScript("arguments[0].click();", fromMonth);
			//To select date
			driver.findElement(By.xpath("//div[@class='container-fluid']//div[@class='container-fluid']/div[4]/div[2]/form/div//div[contains(@class,'edit-exp-form')]/ul[1]//span[contains(text(),'07')]")).click();
			//To select date from To date picker
			//To select from datepicker placeholder 
			driver.findElement(By.xpath("//input[@placeholder='To (mm/yyyy)']")).click();
			//To click on Month and Year to view Months
			driver.findElement(By.xpath("//div[@class='container-fluid']//div[@class='container-fluid']/div[4]/div[2]/form/div//div[contains(@class,'edit-exp-form')]/ul[2]//button[contains(@id,'datepicker')]")).click();
			//To Click on Month and year to view Year
			driver.findElement(By.xpath("//div[@class='container-fluid']//div[@class='container-fluid']/div[4]/div[2]/form/div//div[contains(@class,'edit-exp-form')]/ul[2]//button[contains(@id,'datepicker')]")).click();
			//To select an Year
			WebElement toYear = driver.findElement(By.xpath("//div[@class='container-fluid']//div[@class='container-fluid']/div[4]/div[2]/form/div//div[contains(@class,'edit-exp-form')]/ul[2]//span[contains(text(),'14')]"));
			executor.executeScript("arguments[0].click();", toYear);
			//To select month
			WebElement toMonth = driver.findElement(By.xpath("//div[@class='container-fluid']//div[@class='container-fluid']/div[4]/div[2]/form/div//div[contains(@class,'edit-exp-form')]/ul[2]//span[contains(text(),'June')]"));
			executor.executeScript("arguments[0].click();", toMonth);
			//To select date
			driver.findElement(By.xpath("//div[@class='container-fluid']//div[@class='container-fluid']/div[4]/div[2]/form/div//div[contains(@class,'edit-exp-form')]/ul[2]//span[contains(text(),'17')]")).click();
			//To add Education Qualification
			driver.findElement(By.xpath("//input[@name='qualification']")).sendKeys("Engineering");
			//To Field of Study
			driver.findElement(By.xpath("//input[@ng-model='edu.field_of_study']")).sendKeys("Computer Science");
			//To click on Add Education
			driver.findElement(By.xpath("//button[text()='ADD EDUCATION']")).click();
		}
		else
		{
			Reporter.log("Maximum Number of Education are already exist", true);
		}
	}
	
	//Adding Skills
	public void addSkills()
	{
		driver.findElement(By.xpath("//a[text()='+ ADD NEW SKILL']")).click();
		WebElement listSkills = driver.findElement(By.xpath("//select[@ng-model='cont.skill_name']")) ;
		Select selectSkills = new Select(listSkills);
		int countlist = selectSkills.getOptions().size() ;
		for(int i=0; i <countlist ; i++) {
			System.out.println(selectSkills.getOptions().get(i).getText());
		}
		selectSkills.selectByVisibleText(".NET");
		driver.findElement(By.xpath("//button[@class='save-this-btn']")).click();
	}
	
	//Removing skills
	public void removeSkills()
	{
		//To get skills list
		List<WebElement> lstSkills = driver.findElements(By.xpath("//div[@class='row-fluid edit-prof-btm'][5]//li"));
		for(int i =1; i<=lstSkills.size();i++)
		{
			WebElement getskills = lstSkills.get(i);
			Reporter.log("Deleting skill ->"+getskills.getText(), true);
			lstSkills.get(i).findElement(By.xpath("//a[@class='delete-list']")).click();
		}
	}
	
	//Add Languages
	public void addLanguages()
	{
		//To click on 'Add New Language'
		driver.findElement(By.xpath("//a[text()='+ ADD NEW LANGUAGE']")).click();
		//To get Languages
		WebElement clicklanguages=driver.findElement(By.xpath("//select[@ng-model='cont.lang_name']"));
		Select selectLanguages=new Select(clicklanguages);
		int countlist = selectLanguages.getOptions().size() ;
		//To display languages
		for(int i=0; i <countlist ; i++) {
			System.out.println(selectLanguages.getOptions().get(i).getText());
		}
		//To select language
		selectLanguages.selectByVisibleText("Kannada");
		//To save language
		driver.findElement(By.xpath("//button[text()='SAVE LANGUAGE']")).click();
	}
	
	//Remove Languages
	public void removeLanguages()
	{
		//To get Languages
		List<WebElement> lstLanguages = driver.findElements(By.xpath("//div[@class='row-fluid edit-prof-btm'][6]//li"));
		if(lstLanguages.size()==0)
		{
			Reporter.log("No languages exist", true);
		}
		else
		{
			for(int i =1; i<=lstLanguages.size();i++)
			{
				WebElement getLanguage = lstLanguages.get(i);
				Reporter.log("Deleting languages ->"+getLanguage.getText(), true);
				lstLanguages.get(i).findElement(By.xpath("//a[@class='delete-list']")).click();
			}
		}
	}
	
	
	
	
	
}