package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartTest {
    public static void main(String[] args) {
        // Set the path for the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "D:\\Software testing\\Chrome driver files\\chromedriver-win64\\chromedriver.exe");

        // Initialize a new ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        try {
            // Step 1: Open Google
            driver.get("https://www.google.com");

            // Step 2: Maximize the browser window
            driver.manage().window().maximize();

            // Step 3: Open the Flipkart website
            driver.get("https://www.flipkart.com");

            // Close the login popup if it appears
            try {
                WebElement closeLoginPopup = driver.findElement(By.cssSelector("button._2KpZ6l._2doB4z"));
                closeLoginPopup.click();
            } catch (Exception e) {
                System.out.println("Login popup did not appear.");
            }

            // Step 4: Select any tab and click it (e.g., the Electronics tab)
            WebElement electronicsTab = driver.findElement(By.xpath("//span[text()='Electronics']"));
            electronicsTab.click();

            // Perform a search
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Gaming laptops");
            searchBox.submit();

            // Delay to keep the window open for 5 seconds
            Thread.sleep(1500);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
