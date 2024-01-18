package org.qalegent.test;

import org.openqa.selenium.WebElement;
import org.qalegent.automatiocore.Base;
import org.qalegent.listeners.RetryAnalyzer;
import org.qalegent.pages.HomePage;
import org.qalegent.pages.LoginPage;
import org.qalegent.pages.UserManagementPage;
import org.selenium.qalegent.constance.Constance;
import org.selenium.qalegent.constance.Messages;
import org.selenium.qalegent.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class UserManagementTest extends Base {
    @Test(groups = {"Sanity"},retryAnalyzer = RetryAnalyzer.class)
    public void verifyUserManagementOptions(){
        LoginPage login = new LoginPage(driver);
        ArrayList<String> data = ExcelUtility.readData(Constance.TEST_DATA_EXCEL_PATH,Constance.LOGIN_PAGE);
        String userName = data.get(1);
        login.enterUserName(userName);
        String password = data.get(2);
        login.enterPassword(password);
        login.clickOnLogin();
        HomePage home = login.clickOnEndTourButton();
        UserManagementPage userManagement = home.clickOnUserManagement();
        List<String>actualUserManagementOptions =userManagement.getUserManagementOptions();
        List<String> values = ExcelUtility.readData(Constance.TEST_DATA_EXCEL_PATH,Constance.USER_MANAGEMENT_PAGE);
        Assert.assertEquals(actualUserManagementOptions,values, Messages.USER_MANAGEMENT_OPTIONS_NOT_VISIBLE);
    }

}
