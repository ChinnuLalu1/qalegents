package org.qalegent.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.qalegent.utilities.WebElementUtility;

public class ResetPage {
    WebDriver driver;
    public ResetPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement passwordRestButton;

    @FindBy(xpath = "//span[@class='help-block']")
    WebElement forgetPasswordEmailField;

    @FindBy(xpath = "//span[@class='help-block']//strong[contains(text(),'We can')]")
    WebElement resetPasswordEmailField;

    public String getPageTitle(){
        return driver.getTitle();
    }
    public void enterEmail(String email){
        WebElementUtility.enterValue(emailField,email);
    }
    public ResetPage clickOnPasswordResetLink(){
        WebElementUtility.clickOnElement(passwordRestButton);
        return new ResetPage(driver);
    }
    public  String getText(){
        String resetPasswordMsg = WebElementUtility.getTextFromElement(resetPasswordEmailField);
        return resetPasswordMsg;
    }
}
