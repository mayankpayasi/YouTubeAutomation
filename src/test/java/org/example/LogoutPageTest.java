package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutPageTest extends TestBase {

    private LogoutPage logoutPage;

    @Test
    public void testLogout() throws InterruptedException {
        // Instantiate the LogoutPage class
        logoutPage = new LogoutPage(driver);

        // Log out of the current account
        logoutPage.logout();

        // Verify that the user has been logged out by checking if the sign-in button is present
        boolean isSignInButtonPresent = driver.findElements(By.xpath("//yt-formatted-string[text()='Sign in']")).size() > 0;
        Assert.assertTrue(isSignInButtonPresent, "User was not logged out successfully.");
    }
}
