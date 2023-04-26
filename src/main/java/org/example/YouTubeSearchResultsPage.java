package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class YouTubeSearchResultsPage {

    private ChromeDriver driver;

    // Constructor
    public YouTubeSearchResultsPage(ChromeDriver driver) {
        this.driver = driver;
    }

    // Page elements
    private By searchInput = By.name("search_query");
    private By searchButton = By.id("search-icon-legacy");
    private By firstVideo = By.xpath("//*[@id=\"video-title\"]/yt-formatted-string");

    // Page methods
    public void enterSearchQuery(String query) {
        driver.findElement(searchInput).sendKeys(query);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public void clickFirstVideo() {
        WebElement video = driver.findElement(firstVideo);
        Actions actions = new Actions(driver);
        actions.moveToElement(video).click().perform();
    }
}

