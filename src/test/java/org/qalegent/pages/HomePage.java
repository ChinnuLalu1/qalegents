package org.qalegent.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.qalegent.utilities.DateUtility;
import org.selenium.qalegent.utilities.WaitUtility;
import org.selenium.qalegent.utilities.WebElementUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class='m-8 pull-left mt-15 hidden-xs']//strong")
    WebElement loginDateElement;

    @FindBy(xpath = "//span[contains(text(),'User Management')]")
    WebElement userManagementField;

    @FindBy(xpath = "//span[@class='title' and normalize-space()='Users']")
    WebElement usersElement;

    @FindBy(xpath = "//ul[@class='treeview-menu menu-open']//span[contains(text(),'Users')]")
    WebElement userOptionsUserField;

    @FindBy(xpath = "//section[@class='content-header']")
    WebElement registeredUserPageField;

    public String getPageTitle(){
        return driver.getTitle();
    }
    public String getLoginDate(){
        String loginDate = WebElementUtility.getTextFromElement(loginDateElement);
        return loginDate;
    }
    public String getCurrentDate(){
       String currentDate = DateUtility.getUserLoginDate("dd-MM-YYYY");
        return currentDate;
    }
    public UserManagementPage clickOnUserManagement(){
        WebElementUtility.clickOnElement(userManagementField);
        return new UserManagementPage(driver);

    }
    public String getRegisteredUserPageTitle(){
        return WebElementUtility.getTextFromElement(registeredUserPageField);
    }


}
