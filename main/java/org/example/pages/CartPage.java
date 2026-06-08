package org.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;

import javax.swing.*;
import java.time.Duration;


public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //Locators
private final By pageTitle = By.className("title");
private final By checkOutButton = By.id("checkout");
private final By continueButton = By.id("continue-shopping");

public CartPage(WebDriver driver){
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
}

public String getPageTitle(){
    return wait.until(ExpectedConditions.
                    visibilityOfElementLocated(pageTitle))
                    .getText();
}

public void checkOut(){
    driver.findElement(checkOutButton).click();
}

public void continueShopping(){
    driver.findElement(continueButton).click();
}

public boolean isProductInCart(String productName){
    try {
        By product = By.xpath("//div[@class = 'inventory_item_name' " +
                "and text() = '" + productName + "' ]");

        return driver.findElement(product).isDisplayed();
    }
    catch (Exception e){
        return false;
        }
    }
}
