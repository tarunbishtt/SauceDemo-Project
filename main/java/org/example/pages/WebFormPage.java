package org.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;


public class WebFormPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By inputText  = By.id("my-text-id");
    private By passwordInput = By.name("my-password");
    private By dropdown = By.name("my-select");
    private By submitButton = By.xpath("//button[@type='submit']");

    public WebFormPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }



    public void enterText(String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputText)).sendKeys(text);
        System.out.println("Entered text: " + text);
    }

    public void enterPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput)).sendKeys(password);
        System.out.println("Entered Password: " + password);
    }

    public void selectDropdownOption(String option){
        Select select = new Select(driver.findElement(dropdown));
        select.selectByVisibleText(option);
        System.out.println("Selected option: " + option);
    }

    public void clickSubmit(){
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
        System.out.println("Form submitted!");
    }

    public String getPageTitle() {
        return driver.getTitle();
    }


}
