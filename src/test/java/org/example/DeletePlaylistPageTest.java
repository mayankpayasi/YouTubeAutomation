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
        //deletePage.removePlaylist();


    }
}
