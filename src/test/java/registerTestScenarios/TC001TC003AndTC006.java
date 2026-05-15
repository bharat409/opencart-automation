package registerTestScenarios;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountCreatedObjectClass;
import pageObject.HomePageObjectClass;
import pageObject.RegisterPageObjectClass;
import testBase.BaseClass;

public class TC001TC003AndTC006 extends BaseClass {
	
	
    @Test(groups = {"regression","positive"})   
    public void accountregistration()  {
    	
    	try {    
    		
    		logger.info("****  Test case initiated ****");
    	HomePageObjectClass homePage = new HomePageObjectClass(driver);
    	RegisterPageObjectClass rp = new RegisterPageObjectClass(driver);
    	AccountCreatedObjectClass acoc = new AccountCreatedObjectClass(driver);
    	
    	homePage.clickMyAccount();
    	homePage.clickRegister();
    	rp.sendFirstName("Bharadwaj");
    	rp.sendLastName("Challa");
    	rp.sendEmail("chbharat420212@gmail.com");
    	rp.sendTelephoneNumber("9391259660");
    	rp.sendPassword("Bharath@2000");
    	rp.sendConfirmPassword("Bharath@2000");    	
    	rp.clickAgree();
    	rp.clickContinue();
    	acoc.accountCreated();
    	acoc.memberPrivileges();
    	acoc.questions();
    	acoc.confirmationEmail();
    	acoc.clickContinue();
    	}
    	catch(Exception e ) {
    		logger.error("error occured");
    		logger.debug("debugging started");
    		Assert.fail();
    	}
    	
    }           
}
