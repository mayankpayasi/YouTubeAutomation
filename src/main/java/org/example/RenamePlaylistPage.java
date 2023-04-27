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
    private By libraryMenu = By.xpath("(//a[@id='endpoint']/tp-yt-paper-item/yt-formatted-string)[9]");
    private By editPlaylistButton = By.xpath("//*[@id=\"edit-button\"]/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]");

    private By playlistNameInput = By.xpath("//*[@id=\"input-3\"]/input");
    private By saveButton = By.xpath("//*[@id=\"save-button\"]/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]");

    public void renamePlaylist(String oldPlaylistName, String newPlaylistName) throws InterruptedException {
        Actions actions = new Actions(driver);

        // Navigate to the library page
        WebElement libraryButtonElement = driver.findElement(libraryButton);
        actions.moveToElement(libraryButtonElement).click().perform();
        Thread.sleep(2000);

        WebElement libraryMenuElement = driver.findElement(libraryMenu);
        actions.moveToElement(libraryMenuElement).click().perform();
        Thread.sleep(2000);

        // Click the edit playlist button and update playlist name
        WebElement editPlaylistButtonElement = driver.findElement(editPlaylistButton);
        actions.moveToElement(editPlaylistButtonElement).click().perform();
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
