package coverfoxpom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CoverfoxMemberDetails {

    private static final Logger logger = LoggerFactory.getLogger(CoverfoxMemberDetails.class);

    protected WebDriver driver;

    @FindBy(id = "Age-Spouse")
    private WebElement spouseAgeDropdown;

    @FindBy(id = "Age-Daughter-0")
    private WebElement daughterAgeDropdown;

    @FindBy(xpath = "//div[@class='next-btn']")
    private WebElement nextButton;

    public CoverfoxMemberDetails(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectSpouseAge(String age) {
        Select select = new Select(spouseAgeDropdown);
        select.selectByValue(age);
        logger.info("Selected Spouse Age: {}", age);
    }

    public void selectDaughterAge(String age) {
        Select select = new Select(daughterAgeDropdown);
        select.selectByValue(age);
        logger.info("Selected Daughter Age: {}", age);
    }

    public void clickNext() {
        nextButton.click();
        logger.info("Clicked on Next button.");
    }
}
