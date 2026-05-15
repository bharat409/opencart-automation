package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger ;
	public Properties p;
	 
	 
	 @SuppressWarnings("deprecation")
	 @BeforeClass(groups = {"sanity","regression","positive","negative"}) 
	 @Parameters({"browser","operating system"})
	 public void openApp(String br, String os) throws IOException {
          
		  
		  
		  FileReader file = new FileReader("./src//test//resources//config.properties");
		  p = new Properties();
		  p.load(file);
		  
		  logger = LogManager.getLogger(this.getClass());
		  
		  if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
			{
				DesiredCapabilities capabilities=new DesiredCapabilities();
				
				
				if(os.equalsIgnoreCase("windows"))
				{
					capabilities.setPlatform(Platform.WIN10);
				}
				else if(os.equalsIgnoreCase("linux"))
				{
					capabilities.setPlatform(Platform.LINUX);
					
				}
				else if (os.equalsIgnoreCase("mac"))
				{
					capabilities.setPlatform(Platform.MAC);
				}
				else
				{
					System.out.println("No matching os");
					return;
				}
				
				driver = new RemoteWebDriver(new URL("http://192.168.1.4:4444"), capabilities);
				
				switch(br.toLowerCase())
				{
				case "chrome" : driver=new ChromeDriver(); break;
				case "edge" : driver=new EdgeDriver(); break;
				case "firefox": driver=new FirefoxDriver(); break;
				default : System.out.println("Invalid browser name.."); return;
				}
								
				
				
				if(p.getProperty("execution_env").equalsIgnoreCase("local"))
				{

					switch(br.toLowerCase())
					{
					case "chrome" : driver=new ChromeDriver(); break;
					case "edge" : driver=new EdgeDriver(); break;
					case "firefox": driver=new FirefoxDriver(); break;
					default : System.out.println("Invalid browser name.."); return;
					}
				}
		  	
		  
		  driver.get(p.getProperty("url"));
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  System.out.println("open application test method passed");
			}
	  }
	
	@AfterClass(groups = {"sanity","regression","positive","negative"}) 
    public void closeApp() {
  	  	  
  	  driver.close();
  	  System.out.println("close application test method passed");
    }
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
//	public String getRandomMail() {
//		
//		String randomMail = RandomStringUtils.randomAlphabetic(5);
//		return randomMail;
//		
//	}
	
	

}
