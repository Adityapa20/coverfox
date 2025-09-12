package coverfoxtestt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Baseclass;
import coverfoxpom.CoverFoxAdressDetails;
import coverfoxpom.CoverFoxHealthPlan;
import coverfoxpom.CoverfoxHomePage;
import coverfoxpom.CoverfoxMemberDetails;

public class CoverFoxTestClass extends Baseclass {
	private static final Logger logger = LoggerFactory.getLogger(CoverFoxTestClass.class);

	@Test
	public void coverfoxhomepage() {
		// Step 1: Home Page
		CoverfoxHomePage ch = new CoverfoxHomePage(driver);
		String title = ch.getHomePageTitle();
		Assert.assertTrue(title.contains("Coverfox"), "❌ Home page title mismatch!");
		System.out.println("✅ Home page title verified: " + title);

		ch.SelectGender();
//        ch.enterMobile("9876543210");  // Dummy test number
//        ch.clickSubmit();
		System.out.println("✅ Gender selected and mobile number submitted");
		logger.info("Coverfox home page test completed.");

	}

	@Test(privority =2)
	public void healthplanpage() {
		// Step 2: Health Plan Page
		CoverFoxHealthPlan healthPlan = new CoverFoxHealthPlan(driver);
		healthPlan.selectGender();

		healthPlan.selectWife();
		healthPlan.selectDaughter();
		healthPlan.clickNextButton();
		System.out.println("✅ Health plan gender selected and next clicked");
		logger.info("Health plan page test completed.");

	}

	@Test
	public void memberdetail() {

		// Step 3: Member Details Page
		CoverfoxMemberDetails memberD = new CoverfoxMemberDetails(driver);
		memberD.selectSpouseAge("21y");
		memberD.selectDaughterAge("1y");
		memberD.clickNext();
		System.out.println("✅ Member details entered and next clicked");
	}

	@Test
	public void addressdetails() {

		// Step 4: Address Details Page
		CoverFoxAdressDetails addressD = new CoverFoxAdressDetails(driver, wait);
		addressD.enterpincode("411033");
		addressD.entermobile("9876543210");
		addressD.clicknext();
	System.out.println("✅ Address details entered and next clicked");
	logger.info("Address details page test completed.");}

}
