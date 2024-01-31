package org.qalegent.test;

import org.qalegent.automatiocore.Base;
import org.qalegent.pages.LoginPage;
import org.qalegent.pages.ResetPage;
import org.selenium.qalegent.constants.Constants;
import org.selenium.qalegent.constants.Messages;
import org.selenium.qalegent.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ResetPagetest extends Base {
    @Test(groups = {"Sanity"})
    public void verifyResetPageTitle(){
        LoginPage login =new LoginPage(driver);
        ResetPage reset = login.clickOnForgetPassword();
        String actualPageTitle=reset.getPageTitle();
        ArrayList<String> data = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.RESET_PAGE);
        String expectedPageTitle = data.get(0);
        Assert.assertEquals(actualPageTitle,expectedPageTitle, Messages.TITLE_MISMATCH);

    }
    @Test(groups = {"Regression"})
    public void verifyErrorMessageWithInvalidEmailId(){
        LoginPage login =new LoginPage(driver);
        ResetPage reset = login.clickOnForgetPassword();
        ArrayList<String> data = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.RESET_PAGE);
        String email = data.get(1);
        reset.enterEmail(email);
        reset.clickOnPasswordResetLink();
        String actualWrongUserEmailText =reset.getText();
        String expectedWrongUserEmailText = data.get(2);
        Assert.assertEquals(actualWrongUserEmailText,expectedWrongUserEmailText,Messages.WRONG_USER_EMAIL);


    }
}
