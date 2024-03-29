package org.qalegent.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.qalegent.utilities.WaitUtility;
import org.selenium.qalegent.utilities.WebElementUtility;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="username")
    WebElement userNameField;

    @FindBy(id="password")
    WebElement passwordField;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement loginButton;

    @FindBy(xpath = "//a[@class='btn btn-link']")
    WebElement forgetPasswordField;

    @FindBy(xpath = "//span[@class='help-block']//strong")
    WebElement errorMessageField;

    @FindBy(xpath = "//button[@class='btn btn-default btn-sm']")
    WebElement endTourButton;

    public void enterUserName(String userName){
        WebElementUtility.enterValue(userNameField,userName);
    }
    public void enterPassword(String password){
        WebElementUtility.enterValue(passwordField,password);
    }
    public HomePage clickOnLogin(){
        //WebElementUtility.clickOnElement(loginButton);
        loginButton.click();
        return new HomePage(driver);
    }
    public HomePage login(String useName,String password){
        WebElementUtility.enterValue(userNameField,useName);
        WebElementUtility.enterValue(passwordField,password);
        WebElementUtility.clickOnElement(loginButton);
        return new HomePage(driver);
    }
    public String getPageTitle(){
        return driver.getTitle();
    }
    public ResetPage clickOnForgetPassword(){
        WebElementUtility.clickOnElement(forgetPasswordField);
        return new ResetPage(driver);
    }
    public String getText(){
       String errorMessageText = WebElementUtility.getTextFromElement(errorMessageField);
       return errorMessageText;
    }
    public HomePage clickOnEndTourButton(){
        WaitUtility.implicitWait(driver,10);
        WebElementUtility.clickOnElement(endTourButton);
        return new HomePage(driver);
    }

}
