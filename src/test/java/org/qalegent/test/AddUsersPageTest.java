package org.qalegent.test;

import org.qalegent.automatiocore.Base;
import org.qalegent.pages.*;
import org.selenium.qalegent.constants.Constants;
import org.selenium.qalegent.constants.Messages;
import org.selenium.qalegent.utilities.ExcelUtility;
import org.selenium.qalegent.utilities.RandomDataUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class AddUsersPageTest extends Base {

    @Test(groups = {"Sanity"})
    public void verifyAddUserPageTitle(){
        LoginPage login = new LoginPage(driver);
        ArrayList<String> data = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.LOGIN_PAGE);
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
        ArrayList<String> addUserData = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.ADD_USER_PAGE);
        String expectedAdduserPageTitle = addUserData.get(0);
        Assert.assertEquals(actualAddUserPageTitle,expectedAdduserPageTitle, Messages.TITLE_MISMATCH);
    }
    @Test(groups = {"Smoke"})
    public void verifyAddUser(){
        String firstName = RandomDataUtility.getFirstName();
        String lastName  = RandomDataUtility.getLastName();
        String emailId =firstName + "." + lastName + "12@yahoo.com";
        String password =firstName +"." +lastName;
        LoginPage login = new LoginPage(driver);
        ArrayList<String> data = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.LOGIN_PAGE);
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
        usersPage.enterValueOnSearchField(emailId);
        String actualUserEmailId = userPage.getUserEmailId();
        String expectedUserEmailId =emailId;
        Assert.assertEquals(actualUserEmailId,expectedUserEmailId,Messages.USER_CREATION_FAILED);

    }
    @Test(groups = {"Smoke"}) //,retryAnalyzer = RetryAnalyzer.class)
    public void verifyUserLoginWithNewlyAddedUser(){
        String firstName = RandomDataUtility.getFirstName();
        String lastName  = RandomDataUtility.getLastName();
        String emailId =firstName + "." + lastName + "12@yahoo.com";
        String password =firstName +"." +lastName;
        LoginPage login = new LoginPage(driver);
        ArrayList<String> data = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.LOGIN_PAGE);
        String loginUserName = data.get(1);
        login.enterUserName(loginUserName);
        String loginPassword = data.get(2);
        login.enterPassword(loginPassword);
        login.clickOnLogin();
        HomePage home = login.clickOnEndTourButton();
        UserManagementPage userManagement =home.clickOnUserManagement();
        UsersPage usersPage = userManagement.clickOnUsersOption();
        AddUsersPage addUser =usersPage.clickOnAddButton();
        addUser.enterFirstName(firstName);
        addUser.enterLastName(lastName);
        addUser.enterEmailId(emailId);
        addUser.enterUserName(firstName);
        addUser.enterPassWord(password);
        addUser.enterConfirmPassword(password);
        addUser.clickOnSaveButton();
        usersPage.clickOnUserProfile();
        LoginPage newLogin =usersPage.clickOnSignOut();
        newLogin.enterUserName(firstName);
        newLogin.enterPassword(password);
        newLogin.clickOnLogin();
        HomePage homePage = login.clickOnEndTourButton();
//        String actualRegisteredUserPageNameText =homePage.getRegisteredUserPageTitle();
//        String expectedRegisteredUserPageNameText ="Welcome " + firstName + ",";
//        Assert.assertEquals(actualRegisteredUserPageNameText,expectedRegisteredUserPageNameText,Messages.USER_LOGIN_FAILED);
    }
}
