package org.qalegent.test;

import org.openqa.selenium.WebDriver;
import org.qalegent.automatiocore.Base;
import org.qalegent.listeners.RetryAnalyzer;
import org.qalegent.pages.*;
import org.selenium.qalegent.constance.Constance;
import org.selenium.qalegent.constance.Messages;
import org.selenium.qalegent.utilities.ExcelUtility;
import org.selenium.qalegent.utilities.RandomDataUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AddUsersPageTest extends Base {
    @Test(groups = {"Sanity"})
    public void verifyAddUserPageTitle(){
        LoginPage login = new LoginPage(driver);
        ArrayList<String> data = ExcelUtility.readData(Constance.TEST_DATA_EXCEL_PATH,Constance.LOGIN_PAGE);
        String loginUserName = data.get(1);
        login.enterUserName(loginUserName);
        String loginPassword = data.get(2);
        login.enterPassword(loginPassword);
        login.clickOnLogin();
        HomePage home = login.clickOnEndTourButton();
        UserManagementPage userManagement = home.clickOnUserManagement();
        UsersPage userPage = userManagement.clickOnUsersOption();
        AddUsersPage addUser = userPage.clickOnAddButton();
        String actualAddUserPageTitle = addUser.getPageTitle();
        ArrayList<String> addUserData = ExcelUtility.readData(Constance.TEST_DATA_EXCEL_PATH,Constance.ADD_USER_PAGE);
        String expectedAdduserPageTitle = addUserData.get(0);
        Assert.assertEquals(actualAddUserPageTitle,expectedAdduserPageTitle, Messages.TITLE_MISMATCH);
    }
    @Test(groups = {"Smoke"},retryAnalyzer = RetryAnalyzer.class)
    public void verifyAddUser(){
        String firstName = RandomDataUtility.getFirstName();
        String lastName  = RandomDataUtility.getLastName();
        String emailId =firstName + "." + lastName + "12@yahoo.com";
        String password =firstName +"." +lastName;
        LoginPage login = new LoginPage(driver);
        ArrayList<String> data = ExcelUtility.readData(Constance.TEST_DATA_EXCEL_PATH,Constance.LOGIN_PAGE);
        String loginUserName = data.get(1);
        login.enterUserName(loginUserName);
        String loginPassword = data.get(2);
        login.enterPassword(loginPassword);
        login.clickOnLogin();
        HomePage home = login.clickOnEndTourButton();
        UserManagementPage userManagement =home.clickOnUserManagement();
        UsersPage userPage = userManagement.clickOnUsersOption();
        AddUsersPage addUser =userPage.clickOnAddButton();
        addUser.enterFirstName(firstName);
        addUser.enterLastName(lastName);
        addUser.enterEmailId(emailId);
        addUser.enterUserName(firstName);
        addUser.enterPassWord(password);
        addUser.enterConfirmPassword(password);
        UsersPage usersPage = addUser.clickOnSaveButton();
        /*usersPage.enterValueOnSearchField(emailId);
        String actualUserEmailId = emailId;
        String expectedUserEmailId =userPage.getUserEmailId();
        Assert.assertEquals(actualUserEmailId,expectedUserEmailId,Messages.USER_CREATION_FAILED);
       */

    }
    @Test(groups = {"Smoke"})
    public void verifyUserLoginWithNewlyAddedUser(){
        LoginPage login = new LoginPage(driver);
        ArrayList<String> data = ExcelUtility.readData(Constance.TEST_DATA_EXCEL_PATH,Constance.ADD_USER_PAGE);
        String loginUserName = data.get(1);
        login.enterUserName(loginUserName);
        String loginPassword = data.get(2);
        login.enterPassword(loginPassword);
        login.clickOnLogin();
        HomePage home = login.clickOnEndTourButton();
        String actualRegisteredUserPageNameText =home.getRegisteredUserPageTitle();
        String expectedRegisteredUserPageNameText ="Welcome " + data.get(4) + ",";
        Assert.assertEquals(actualRegisteredUserPageNameText,expectedRegisteredUserPageNameText,Messages.USER_LOGIN_FAILED);
    }
}
