package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    public static ChromeDriver driver;

    @BeforeSuite
    public void setUp() {
        // Set up ChromeDriver
        driver = new ChromeDriver();
    }
/*
    @AfterSuite
    public void tearDown() {
        // Close the ChromeDriver
        driver.quit();
    }

 */

}
