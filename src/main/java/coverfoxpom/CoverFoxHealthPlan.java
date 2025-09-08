package coverfoxpom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoverFoxHealthPlan {
    protected WebDriver driver;
       // Write locator 
    @FindBy(xpath = "(//div[@class='next-btn'])[1]") 
    private WebElement nextbutton;

    @FindBy(xpath = "//div[@class='sel-mem-container']//div[1]//div[1]//img[1]") 
    private WebElement gender;
    @FindBy(xpath = "//div[@class='ms-option selected']") private WebElement Wife;
    
    @FindBy(xpath = "//div[@class='member-container']//div[3]") private WebElement Daughter;

    public CoverFoxHealthPlan(WebDriver driver  ) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectGender() {
        gender.click();
    }
    public void selectwife() {
    	Wife.click();
    }
    public void selectDaughter() {
    	Daughter.click();
    }
    public void clickNextButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", nextbutton);
        nextbutton.click();
       
    }
}
