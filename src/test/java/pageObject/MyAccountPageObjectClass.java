package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MyAccountPageObjectClass extends BasePage{
	
     public MyAccountPageObjectClass(WebDriver driver) {
		
		super(driver);
	
	 }
	
    
	
	//locators
    By ma = By.xpath("//a[@title='My Account']");
    By home = By.xpath("//i[@class='fas fa-home']");
    By myAccountText = By.xpath("//h2[text() = 'My Account']");
    By logOut = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']");    
    
    //Action methods
    public void myAccountText() 
    {
 	   
 	   String account = driver.findElement(myAccountText).getText();
 	   Assert.assertEquals("My Account", account);
    }
    
    public void clickHomeButton() 
    {
 	   
 	   driver.findElement(home).click(); 	    	
    }
    
    public void clickMyAccount() 
    {
 	   
        driver.findElement(ma).click();
 	   
    }
    
    public void clickLogOut() 
    {
 	   
 	  driver.findElement(logOut).click();
 	   
    }
       
}
