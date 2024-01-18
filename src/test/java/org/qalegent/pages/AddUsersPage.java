package org.qalegent.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.qalegent.utilities.RandomDataUtility;
import org.selenium.qalegent.utilities.WebElementUtility;

public class AddUsersPage {
    WebDriver driver;
    public AddUsersPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "first_name")
    WebElement firstNameField;

    @FindBy(id = "last_name")
    WebElement lastNameField;

    @FindBy(id = "email")
    WebElement newUseremail;

    @FindBy(id = "username")
    WebElement userNameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "confirm_password")
    WebElement confirmPasswordField;

    @FindBy(id = "submit_user_button")
    WebElement saveButton;


    public String getPageTitle(){
        return driver.getTitle();
    }
    public void enterFirstName(String firstName){
        WebElementUtility.enterFirstName(firstNameField,firstName);
    }
    public void enterLastName(String lastName){
        WebElementUtility.enterLastName(lastNameField,lastName);
    }
    public void enterEmailId(String emailId){
       WebElementUtility.enterEmailId(newUseremail,emailId);
    }
    public void enterUserName(String userName){
        WebElementUtility.enterFirstName(userNameField,userName + "123");
    }
    public void enterPassWord(String password){
        WebElementUtility.enterValue(passwordField,password);
    }
    public void enterConfirmPassword(String password){
        WebElementUtility.enterValue(confirmPasswordField,password);
    }
    public UsersPage clickOnSaveButton(){
        WebElementUtility.clickOnElement(saveButton);
        return new UsersPage(driver);
    }
//    public String getNewUserMailId() {
//        String newUserMail =WebElementUtility.enterEmailId();
//        return newUserMail;
//    }


}
