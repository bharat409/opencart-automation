package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePageObjectClass extends BasePage{	
	
	public HomePageObjectClass(WebDriver driver) {
		
		super(driver);
	
	}
	
    //locators
    By myAccount = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a");
    By register = By.xpath("//a[normalize-space()='Register']");

   
   //Action methods 
   public void clickMyAccount() 
   {
	   
	   driver.findElement(myAccount).click();
   }
   
   public void clickRegister()
   {
	   driver.findElement(register).click();
   }

}
