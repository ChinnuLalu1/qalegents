package org.qalegent.test;


import org.qalegent.automatiocore.Base;
import org.qalegent.listeners.RetryAnalyzer;
import org.qalegent.pages.HomePage;
import org.qalegent.pages.LoginPage;
import org.selenium.qalegent.constance.Constance;
import org.selenium.qalegent.constance.Messages;
import org.selenium.qalegent.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;

public class HomePageTest extends Base {
    @Test(groups = {"Sanity"})
    public void verifyHomePageTitle(){
        LoginPage login = new LoginPage(driver);
        ArrayList<String> data = ExcelUtility.readData(Constance.TEST_DATA_EXCEL_PATH,Constance.LOGIN_PAGE);
        String userName = data.get(1);
        login.enterUserName(userName);
        String password = data.get(2);
        login.enterPassword(password);
        HomePage home = login.clickOnLogin();
        String actualPageTitle = home.getPageTitle();
        ArrayList<String> messageData = ExcelUtility.readData(Constance.TEST_DATA_EXCEL_PATH,Constance.HOME_PAGE);
        String expectedPageTitle = messageData.get(0);
        Assert.assertEquals(actualPageTitle,expectedPageTitle, Messages.TITLE_MISMATCH);
    }
    @Test(groups = {"Regression"},retryAnalyzer = RetryAnalyzer.class)
    public void verifyUserLoginDate(){
        LoginPage login = new LoginPage(driver);
        ArrayList<String> data = ExcelUtility.readData(Constance.TEST_DATA_EXCEL_PATH, Constance.LOGIN_PAGE);
        String userName = data.get(1);
        login.enterUserName(userName);
        String password = data.get(2);
        login.enterPassword(password);
        HomePage home = login.clickOnLogin();
        login.clickOnEndTourButton();
        String actualLoginDate = home.getLoginDate();
        String expectedLoginDate = home.getCurrentDate();
        Assert.assertEquals(actualLoginDate,expectedLoginDate,Messages.LOGIN_DATE_VERIFICATION_FAILED);
    }
}
