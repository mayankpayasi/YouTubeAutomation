package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class YouTubeHomePageTest extends TestBase {

    private YouTubeHomePage homePage;

    @Test
    public void testSignIn() throws InterruptedException {
        // Instantiate the YouTubeHomePage class
        homePage = new YouTubeHomePage(driver);

        // Open the YouTube homepage and click the Sign In button
        homePage.openHomePage();
        Thread.sleep(2000);
        homePage.clickSignInButton();

        // Fill in wrong login credentials and submit
        YouTubeHomePage.YouTubeLoginPage loginPage = new YouTubeHomePage.YouTubeLoginPage(driver);
        loginPage.enterEmail("wrongemail@example.com"); // enter wrong email ID
        loginPage.clickEmailNextButton();
        Thread.sleep(2000);

        // Clear the wrong email ID and enter the correct email ID
        loginPage.clearEmail();

        loginPage.enterEmail("Epamca3@gmail.com");
        loginPage.clickEmailNextButton();
        Thread.sleep(3000);
        loginPage.enterPassword("Qwer@123");
        loginPage.clickPasswordNextButton();
        Thread.sleep(2000);
        // Verify that the user is logged in
        Assert.assertTrue(driver.getTitle().contains("YouTube"));
        Thread.sleep(2000);
    }
}