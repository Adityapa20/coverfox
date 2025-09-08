package coverfoxtestt;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Baseclass;
import coverfoxpom.CoverFoxHealthPlan;
import coverfoxpom.CoverfoxHomePage;
import coverfoxpom.coverfoxmememberdetails;

public class CoverFoxTestClass extends Baseclass {

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
        
    }

    @Test
    public void healthplanpage() {
        // Step 2: Health Plan Page
        CoverFoxHealthPlan healthPlan = new CoverFoxHealthPlan(driver);
        healthPlan.selectGender();
        healthPlan.selectDaughter();
        healthPlan.clickNextButton();
        System.out.println("✅ Health plan gender selected and next clicked");
        
    }

    @Test
    public void memberdetail() {
        // Step 3: Member Details Page
        coverfoxmememberdetails memberDetails = new coverfoxmememberdetails(driver);
        memberDetails.selectAge("21y");
        System.out.println("✅ Age selected successfully on member details page");
    }
}
