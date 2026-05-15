package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountLogoutPage extends BasePage {

	public AccountLogoutPage(WebDriver driver) {

		super(driver);

	}

	// locators
	By title = By.xpath("//a[@title = 'My Account']");
	By reg = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a");
	By home = By.xpath("//i[@class='fa fa-home']");
	By directReg = By.xpath("//*[@id=\"column-right\"]/div/a[2]"); 

	// action methods

	public void myAccount() {

		driver.findElement(title).click();

	}

	public void register() {

		driver.findElement(reg).click();

	}

	
	public void clickHome() {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement hm = driver.findElement(home);
		js.executeScript("arguments[0].click()", hm);
		
	}
	
	public void clickDirectReg() {
		
		driver.findElement(directReg).click();
	}
	
	
}
