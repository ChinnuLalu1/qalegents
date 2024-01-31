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
    @FindBy(xpath = "//a[contains(@class,'btn btn-block btn-primary')]")
    WebElement addButton;

    @FindBy(xpath = "//input[@class='form-control input-sm']")
    WebElement searchBoxField;

    @FindBy(xpath = "//tr[@class='odd']//td[text()='ammu@gmail.com']")
    WebElement addedUserEmailField;

    @FindBy(xpath = "//table//tr[1]//td[4]")
    WebElement newUserEmail;

    @FindBy(xpath = "//a[@class='dropdown-toggle']//span")
    WebElement userElement;

    @FindBy(xpath = "//a[@class='btn btn-default btn-flat' and text()='Sign Out']")
    WebElement signOutButton;

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

        return WebElementUtility.getTextFromElement(newUserEmail);
    }
    public void clickOnUserProfile(){
        WebElementUtility.scrollAndClick(driver,userElement);
        //WebElementUtility.clickOnElement(userElement);
    }
    public LoginPage clickOnSignOut(){
        WebElementUtility.clickOnElement(signOutButton);
        return new LoginPage(driver);
    }
}
