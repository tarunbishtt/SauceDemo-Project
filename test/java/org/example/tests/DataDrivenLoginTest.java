package org.example.tests;

import org.example.base.BaseTest;
import org.example.pages.LoginPage;
import org.example.pages.HomePage;
import org.example.testdata.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataDrivenLoginTest extends BaseTest {

    @Test(dataProvider = "login_data",
            dataProviderClass = TestData.class)
    public void testLoginWithExcelData(
            String username,
            String password,
            String expectedResult) {

        System.out.println("Testing with: " + username);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        if (expectedResult.equals("success")) {
            // Verify successful login
            HomePage homePage = new HomePage(driver);
            Assert.assertEquals(
                    homePage.getPageTitle(),
                    "Products",
                    "Should be on products page!"
            );
            System.out.println("✅ Login success verified!");

        } else {
            // Verify error shown
            Assert.assertTrue(
                    loginPage.isErrorDisplayed(),
                    "Error should be shown!"
            );
            System.out.println("✅ Error verified for: " + username);
        }
    }
}