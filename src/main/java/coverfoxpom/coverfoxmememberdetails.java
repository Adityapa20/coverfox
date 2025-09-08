package coverfoxpom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class coverfoxmememberdetails {
    protected WebDriver driver;

    @FindBy(id = "Age-You")
    private WebElement ageDropdown;

    public coverfoxmememberdetails(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // ✅ this is critical
    }

    public void selectAge(String age) {
        Select select = new Select(ageDropdown);
        select.selectByVisibleText(age);
    }
}
