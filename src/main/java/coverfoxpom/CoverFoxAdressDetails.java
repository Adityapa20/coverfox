package coverfoxpom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoverFoxAdressDetails {
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	private static final Logger logger = LoggerFactory.getLogger(CoverFoxAdressDetails.class.getName());
	@FindBy(xpath = "//input[@placeholder='6 Digit Pincode']") private WebElement pincode;
	
	@FindBy(xpath = "//input[@id='want-expert']") private WebElement mobileN; 
	
	@FindBy(xpath = "//div[@class='next-btn']") private WebElement nextButton;
	
	public CoverFoxAdressDetails( WebDriver driver , WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
		
	}
	
	public void enterpincode(String pin) {
	    wait.until(ExpectedConditions.visibilityOf(nextButton));

		pincode.sendKeys(pin);
		logger.info(" Succesfully Pincode entered: " + pin);
	}
	
	public void entermobile(String mobile) {
		wait.until(ExpectedConditions.visibilityOf(mobileN));
		mobileN.sendKeys(mobile);
		logger.info("enter mobile number succesfully" +  mobile);
	}
	
	public void clicknext() {
		wait.until(ExpectedConditions.elementToBeClickable(nextButton));
		nextButton.click();
	}

}
