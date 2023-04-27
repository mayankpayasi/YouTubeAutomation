package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RenamePlaylistPageTest extends TestBase {

    private RenamePlaylistPage renamePage;

    @Test
    public void testRenamePlaylist() throws InterruptedException {
        // Instantiate the RenamePlaylistPage class
        renamePage = new RenamePlaylistPage(driver);

        // Rename the playlist named "My Playlist" to "New Playlist"
        renamePage.renamePlaylist("My Playlist", "New Playlist");

        // Verify that the playlist has been renamed
        WebElement renamedPlaylistLink = driver.findElement(By.xpath("//a[@title='New Playlist']"));
        Assert.assertTrue(renamedPlaylistLink.isDisplayed(), "Playlist was not renamed successfully.");
    }
}


