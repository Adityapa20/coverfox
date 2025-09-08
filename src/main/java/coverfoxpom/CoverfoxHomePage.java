package coverfoxpom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverfoxHomePage {
	private WebDriver driver;

	// ✅ Locators using PageFactory
	@FindBy(xpath = "//div[@class='w--radio__option radio_selected']")
	private WebElement MaleButtom;

	@FindBy(xpath  = "//input[@type='tel']")
	private WebElement MobileNumberButton;
    
	@FindBy(xpath = "//button[@title = 'Get Started']") private WebElement SubmitButton;
	// ✅ Constructor
	public CoverfoxHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// ✅ Page Actions
	public String getHomePageTitle() {
		return driver.getTitle();
	}

	public void SelectGender() {
		MaleButtom.click();
	}

//	public void entermobile(String mobile) {
//		MobileNumberButton.sendKeys(mobile);
//	}
//	public void submitbutton() {
//		SubmitButton.click();
//	}
}
