package org.example.tests;

import org.example.base.BaseTest;
import org.example.pages.LoginPage;
import org.example.pages.HomePage;
import org.example.testdata.TestData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    //Test with valid credentials
    @Test(priority = 1, groups = "Smoke")
    public void testValidLogin(){
        System.out.println("Running: testValidLogin");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
               TestData.valid_UserName,
               TestData.valid_Password
        );

        HomePage homePage = new HomePage(driver);
        String title = homePage.getPageTitle();

        Assert.assertEquals(title, "Products",
                "should be on products page after login");
    }

    //test with invalid credentials
    @Test(priority = 2, groups = "Smoke")
    public void testInvalidLogin(){
        System.out.println("Running: testInvalidLogin");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                TestData.inValid_UserName,
                TestData.inValid_Password
        );
        Assert.assertTrue(loginPage.isErrorDisplayed(),
                "Error message should be displayed!");
        System.out.println(loginPage.getErrorMessage());
        System.out.println("invalid login test passed");
    }

    @Test(priority = 3, groups = "Smoke")
    public void logOut(){
        System.out.println("Running: logout test");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                TestData.valid_UserName,
                TestData.valid_Password
        );

        HomePage homePage = new HomePage(driver);
        homePage.logout();

        Assert.assertTrue(driver.getCurrentUrl().
                        contains("saucedemo.com"),
                "Should be back to login page");
        System.out.println("testLogout PASSED!");
    }
}
