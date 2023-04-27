package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
    private WebDriver driver;
    private By avatarButton = By.xpath("//button[@aria-label='Account']");
    private By signOutButton = By.xpath("//yt-formatted-string[text()='Sign out']");

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

