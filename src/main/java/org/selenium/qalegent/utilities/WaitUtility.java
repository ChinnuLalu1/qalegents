package org.selenium.qalegent.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtility {
    public  static void pageLoadwait(WebDriver driver, int time){
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(time));
    }
    public static void implicitWait(WebDriver driver,int time){
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(time));
    }
    public static void explicitWait(WebDriver driver, int time, String locatorValue){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
        wait.until(ExpectedConditions.alertIsPresent());
    }

}
