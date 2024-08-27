package com.thetestingAcademy.Selenium_Project_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AutomatingVWOLoginPage {
    @Test
    public void automateLogin()
    {
//*
// "[Assignment] - Automating the Login Page of VWO.com
//Fetch the locators - https://app.vwo.com/
//Create a Maven project and add TestNG.
//Add the Allure Report (Allure TestNG)
//Automate the two Test cases of VWO.com
//Valid Username and Valid Password
//Verify name on dashboard page.
//Run them and share results.
//Push the code to github.comneha@admintest.com
//Git repo - ReadMe.md a Screen shot of allure."
//*/
        EdgeOptions Options=new EdgeOptions();
        Options.addArguments("--start-maximized");
Options.addArguments("--guest");

        WebDriver driver=new EdgeDriver(Options);
driver.navigate().to("https://app.vwo.com");
        WebElement uname=driver.findElement(By.id("login-username"));
        uname.sendKeys("neha@admintest.com");
        WebElement pwd=driver.findElement(By.id("login-password"));
            pwd.sendKeys("Vwoneha@12345");
        WebElement Submitbutton =driver.findElement(By.id("js-login-btn"));
        Submitbutton.click();
        WebDriverWait wait;
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("Dashboard"));
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Dashboard");
        driver.quit();
    }

}
