package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeletePlaylistPageTest extends TestBase {

    private DeletePlaylistPage deletePage;

    @Test
    public void testDeletePlaylist() throws InterruptedException {
        // Instantiate the DeletePlaylistPage class
        deletePage = new DeletePlaylistPage(driver);

        // Remove the playlist named "My Playlist"
        deletePage.removePlaylist("Test Playlist");

        // Verify that the playlist has been deleted
        boolean isPlaylistDeleted = driver.findElements(By.xpath("//a[@title='My Playlist']")).isEmpty();
        Assert.assertTrue(isPlaylistDeleted, "Playlist was not deleted successfully.");
    }
}
