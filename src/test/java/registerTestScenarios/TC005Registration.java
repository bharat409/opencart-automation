package registerTestScenarios;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountCreatedObjectClass;
import pageObject.AccountLogoutPage;
import pageObject.HomePageObjectClass;
import pageObject.MyAccountPageObjectClass;
import pageObject.RegisterPageObjectClass;
import testBase.BaseClass;
import utilities.DataProvidersClass;

//implemented through hard coded data provider class
public class TC005Registration extends BaseClass {

	@Test(dataProvider = "RegisterExcelData", dataProviderClass = DataProvidersClass.class, groups = { "sanity",
			"positive" })
	public void accountregistration(String firstName, String lastName, String email, String number, String password,
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
			System.out.println("registration successfull....");

			AccountCreatedObjectClass acoc = new AccountCreatedObjectClass(driver);
			acoc.clickContinue();
			System.out.println("Account created successfull....");

			MyAccountPageObjectClass mapoc = new MyAccountPageObjectClass(driver);
			mapoc.clickMyAccount();
			mapoc.clickLogOut();
			System.out.println("log out successfull....");

			AccountLogoutPage al = new AccountLogoutPage(driver);
			al.clickDirectReg();

			System.out.println("navigation to home successful....");
		}

		catch (Exception e) {

			logger.error("**** Test case errored out ****");
			logger.debug("**** Debugging started ****");
			Assert.fail();

		}

	}

}
