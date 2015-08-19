package com.mentor.pages;

import com.mentor.tests.SuperTestNG;
import com.mentor.utilities.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

/**
 * Created by sukshitha on 8/14/2015.
 */
public class Notification extends SuperTestNG {
    public Notification(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    CommonFunctions cf = new CommonFunctions();

    @FindBy(xpath = "//a[@ng-click='main.resetCount();']")
    private WebElement notifcationSidepanel;

    @FindBy(xpath = "//span[@class='notification-counter ng-binding ng-scope']")
    private WebElement notificationCount;

    @FindBy(xpath = "//img[@id='notificaationIcn'].Click()")
    private WebElement notificationBell;

    @FindBy(xpath = "//h2[@class=\"main-header\"]")
    private WebElement notificationDetail;


    //to find the notification count and print
//span[@class='notification-counter ng-binding ng-scope']
    public boolean isCount()
    {
        boolean iscount = false;
      //  WebElement countTest = driver.findElement(By.xpath("//span[@class='notification-counter ng-binding ng-scope']"));

        String actualResult="";
        String expectedResult="";
        try
        {
            notificationCount.isDisplayed();
            actualResult =notificationCount.getText();
            Reporter.log(actualResult, true);

        }
        catch (Exception e){
        Reporter.log("No New Notification", true);
        //return iscount;
        }
        driver.navigate().refresh();
        try
        {

            notificationCount.isDisplayed();
            expectedResult =notificationCount.getText();
            Reporter.log(expectedResult, true);

        }
        catch (Exception e){
            Reporter.log("No New Notification", true);
            return iscount;
        }
        Assert.assertEquals(expectedResult,actualResult);


        return iscount;

    }

}