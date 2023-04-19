package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class AppTest {
    ChromeDriver driver;
    @BeforeClass
    void setupDriver () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.youtube.com/");
        driver.manage().window().maximize();
    }
    @Test(priority = 1)
    void loginYouTube() throws InterruptedException {

          driver.findElement(By.xpath("//*[@id=\"buttons\"]/ytd-button-renderer/yt-button-shape/a/yt-touch-feedback-shape/div/div[2]")).click();
          driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("Epamca3@gmail.com");
          Thread.sleep(100);
          driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button")).click();
          Thread.sleep(5000);
          driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("Qwer@123");
          Thread.sleep(1000);
          driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span")).click();
          Thread.sleep(10000);

    }
    @Test(priority = 2)
        void createPlaylist()throws InterruptedException{
        driver.findElement(By.name("search_query")).sendKeys("Naacho Naacho (Full Video) RRR - NTR");
        Thread.sleep(1000);
        driver.findElement(By.id("search-icon-legacy")).click();
        Thread.sleep(2000);
        WebElement video = driver.findElement(By.xpath("//*[@id=\"video-title\"]/yt-formatted-string"));
        Actions actions = new Actions(driver);
        actions.moveToElement(video).click().perform();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"button-shape\"]/button/yt-touch-feedback-shape/div/div[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"items\"]/ytd-menu-service-item-renderer[1]/tp-yt-paper-item/yt-icon")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"content-icon\"]/yt-icon")).click();
        Thread.sleep(1000);
        WebElement playlistName = driver.findElement(By.xpath("//*[@id=\"input-1\"]/input"));
        playlistName.sendKeys("My Playlist");
        driver.findElement(By.xpath("//*[@id=\"actions\"]/ytd-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")).click();
        Thread.sleep(1000);
    }
    @Test(priority = 3)
    void renamePlaylist()throws InterruptedException{
    driver.findElement(By.xpath("//*[@id=\"guide-icon\"]")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//*[@id=\"endpoint\"]/tp-yt-paper-item/yt-icon[1]")).click();
    Thread.sleep(3000);

  //  driver.findElement(By.xpath("//*[@id=\"endpoint\"]/tp-yt-paper-item/yt-icon[1]")).click();

    driver.findElement(By.xpath("//*[@id=\"endpoint\"]/tp-yt-paper-item/yt-formatted-string")).click();
        Thread.sleep(3000);

    }




    @AfterClass
    void closeDriver () {
        driver.close();
    }

}
