package org.selenium.qalegent.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverUtility {
    public static void loadUrl(WebDriver driver, String URL){
        driver.get(URL);
    }
    public static String getTitle(WebDriver driver){
        String status = driver.getTitle();
        return status;
    }
    public static String currentUrl(WebDriver driver){
        String status = driver.getCurrentUrl();
        return status;
    }
    public static String getPageSource(WebDriver driver){
        String status = driver.getPageSource();
        return  status;
    }
    public  static String windowHandle(WebDriver driver){
        String status = driver.getWindowHandle();
        return status;
    }
}
