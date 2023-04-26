package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class YouTubeSearchResultsPageTest extends TestBase {

    private YouTubeSearchResultsPage searchResultsPage;

    @Test
    public void testSearch() throws InterruptedException {
        // Instantiate the YouTubeSearchResultsPage class
        searchResultsPage = new YouTubeSearchResultsPage(driver);

        // Search for a query and click on the first video
        searchResultsPage.enterSearchQuery("nacho nacho");
        searchResultsPage.clickSearchButton();
        Thread.sleep(2000);
        searchResultsPage.clickFirstVideo();

        // Verify that the video is playing
        Thread.sleep(5000);
        Assert.assertTrue(driver.getTitle().contains(" - YouTube"));
    }
}



