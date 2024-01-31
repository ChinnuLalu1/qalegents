package org.qalegent.automatiocore;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.selenium.qalegent.utilities.WebDriverUtility;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Base {
    public WebDriver driver;
    public void initializeBrowser(String browser){
        if (browser.equals("Chrome")) {
            driver = new ChromeDriver();
        } else if(browser.equals("Edge")) {
            driver = new EdgeDriver();
        } else if (browser.equals("Firefox")) {
            driver=new FirefoxDriver();
        } else{
            throw new RuntimeException("Invalid Browser Received");
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies(); //detete cookies

    }
    /*public void closeBrowser()
    {
        driver.close();
    }*/
    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setUp(String browserName){
        initializeBrowser(browserName);
        WebDriverUtility.loadUrl(driver,"https://qalegend.com/billing/public/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) throws IOException {
        if(result.getStatus()==ITestResult.FAILURE){
            takeScreenShot(result);
        }
        driver.close();
    }
    public void takeScreenShot(ITestResult result) throws IOException {
        TakesScreenshot takesreenshot=(TakesScreenshot) driver;
        File screenShort=takesreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShort,new File("./SreenShort/"+result.getName()+".png"));
    }
}
