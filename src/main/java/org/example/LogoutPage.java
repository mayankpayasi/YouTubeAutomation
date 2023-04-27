package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
    private WebDriver driver;
    private By avatarButton = By.xpath("//button[@id='avatar-btn']/yt-img-shadow/img");
    private By signOutButton = By.xpath("(//div[@id='primary-text-container']/yt-formatted-string)[10]");

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logout() throws InterruptedException {
        // Click on the avatar button to open the account menu
        driver.findElement(avatarButton).click();
        Thread.sleep(2000);

        // Click on the sign out button to log out
        driver.findElement(signOutButton).click();
        Thread.sleep(2000);
    }
}

