package org.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By userNameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector(".error-message-container");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterUserName(String userName){
        wait.until(ExpectedConditions.
                visibilityOfElementLocated(userNameField))
                .sendKeys(userName);
    }
    public void enterPassword(String password){
        wait.until(ExpectedConditions.
            visibilityOfElementLocated(passwordField))
                .sendKeys(password);
    }
    public void clickLogin(){
        driver.findElement(loginButton).click();
    }
    //combined login
    public void login(String userName, String password){
        enterUserName(userName);
        enterPassword(password);
        clickLogin();
        System.out.println("login attempt with: " + userName);
    }

    //verification
    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }

    public boolean isErrorDisplayed(){
        try{
            return driver.findElement(errorMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
