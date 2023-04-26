package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class YouTubeHomePage {

    private static ChromeDriver driver;

    // Constructor
    public YouTubeHomePage(ChromeDriver driver) {
        this.driver = driver;
    }

    // Page elements
    private By signInButton = By.xpath("//*[@id=\"buttons\"]/ytd-button-renderer/yt-button-shape/a/yt-touch-feedback-shape/div/div[2]");

    // Page methods
    public void openHomePage() {
        driver.get("https://www.youtube.com/");
        driver.manage().window().maximize();
    }

    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }


    public static class YouTubeLoginPage{
        // Page elements
        private By emailInput = By.xpath("//*[@id=\"identifierId\"]");
        private By emailNextButton = By.xpath("//*[@id=\"identifierNext\"]/div/button");
        private By passwordInput = By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input");
        private By passwordNextButton = By.xpath("//*[@id=\"passwordNext\"]/div/button/span");

        public YouTubeLoginPage(ChromeDriver driver) {

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
    }
}

