import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.BootstrapDownload;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestBootstrapDownload {
    WebDriver driver;

    @BeforeEach
    public void init() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("ignore-certificate-errors");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TestBSDownload() {
        BootstrapDownload bootstrapDownload = new BootstrapDownload(driver);
        bootstrapDownload.navigate();
        bootstrapDownload.clickDownload();
        Assertions.assertTimeout(Duration.ofSeconds(30), () -> {
            bootstrapDownload.readPercent();
        });

    }


}
