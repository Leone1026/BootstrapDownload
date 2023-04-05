package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BootstrapDownload {
    WebDriver driver;

    public BootstrapDownload(WebDriver driver) {
        this.driver = driver;
    }

    private final String url = "https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html";
    private final By downloadButton = By.id("cricle-btn");

    private final By percentText = By.xpath("//*[@class='percenttext']");

    public void navigate() {
        driver.get(url);
    }

    public void clickDownload() {
        driver.findElement(downloadButton).click();
    }

    public String readPercent() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.textToBe(percentText, "100%"));
        String percent = driver.findElement(percentText).getText();
        return percent;
    }


}