package registerTestScenarios;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePageObjectClass;
import pageObject.RegisterPageObjectClass;
import testBase.BaseClass;

public class TC004 extends BaseClass {

	@Test(groups = {"sanity", "negative"})
	public void accountRegWithOutAnyFields() {


		try {
			
			logger.info("****  Test case initiated ****");
			
			HomePageObjectClass homePage = new HomePageObjectClass(driver);
			RegisterPageObjectClass rp = new RegisterPageObjectClass(driver);

			homePage.clickMyAccount();
			homePage.clickRegister();
			rp.clickContinue();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			rp.firstNameError();
			rp.lastNameError();
			rp.telephoneError();
			rp.emailError();
			rp.passwordError();
			rp.policyError();

		} catch (Exception e) {
			logger.error("error occured");
			logger.debug("debugging started");
			Assert.fail();
		}

	}

}
