package org.example.tests;

import org.example.base.BaseTest;
import org.example.pages.CartPage;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.testdata.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {
    @Test(priority = 1, groups = "Regression")
    public void itemInCart(){
        System.out.println("Running Add to cart test");

        //Login first
        new LoginPage(driver).login(
                TestData.valid_UserName,
                TestData.valid_Password
        );
        //Add product to cart
        HomePage homePage = new HomePage(driver);
        homePage.addProductToCart(TestData.product);

        //Verify cart count
        Assert.assertEquals(homePage.getCartCount(),"1",
                "Cart should have 1 item");
        System.out.println("Add to cart test pass");
    }

    //View cart
    @Test(priority = 2, groups = "Regression")
    public void viewCart(){
        //Login first
        new LoginPage(driver).login(
                TestData.valid_UserName,
                TestData.valid_Password
        );

        //Add product to cart
        HomePage homePage = new HomePage(driver);
        homePage.addProductToCart(TestData.product);
        homePage.clickCart();

        //Verify cart page
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getPageTitle(),"Your Cart",
                "Should be on cart page!");
        Assert.assertTrue(cartPage.isProductInCart(TestData.product),
                "Product should be in cart!");
        System.out.println("View cart test passed!");
    }
}
