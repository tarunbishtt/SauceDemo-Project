package org.example.tests;

import org.example.base.BaseTest;
import org.example.pages.CheckoutPage;
import org.example.pages.CartPage;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.testdata.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test(priority = 1, groups = "Regression")
    public void testCompleteCheckout(){

        //Login
        new LoginPage(driver).login(
                TestData.valid_UserName,
                TestData.valid_Password
        );

        //Add product to cart
        HomePage homePage = new HomePage(driver);
        homePage.addProductToCart(TestData.product);
        homePage.clickCart();

        //Continue for checkout
        CartPage cartPage = new CartPage(driver);
        cartPage.checkOut();

        //Fill user details
        CheckoutPage checkOut = new CheckoutPage(driver);
        checkOut.enterDetails(
                TestData.first_Name,
                TestData.last_Name,
                TestData.zipCode);
        checkOut.clickContinue();
        checkOut.clickFinishButton();

        String confirmation = checkOut.getConfirmationMessage();
        Assert.assertEquals(confirmation, "Thank you for your order!",
                "Order confirmation success");
        System.out.println("Checkout test passed!");
    }
}
