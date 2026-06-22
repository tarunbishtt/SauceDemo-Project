package org.example.base;

import org.example.utils.DriverSetup;
import org.example.testdata.TestData;
import org.example.utils.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverSetup.getDriver("chrome");
        driver.get(TestData.base_Url);
        System.out.println("Chrome Browser Opened!");
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE){
            System.out.println("Test failed: " + result.getName());
            ScreenshotUtils.takeScreenshot(
                    driver,
                    result.getName()
            );
        }
        DriverSetup.quitDriver();
        System.out.println("Browser Closed!\n");
    }
}
