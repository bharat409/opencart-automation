package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegisterPageObjectClass extends BasePage{
	
    public RegisterPageObjectClass(WebDriver driver) {
		
		super(driver);
	
	}
   	
	
    //locators

    By fn = By.xpath("//input[@id='input-firstname']");
    By ln = By.xpath("//input[@id='input-lastname']");
    By email = By.xpath("//input[@id='input-email']");
    By mobile = By.id("input-telephone");
    By pwd = By.xpath("//input[@id='input-password']");
    By confrmpwd = By.id("input-confirm");
    By nl = By.xpath("//input[@name='newsletter'][@value='1']");
    By agree = (By.xpath("//input[@name='agree']"));
    By cont = By.xpath("//input[@value='Continue']");
    By fnError = By.xpath("//div[text() ='First Name must be between 1 and 32 characters!']");
    By lnError = By.xpath("//div[text() ='Last Name must be between 1 and 32 characters!']");
    By mailError = By.xpath("//div[text() ='E-Mail Address does not appear to be valid!']");
    By tphError = By.xpath("//div[text() = 'Telephone must be between 3 and 32 characters!']");
    By pwdError = By.xpath("//div[text() ='Password must be between 4 and 20 characters!']");
    By agreePolicyError = By.xpath("//div[text() ='Warning: You must agree to the Privacy Policy!']");
    By confrmpwdError = By.xpath("//div[text() = 'Password confirmation does not match password!']");
    

   
   //Action methods 
   public void sendFirstName(String firstname) 
   {
	   
	   driver.findElement(fn).sendKeys(firstname);
   }
   
   public void sendLastName(String lastname) 
   {
	   
	   driver.findElement(ln).sendKeys(lastname);
   }
   
   public void sendEmail(String emailto) 
   {
	   
	   driver.findElement(email).sendKeys(emailto);
   }
   
   public void sendTelephoneNumber(String num)
   {
	   driver. findElement(mobile).sendKeys(num);
   }
   
   public void sendPassword(String password) 
   {
	   
	   driver.findElement(pwd).sendKeys(password);
   }
   
   public void sendConfirmPassword(String pwd)
   {
	   driver.findElement(confrmpwd).sendKeys(pwd);
   }
   
   public void clickNewsLetter() 
   {
	   
	   driver.findElement(nl).click();
   }
   
   public void clickAgree() 
   { 

	   driver.findElement(agree).click();
   }
   
   public void clickContinue() 
   {
	   	   
	   driver.findElement(cont).click();
   }
   
   //appearing messages validation methods when no field is entered with value in account registration page
   public void firstNameError()
   {
   	
   	String error1 = driver.findElement(fnError).getAttribute("innerText");
   	Assert.assertEquals("First Name must be between 1 and 32 characters!", error1);
   	System.out.println(error1);
   }
   
   public void lastNameError()
   {
   	
   	String error2 = driver.findElement(lnError).getAttribute("innerText");
   	Assert.assertEquals("Last Name must be between 1 and 32 characters!", error2);
   	System.out.println(error2);
   }
   
   public void emailError()
   {
   	
   	String error3 = driver.findElement(mailError).getAttribute("innerText");
   	Assert.assertEquals("E-Mail Address does not appear to be valid!", error3);
   	System.out.println(error3);
   }
   
   public void telephoneError()
   {
   	
   	String error4 = driver.findElement(tphError).getAttribute("innerText");
   	Assert.assertEquals("Telephone must be between 3 and 32 characters!", error4);
   	System.out.println(error4);
   }
   
   public void passwordError()
   {
   	
   	String error5 = driver.findElement(pwdError).getAttribute("innerText");
   	Assert.assertEquals("Password must be between 4 and 20 characters!", error5);
   	System.out.println(error5);
   }
   
   
   public void policyError()
   {
   	
   	String error6 = driver.findElement(agreePolicyError).getAttribute("innerText");
   	Assert.assertEquals("Warning: You must agree to the Privacy Policy!", error6);
   	System.out.println(error6);
   }
   
   public String confirmPasswordError()
   {
   	
   	String error7 = driver.findElement(confrmpwdError).getAttribute("innerText");
   	Assert.assertEquals("Password confirmation does not match password!", error7);
   	System.out.println(error7);
   	return error7;
   }
   
   public void scrollDownEndPage() {
	   
	   JavascriptExecutor js = (JavascriptExecutor)driver;
	   js.executeAsyncScript("Window.scrollBy(0,document.body.scrollHeight)");	  
	   	   	  
   }

   
}
