package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class YouTubeLoginPageTest extends TestBase {

    private YouTubeHomePage homePage;

    @Test
    public void testLoginFail() throws InterruptedException {
        // Instantiate the YouTubeHomePage class
        homePage = new YouTubeHomePage(driver);

        // Open the YouTube homepage and click the Sign In button
        homePage.openHomePage();
        Thread.sleep(2000);
        homePage.clickSignInButton();

        // Fill in invalid login credentials and submit
        YouTubeLoginPage loginPage = new YouTubeLoginPage(driver);
        loginPage.enterEmail("invalidemail@example.com");
        loginPage.clickEmailNextButton();
        Thread.sleep(3000);
        loginPage.enterPassword("invalidpassword");
        loginPage.clickPasswordNextButton();
        Thread.sleep(2000);

        // Verify that login fails and user is not logged in
        Assert.assertTrue(loginPage.isLoginErrorMessageDisplayed());
    }
}