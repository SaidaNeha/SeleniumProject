package com.thetestingAcademy.Selenium_Project_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class MiniProoject03 {
    @Test
    public void verifyTrialLogin() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--guest");
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://www.idrive360.com/enterprise/login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        txtEmail.sendKeys("neha@gmail.com");
        WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        pwd.sendKeys("123456");
        WebElement signIn_btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frm-btn")));
        signIn_btn.click();
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe("https://www.idrive360.com/enterprise/login")));

        try{
        WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("upgrade")));
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page Title: " + driver.getTitle());
        Assert.assertEquals("https://www.idrive360.com/enterprise/devices",driver.getCurrentUrl());
}
        catch (Exception e)
        {
            System.out.println("failed to load"+driver.getCurrentUrl());
            throw e;
        }
        driver.quit();

    }
}
