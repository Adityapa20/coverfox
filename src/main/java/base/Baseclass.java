package base;

import java.time.Duration;


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
    protected WebDriverWait wait; // ADD THIS

	@BeforeClass
	 public void setUp() {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--incognito");  // enable incognito mode
        opt.addArguments("--start-maximized"); // optional: start maximized

		 driver = new ChromeDriver(opt);
		 
		 
		 
		 driver.manage().window().maximize();
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 driver.manage().deleteAllCookies();
		 
         driver.get("https://www.coverfox.com/");	
         
	     
	    }
	@AfterClass
	public void TearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
	

}
