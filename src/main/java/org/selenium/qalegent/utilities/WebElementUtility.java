package org.selenium.qalegent.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementUtility {
    public static boolean isElementSelected(WebElement element){
        boolean status=element.isSelected();
        return status;
    }
    public static void clickOnElement(WebElement element){
        element.click();
    }
    public static void enterValue(WebElement element, String valueToEnter){
        element.sendKeys(valueToEnter);
    }
    public static String getTextFromElement(WebElement element){

        return element.getText();
    }
    public static boolean isElementDisplayed(WebElement element){
        boolean elementStatus=element.isDisplayed();
        return elementStatus;
    }
    public static boolean isElementEnabled(WebElement element){
        boolean status=element.isSelected();
        return status;
    }
    public static void enterFirstName(WebElement element, String valueToEnter){
        element.sendKeys(valueToEnter);
    }
    public static void enterLastName(WebElement element, String valueToEnter){
        element.sendKeys(valueToEnter);
    }
    public static void enterEmailId(WebElement element, String valueToEnter){
       element.sendKeys(valueToEnter);
    }
    public static boolean isClicked(WebElement element){
        try {
           element.click();
           return true;
        }
        catch(Exception e){
            return false;
        }
    }
    public static void scrollAndClick(WebDriver driver,WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        int x=0;

        while(!isClicked(element)){
            js.executeScript("window.scrollBy(0,"+x+")");
            x=x+2;
        }
    }
}
