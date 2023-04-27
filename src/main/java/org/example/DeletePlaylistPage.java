package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DeletePlaylistPage {
    private ChromeDriver driver;
    public DeletePlaylistPage(ChromeDriver driver) {
        this.driver = driver;
    }

    private By libraryButton = By.xpath("//*[@id=\"guide-icon\"]");
    private By libraryMenu = By.xpath("//div[@id='items']/ytd-guide-collapsible-section-entry-renderer[2]//yt-formatted-string[@id='title']");
    private By playlistLink = By.xpath("//a[@title='Test Playlist']");
    private By deletePlaylistButton = By.xpath("//*[@id=\"delete-playlist-button\"]");
    private By confirmDeleteButton = By.xpath("//*[@id=\"confirm-button\"]");

    public void removePlaylist(String playlistName) throws InterruptedException {
        Actions actions = new Actions(driver);

        // Navigate to the library page
        WebElement libraryButtonElement = driver.findElement(libraryButton);
        actions.moveToElement(libraryButtonElement).click().perform();
        Thread.sleep(2000);

        WebElement libraryMenuElement = driver.findElement(libraryMenu);
        WebElement playlistLinkElement = null;

        // Find the playlist link and click it
        for (WebElement element : libraryMenuElement.findElements(By.tagName("a"))) {
            if (element.getAttribute("title").equals(playlistName)) {
                playlistLinkElement = element;
                break;
            }
        }

        if (playlistLinkElement != null) {
            actions.moveToElement(playlistLinkElement).click().perform();
            Thread.sleep(2000);

            // Click the delete playlist button and confirm deletion
            WebElement deletePlaylistButtonElement = driver.findElement(deletePlaylistButton);
            actions.moveToElement(deletePlaylistButtonElement).click().perform();
            Thread.sleep(1000);

            WebElement confirmDeleteButtonElement = driver.findElement(confirmDeleteButton);
            actions.moveToElement(confirmDeleteButtonElement).click().perform();
            Thread.sleep(2000);
        }
    }
}
