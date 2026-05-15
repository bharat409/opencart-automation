package registerTestScenarios;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePageObjectClass;
import pageObject.RegisterPageObjectClass;
import testBase.BaseClass;

/**
 * Test Case: TC_InvalidEmail
 * Scenario: Validate registering an account by providing an invalid email address into the E-Mail field
 * Expected Result: Error message should appear - "E-Mail Address does not appear to be valid!"
 */
public class TC_InvalidEmail extends BaseClass {

	@Test(groups = { "negative" })
	public void validateInvalidEmailRegistration() {

		try {

			logger.info("**** Test Case: Validate Registration with Invalid Email - Started ****");
			
			// Step 1: Navigate to My Account
			HomePageObjectClass homePage = new HomePageObjectClass(driver);
			homePage.clickMyAccount();
			logger.info("Clicked on My Account");
			
			// Step 2: Click on Register
			homePage.clickRegister();
			logger.info("Clicked on Register");
			System.out.println("Navigation to register page successful....");

			// Step 3: Fill registration form with invalid email
			RegisterPageObjectClass rp = new RegisterPageObjectClass(driver);
			
			String firstName = "John";
			String lastName = "Doe";
			String invalidEmail = "invalidemail";  // Invalid email without @ symbol
			String telephone = "9876543210";
			String password = "Password123";
			String confirmPassword = "Password123";
			
			logger.info("Filling registration form with following data:");
			logger.info("First Name: " + firstName);
			logger.info("Last Name: " + lastName);
			logger.info("Invalid Email: " + invalidEmail);
			logger.info("Telephone: " + telephone);
			logger.info("Password: " + password);
			
			rp.sendFirstName(firstName);
			rp.sendLastName(lastName);
			rp.sendEmail(invalidEmail);  // Sending invalid email
			rp.sendTelephoneNumber(telephone);
			rp.sendPassword(password);
			rp.sendConfirmPassword(confirmPassword);
			rp.clickNewsLetter();
			rp.clickAgree();
			
			// Step 4: Click Continue button
			rp.clickContinue();
			logger.info("Clicked on Continue button");
			
			// Step 5: Validate error message for invalid email
			rp.emailError();  // This method validates the error message and throws AssertionError if not found
			logger.info("**** Error message for invalid email validated successfully ****");
			
			System.out.println("Test case passed: Invalid email validation successful....");
			logger.info("**** Test Case: Validate Registration with Invalid Email - PASSED ****");

		} catch (Exception e) {

			logger.error("**** Test Case: Validate Registration with Invalid Email - FAILED ****");
			logger.debug("**** Debugging started ****");
			logger.error("Exception occurred: " + e.getMessage());
			e.printStackTrace();
			Assert.fail("Test failed with exception: " + e.getMessage());

		}

	}

	@Test(groups = { "negative" })
	public void validateMultipleInvalidEmailFormats() {

		try {

			logger.info("**** Test Case: Validate Multiple Invalid Email Formats - Started ****");
			
			String[] invalidEmails = {
					"invalidemail",              // No @ symbol
					"invalidemail@",             // Missing domain
					"@invaliddomain.com",        // Missing username
					"invalid..email@domain.com", // Double dots
					"invalid email@domain.com"   // Space in email
			};
			
			for (String invalidEmail : invalidEmails) {
				
				logger.info("Testing with invalid email: " + invalidEmail);
				
				// Navigate to register page for each test
				HomePageObjectClass homePage = new HomePageObjectClass(driver);
				homePage.clickMyAccount();
				homePage.clickRegister();
				
				RegisterPageObjectClass rp = new RegisterPageObjectClass(driver);
				
				rp.sendFirstName("John");
				rp.sendLastName("Doe");
				rp.sendEmail(invalidEmail);
				rp.sendTelephoneNumber("9876543210");
				rp.sendPassword("Password123");
				rp.sendConfirmPassword("Password123");
				rp.clickNewsLetter();
				rp.clickAgree();
				rp.clickContinue();
				
				// Validate error message
				try {
					rp.emailError();
					logger.info("Error message validated for email: " + invalidEmail);
				} catch (AssertionError ae) {
					logger.warn("Email validation might have passed unexpectedly for: " + invalidEmail);
					throw ae;
				}
				
				// Navigate back to home for next iteration
				driver.navigate().back();
			}
			
			logger.info("**** Test Case: Validate Multiple Invalid Email Formats - PASSED ****");

		} catch (Exception e) {

			logger.error("**** Test Case: Validate Multiple Invalid Email Formats - FAILED ****");
			logger.debug("**** Debugging started ****");
			logger.error("Exception occurred: " + e.getMessage());
			e.printStackTrace();
			Assert.fail("Test failed with exception: " + e.getMessage());

		}

	}

	@Test(groups = { "negative" })
	public void validateInvalidEmailWithSpecialCharacters() {

		try {

			logger.info("**** Test Case: Validate Invalid Email with Special Characters - Started ****");
			
			HomePageObjectClass homePage = new HomePageObjectClass(driver);
			homePage.clickMyAccount();
			homePage.clickRegister();
			logger.info("Navigated to register page");
			
			RegisterPageObjectClass rp = new RegisterPageObjectClass(driver);
			
			// Test with special characters in email
			String invalidEmail = "invalid!#$@domain.com";
			
			logger.info("Testing with email containing special characters: " + invalidEmail);
			
			rp.sendFirstName("Jane");
			rp.sendLastName("Smith");
			rp.sendEmail(invalidEmail);
			rp.sendTelephoneNumber("9876543210");
			rp.sendPassword("Password123");
			rp.sendConfirmPassword("Password123");
			rp.clickNewsLetter();
			rp.clickAgree();
			rp.clickContinue();
			
			// Validate error message
			rp.emailError();
			logger.info("Error message validated for email with special characters");
			
			logger.info("**** Test Case: Validate Invalid Email with Special Characters - PASSED ****");

		} catch (Exception e) {

			logger.error("**** Test Case: Validate Invalid Email with Special Characters - FAILED ****");
			logger.error("Exception occurred: " + e.getMessage());
			e.printStackTrace();
			Assert.fail("Test failed with exception: " + e.getMessage());

		}

	}

}
