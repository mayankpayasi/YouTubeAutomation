package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class YouTubeLoginPage {

    private ChromeDriver driver;

    // Page elements
    private By emailInput = By.xpath("//*[@id=\"identifierId\"]");
    private By emailNextButton = By.xpath("//*[@id=\"identifierNext\"]/div/button");
    private By passwordInput = By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input");
    private By passwordNextButton = By.xpath("//*[@id=\"passwordNext\"]/div/button/span");
    private By loginErrorMessage = By.xpath("//div[contains(@class, 'o6cuMc')]");

    public YouTubeLoginPage(ChromeDriver driver) {
        this.driver = driver;
    }

    // Page methods
    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void clickEmailNextButton() {
        driver.findElement(emailNextButton).click();
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickPasswordNextButton() {
        driver.findElement(passwordNextButton).click();
    }

    public boolean isLoginErrorMessageDisplayed() {
        return driver.findElements(loginErrorMessage).size() > 0;
    }
}