package com.mentor.tests;

import com.mentor.pages.LeftSideNavigation;
import com.mentor.pages.LogInPage;
import com.mentor.pages.Notification;
import com.mentor.pages.WelcomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import sun.management.ThreadInfoCompositeData;

/**
 * Created by sukshitha on 8/14/2015.
 */
public class NotificationTest extends SuperTestNG {
    @Test
    public void test_notificationCount() throws InterruptedException {
        WelcomePage welcomePage = new WelcomePage(driver);
        LogInPage loginPage = new LogInPage(driver);
        LeftSideNavigation leftSideNav = new LeftSideNavigation(driver);
        Notification count = new Notification(driver);
        welcomePage.clickLogin();
        loginPage.getTitle();
        Assert.assertTrue(loginPage.isLoginOverlayDisplayed(), "Login Overlay Displayed");
        Reporter.log("LogIn Overlay", true);
        loginPage.login();
        Thread.sleep(10000);
       // driver.navigate().refresh();

        count.isCount();
        //to find the count of notification
       // String ele = driver.findElement(By.xpath()).getText();
       // System.out.println(ele);
        //Assert.assertTrue(count.isCount(), "New Notification Verified");
        //Reporter.log("New Notification Verified", true);
       // Assert.assertEquals("Password is incorrect", ele);
       // System.out.println("Password incorrect verified");







    }

}
