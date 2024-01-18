package org.qalegent.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.qalegent.utilities.AppUtility;
import org.selenium.qalegent.utilities.WaitUtility;
import org.selenium.qalegent.utilities.WebElementUtility;

import java.util.List;

public class UserManagementPage {
    WebDriver driver;
    public UserManagementPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
    WebElement addButton;


    @FindBy(xpath = "//ul[@class='treeview-menu']//span[@class='title']")
    List<WebElement> userManagementMenuOptions;

    @FindBy(xpath = "//span[@class='title' and contains(text(),'Users')]")
    WebElement userOptionField;

    public AddUsersPage clickOnAddButton(){
        WebElementUtility.clickOnElement(addButton);
        return new AddUsersPage(driver);
    }
    public List<String> getUserManagementOptions()
    {
        return AppUtility.getMenuOptions(userManagementMenuOptions);
    }
    public UsersPage clickOnUsersOption(){
        if (userOptionField.isDisplayed() && userOptionField.isEnabled()) {
            WebElementUtility.clickOnElement(userOptionField);
        }else  {
            // Handle the case where the element is not intractable
        }
        WaitUtility.pageLoadwait(driver,10);
        return new UsersPage(driver);
    }

}
