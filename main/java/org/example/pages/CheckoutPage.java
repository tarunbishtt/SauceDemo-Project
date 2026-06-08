package org.example.pages;

import org.example.testdata.TestData;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //Locators
    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By zipCodeField = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By finishButton = By.id("finish");
    private final By cancelButton = By.id("cancel");
    private final By confirmationMessage = By.className("complete-header");

    //constructor
    public CheckoutPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void enterDetails(String firstName,
                             String lastName,
                             String zipCode){
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(zipCodeField).sendKeys(zipCode);
    }

    public void clickContinue(){
        driver.findElement(continueButton).click();
    }

    public void clickFinishButton(){
        driver.findElement(finishButton).click();
    }

    public void clickCancelButton(){
        driver.findElement(cancelButton).click();
    }

    public String getConfirmationMessage(){
       return wait.until(ExpectedConditions
                       .visibilityOfElementLocated(confirmationMessage))
                        .getText();
    }
}
