package registerTestScenarios;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePageObjectClass;
import pageObject.RegisterPageObjectClass;
import testBase.BaseClass;
import utilities.DataProvidersClass;

public class TC008 extends BaseClass {

	@Test(dataProvider = "negativeregisterdata", dataProviderClass = DataProvidersClass.class, groups = {"regression",
			"negative"})
	public void wrongConfirmPassword(String firstName, String lastName, String email, String number, String password,
			String confirmPassword) {

		try {

			logger.info("**** Test case initiated ****");

			HomePageObjectClass homePage = new HomePageObjectClass(driver);
			homePage.clickMyAccount();
			homePage.clickRegister();
			System.out.println("navigation to register page successfull....");

			RegisterPageObjectClass rp = new RegisterPageObjectClass(driver);
			rp.sendFirstName(firstName);
			rp.sendLastName(lastName);
			rp.sendEmail(email);
			rp.sendTelephoneNumber(number);
			rp.sendPassword(password);
			rp.sendConfirmPassword(confirmPassword);	
			
			rp.clickNewsLetter();
			rp.clickAgree();
			rp.clickContinue();					
			String error = rp.confirmPasswordError();
			System.out.println("registration not successfull because of following error : " + error);
			Assert.assertEquals(error, "Password confirmation does not match password!");
			
			rp.scrollDownEndPage();

		}

		catch (Exception e) {

			logger.error("error occured");
			System.out.println("error occurred is : " + e);
			logger.debug("debugging started");
		}

	}
}
