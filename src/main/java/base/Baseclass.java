package base;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Properties config;

    @BeforeClass
    public void setUp() throws IOException {
        // Load config.properties from resources
        config = new Properties();
        config.load(getClass().getClassLoader().getResourceAsStream("config.properties"));

        String browser = config.getProperty("browser", "chrome"); // default chrome
        String appUrl = config.getProperty("url");

        if (appUrl == null || appUrl.isEmpty()) {
            throw new RuntimeException("❌ URL is missing in config.properties!");
        }

        // Browser selection
        switch (browser.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions opt = new ChromeOptions();
                opt.addArguments("--incognito");
                opt.addArguments("--start-maximized");
                driver = new ChromeDriver(opt);
                break;
        }

        // Timeouts
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(15));
        driver.manage().deleteAllCookies();

        // Explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Launch URL
        System.out.println("✅ Launching: " + appUrl);
        driver.get(appUrl);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
