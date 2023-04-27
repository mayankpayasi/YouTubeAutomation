package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RenamePlaylistPage {
    private ChromeDriver driver;

    public RenamePlaylistPage(ChromeDriver driver) {
        this.driver = driver;
    }

    private By libraryButton = By.xpath("//*[@id=\"guide-icon\"]");
    private By libraryMenu = By.xpath("//*[@id=\"items\"]/ytd-guide-section-renderer[2]");
    private By playlistLink = By.xpath("//a[@title='My Playlist']");
    private By playlistTitle = By.xpath("//yt-formatted-string[@class='style-scope ytd-playlist-sidebar-primary-info-renderer']");
    private By editPlaylistButton = By.xpath("//yt-icon[@class='style-scope ytd-playlist-sidebar-primary-info-renderer']");

    private By playlistNameInput = By.xpath("//div[@id='container']//ytd-playlist-sidebar-primary-info-renderer//input[@id='editable-title']");
    private By saveButton = By.xpath("//div[@id='container']//ytd-playlist-sidebar-primary-info-renderer//yt-icon-button//button[@id='button']");

    public void renamePlaylist(String oldPlaylistName, String newPlaylistName) throws InterruptedException {
        Actions actions = new Actions(driver);

        // Navigate to the library page
        WebElement libraryButtonElement = driver.findElement(libraryButton);
        actions.moveToElement(libraryButtonElement).click().perform();
        Thread.sleep(2000);

        WebElement libraryMenuElement = driver.findElement(libraryMenu);
        WebElement playlistLinkElement = null;

        // Find the playlist link and click it
        for (WebElement element : libraryMenuElement.findElements(By.tagName("a"))) {
            if (element.getAttribute("title").equals(oldPlaylistName)) {
                playlistLinkElement = element;
                break;
            }
        }

        if (playlistLinkElement != null) {
            actions.moveToElement(playlistLinkElement).click().perform();
            Thread.sleep(2000);

            // Click the edit playlist button and update playlist name
            WebElement playlistTitleElement = driver.findElement(playlistTitle);
            WebElement editPlaylistButtonElement = driver.findElement(editPlaylistButton);
            actions.moveToElement(playlistTitleElement).click().moveToElement(editPlaylistButtonElement).click().perform();
            Thread.sleep(1000);

            WebElement playlistNameInputElement = driver.findElement(playlistNameInput);
            playlistNameInputElement.clear();
            playlistNameInputElement.sendKeys(newPlaylistName);
            Thread.sleep(1000);

            WebElement saveButtonElement = driver.findElement(saveButton);
            actions.moveToElement(saveButtonElement).click().perform();
            Thread.sleep(2000);
        }
    }
}
