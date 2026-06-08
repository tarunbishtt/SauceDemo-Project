package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private final By pageTitle = By.className("title");
    private final By cartIcon = By.className("shopping_cart_link");
    private final By cartBadge = By.className("shopping_cart_badge");
    private final By menuButton = By.id("react-burger-menu-btn");
    private final By logoutLink = By.id("logout_sidebar_link");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Actions
    public String getPageTitle() {
        return wait.until(ExpectedConditions
                        .visibilityOfElementLocated(pageTitle))
                .getText();
    }

    public void addProductToCart(String productName) {
        // Find add to cart button for specific product
        By addToCartBtn = By.xpath(
                "//div[text()='" + productName +
                        "']/ancestor::div[@class='inventory_item']" +
                        "//button[text()='Add to cart']"
        );
        driver.findElement(addToCartBtn).click();
        System.out.println("Added to cart: " + productName);
    }

    public String getCartCount() {
        try {
            return driver.findElement(cartBadge).getText();
        } catch (Exception e) {
            return "0";
        }
    }

    public void clickCart() {
        driver.findElement(cartIcon).click();
    }

    public void logout() {
        driver.findElement(menuButton).click();
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(logoutLink))
                .click();
        System.out.println("Logged out!");
    }
}