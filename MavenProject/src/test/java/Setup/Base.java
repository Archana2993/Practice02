package Setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;


public class Base {

	static WebDriver driver;
		public static WebDriver openChromeBrowser()
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Sotware tesing\\Selenium\\New folder\\chromedriver.exe");
			 driver=new ChromeDriver();
			return driver;
		}
		public static WebDriver openFirefoxBrowser()
		{
			System.setProperty("webdriver.gecko.driver","D:\\Sotware tesing\\Selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
			return driver;
		}
		
		
	
}
