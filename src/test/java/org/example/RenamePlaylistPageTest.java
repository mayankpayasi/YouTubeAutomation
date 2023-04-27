package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RenamePlaylistPageTest extends TestBase {

    private RenamePlaylistPage renamePage;

    @Test
    public void testRenamePlaylist() throws InterruptedException {
        // Arrange
        String oldPlaylistName = "Test Playlist";
        String newPlaylistName = "New Playlist";

        // Instantiate the RenamePlaylistPage class
        renamePage = new RenamePlaylistPage(driver);

        // Act
        renamePage.renamePlaylist(oldPlaylistName, newPlaylistName);
    }
}