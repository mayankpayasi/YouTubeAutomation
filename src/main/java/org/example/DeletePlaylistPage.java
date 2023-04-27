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

    private By optionButton = By.xpath("//*[@id=\"button-shape\"]/button/yt-touch-feedback-shape/div/div[2]");
    private By deletePlaylistButton = By.xpath("//tp-yt-paper-listbox[@id='items']/ytd-menu-service-item-renderer[5]/tp-yt-paper-item/yt-formatted-string");
    private By confirmDeleteButton = By.xpath("//yt-button-renderer[@id='confirm-button']/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]");

    public void removePlaylist() throws InterruptedException {
        Actions actions = new Actions(driver);

        // Navigate to the library page
        WebElement optionButtonElement = driver.findElement(optionButton);
        actions.moveToElement(optionButtonElement).click().perform();
        Thread.sleep(1000);

        // Click the delete playlist button and confirm deletion
        WebElement deletePlaylistButtonElement = driver.findElement(deletePlaylistButton);
        actions.moveToElement(deletePlaylistButtonElement).click().perform();
        Thread.sleep(1000);

        WebElement confirmDeleteButtonElement = driver.findElement(confirmDeleteButton);
        actions.moveToElement(confirmDeleteButtonElement).click().perform();
        Thread.sleep(2000);
    }
}
