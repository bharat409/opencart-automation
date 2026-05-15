package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AccountCreatedObjectClass extends BasePage{
	
    public AccountCreatedObjectClass(WebDriver driver) {
		
		super(driver);
	
	}
    
	
	//locators
    By next = By.xpath("//a[normalize-space()='Continue']");
    By ac = By.xpath("//h1[normalize-space()='Your Account Has Been Created!']");
    By mp = By.xpath("//p[contains(text(),'You can now take advantage of member privileges to')]");
    By questions = By.xpath("//p[contains(text(),'If you have ANY questions about the operation of t')]");
    By confirmemail = By.xpath("//p[contains(text(),'A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please')]");
    
    
    //Action methods
    public void clickContinue() 
    {
 	   
    	WebElement element = driver.findElement(next);
 	    JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
    
    public void accountCreated() 
    {
 	   
 	   String account = driver.findElement(ac).getText(); 	   
 	   Assert.assertEquals("Your Account Has Been Created!", account);
 	   System.out.println(account);
    }
    
    public void memberPrivileges() 
    {
 	   
 	   String member = driver.findElement(mp).getText();
 	   Assert.assertEquals("You can now take advantage of member privileges to enhance your online shopping experience with us.", member);
 	  System.out.println(member);
 	   
    }
    
    public void questions() 
    {
 	   
 	   String question = driver.findElement(questions).getText();
 	   Assert.assertEquals("If you have ANY questions about the operation of this online shop, please e-mail the store owner.", question);
 	  System.out.println(question);
    }
    
    public void confirmationEmail() 
    {
 	   
 	   String ce = driver.findElement(confirmemail).getText();
 	   Assert.assertEquals("A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.", ce);;
 	   System.out.println(ce);
    }
	
}
