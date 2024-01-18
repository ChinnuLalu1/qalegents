package org.qalegent.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.qalegent.utilities.WebElementUtility;

public class UsersPage {
    WebDriver driver;
    public UsersPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
    WebElement addButton;

    @FindBy(xpath = "//input[@class='form-control input-sm']")
    WebElement searchBoxField;

    @FindBy(xpath = "//tr[@class='odd']//td[text()='ammu@gmail.com']")
    WebElement addedUserEmailField;

    @FindBy(id = "email")
    WebElement newUseremail;

    public String getPageTitle(){
        return driver.getTitle();
    }
    public AddUsersPage clickOnAddButton(){
        WebElementUtility.clickOnElement(addButton);
        return new AddUsersPage(driver);
    }
    public void enterValueOnSearchField(String addUserEmailId){
        WebElementUtility.enterEmailId(searchBoxField,addUserEmailId);
    }
    public String getAddedUserEmailId() {
        return WebElementUtility.getTextFromElement(addedUserEmailField);
    }
    public String getUserEmailId(){
        return WebElementUtility.getTextFromElement(newUseremail);
    }

}
