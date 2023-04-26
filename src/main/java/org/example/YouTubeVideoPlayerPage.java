package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class YouTubeVideoPlayerPage {
    private ChromeDriver driver;
    public YouTubeVideoPlayerPage(ChromeDriver driver) {
        this.driver = driver;
    }
    private By addToButton = By.xpath("//*[@id=\"button-shape\"]/button/yt-touch-feedback-shape/div/div[2]");
    private By createPlaylistOption = By.xpath("//*[@id=\"items\"]/ytd-menu-service-item-renderer[1]/tp-yt-paper-item/yt-icon");

    private By createNewPlaylistButton = By.xpath("//*[@id=\"content-icon\"]/yt-icon");
    private By playlistNameInput = By.xpath("//*[@id=\"input-1\"]/input");
    private By createPlaylistButton = By.xpath("//*[@id=\"actions\"]/ytd-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]");



    public void addToPlaylist(String playlistName) throws InterruptedException {
        WebElement addToButtonElement = driver.findElement(addToButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(addToButtonElement).click().perform();

        Thread.sleep(2000);
        WebElement createPlaylistOptionElement = driver.findElement(createPlaylistOption);
        actions.moveToElement(createPlaylistOptionElement).click().perform();

        Thread.sleep(2000);
        WebElement createNewPlaylistButtonElement = driver.findElement(createNewPlaylistButton);
        actions.moveToElement(createNewPlaylistButtonElement).click().perform();

        Thread.sleep(4000);
        WebElement playlistNameInputElement = driver.findElement(playlistNameInput);
        playlistNameInputElement.sendKeys(playlistName);

        Thread.sleep(2000);
        WebElement createPlaylistButtonElement = driver.findElement(createPlaylistButton);
        createPlaylistButtonElement.click();
    }
}
