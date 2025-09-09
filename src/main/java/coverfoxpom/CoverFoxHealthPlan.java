package coverfoxpom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFoxHealthPlan {
    
    private static final Logger logger = LoggerFactory.getLogger(CoverFoxHealthPlan.class);
    protected WebDriver driver;

    // Locators
    @FindBy(xpath = "//div[@class='gb--option gb--active']") 
    private WebElement gender;

    @FindBy(xpath = "//div[text()='Wife']") 
    private WebElement wife;

    @FindBy(xpath = "//div[text()='Daughter']") 
    private WebElement daughter;

    @FindBy(xpath = "(//div[@class='next-btn'])") 
    private WebElement nextButton;

    // Constructor
    public CoverFoxHealthPlan(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logger.info("CoverFoxHealthPlan page initialized.");
    }

    public void selectGender() {
        try {
            gender.click();
            logger.info("Selected Gender option.");
        } catch (Exception e) {
            logger.error("Failed to select Gender option.", e);
        }
    }

    public void selectWife() {
        try {
            wife.click();
            logger.info("Selected 'Wife' option.");
        } catch (Exception e) {
            logger.error("Failed to select 'Wife' option.", e);
        }
    }

    public void selectDaughter() {
        try {
            daughter.click();
            logger.info("Selected 'Daughter' option.");
        } catch (Exception e) {
            logger.error("Failed to select 'Daughter' option.", e);
        }
    }

    public void clickNextButton() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", nextButton);
            nextButton.click();
            logger.info("Clicked on Next button.");
        } catch (Exception e) {
            logger.error("Failed to click on Next button.", e);
        }
    }
}
