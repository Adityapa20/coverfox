package actiondriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Action {
	private WebDriver driver;

	public Action(WebDriver driver) {
		this.driver = driver;
	}

	public void click(WebElement element) {
		try {
			element.click();
			System.out.println("Clicked on element: " + element);
		} catch (Exception e) {
			System.out.println("Unable to click on element: " + element);
			e.printStackTrace();
		}

	}
	public void type(WebElement element, String text) {
		try {
			element.sendKeys(text);
			System.out.println("Typed text '" + text + "' into element: " + element);
		} catch (Exception e) {
			System.out.println("Unable to type text into element: " + element);
			e.printStackTrace();
		}
	}
	public void actionsClick(WebElement element) {
		try {
			org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
			actions.moveToElement(element).click().build().perform();
			System.out.println("Actions clicked on element: " + element);
		} catch (Exception e) {
			System.out.println("Unable to actions click on element: " + element);
			e.printStackTrace();
		}
	}

}
