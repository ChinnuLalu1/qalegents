package org.qalegent.test;

import org.qalegent.automatiocore.Base;
import org.qalegent.dataprovider.DataProviders;
import org.qalegent.pages.HomePage;
import org.qalegent.pages.LoginPage;
import org.selenium.qalegent.constance.Constance;
import org.selenium.qalegent.constance.Messages;
import org.selenium.qalegent.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class LoginPageTest extends Base {
    @Test(groups = {"Sanity"})
    public void verifyLoginPageTitle(){
        LoginPage login=new LoginPage(driver);
        String actualPageTitle=login.getPageTitle();
        ArrayList <String> data = ExcelUtility.readData(Constance.TEST_DATA_EXCEL_PATH,Constance.LOGIN_PAGE);
        String expectedPageTitle = data.get(0);
        Assert.assertEquals(actualPageTitle,expectedPageTitle, Messages.TITLE_MISMATCH);
    }
    @Test(groups = {"Smoke"})
    public void verifyUserLoginWithValidCredentials(){
        LoginPage login = new LoginPage(driver);
        ArrayList<String> data = ExcelUtility.readData(Constance.TEST_DATA_EXCEL_PATH,Constance.LOGIN_PAGE);
        String userName = data.get(1);
        login.enterUserName(userName);
        String password = data.get(2);
        login.enterPassword(password);
        HomePage home = login.clickOnLogin();
    }
    @Test(groups = {"Smoke"},dataProvider = "verifyInvalidLoginCredentials",dataProviderClass = DataProviders.class)
    public void verifyErrorMessageWhileLoginWithInvalidCredential(String userName,String password){
        LoginPage login =new LoginPage(driver);
        login.enterUserName(userName);
        login.enterPassword(password);
        login.clickOnLogin();
        String actualLoginErrorMessage = login.getText();
        ArrayList<String> data = ExcelUtility.readData(Constance.TEST_DATA_EXCEL_PATH,Constance.LOGIN_PAGE);
        String expectedLoginErrorMessage = data.get(3);
        Assert.assertEquals(actualLoginErrorMessage,expectedLoginErrorMessage,Messages.LOGIN_FAILED);
    }

}
