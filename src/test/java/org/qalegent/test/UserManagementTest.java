package org.qalegent.test;

import org.qalegent.automatiocore.Base;
import org.qalegent.listeners.RetryAnalyzer;
import org.qalegent.pages.HomePage;
import org.qalegent.pages.LoginPage;
import org.qalegent.pages.UserManagementPage;
import org.selenium.qalegent.constants.Constants;
import org.selenium.qalegent.constants.Messages;
import org.selenium.qalegent.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class UserManagementTest extends Base {
    @Test(groups = {"Sanity"},retryAnalyzer = RetryAnalyzer.class)
    public void verifyUserManagementOptions(){
        LoginPage login = new LoginPage(driver);
        ArrayList<String> data = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.LOGIN_PAGE);
        String userName = data.get(1);
        login.enterUserName(userName);
        String password = data.get(2);
        login.enterPassword(password);
        login.clickOnLogin();
        HomePage home = login.clickOnEndTourButton();
        UserManagementPage userManagement = home.clickOnUserManagement();
        List<String>actualUserManagementOptions =userManagement.getUserManagementOptions();
        List<String> values = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.USER_MANAGEMENT_PAGE);
        Assert.assertEquals(actualUserManagementOptions,values, Messages.USER_MANAGEMENT_OPTIONS_NOT_VISIBLE);
    }

}
