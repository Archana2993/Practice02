package SeleniumDemo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


public class SeleniumMessho {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","D:\\Sotware tesing\\Selenium\\chromedriver_win32\\chromedriver.exe");
	    ChromeOptions option=new ChromeOptions();
	    option.addArguments("--disable-notifications");	    
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://www.meesho.com/");		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Actions act=new Actions(driver);		
		WebElement womenWestern=driver.findElement(By.xpath("//span[text()='Women Western']"));
		WebElement cat=driver.findElement(By.xpath("//p[text()='Shorts']"));
	    act.moveToElement(womenWestern).moveToElement(cat).click().build().perform();	    
	    Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement item=driver.findElement(By.xpath("//p[text()='Ravishing Glamarous Women Shorts']"));		
		js.executeScript("arguments[0].scrollIntoView(true);",item);
		js.executeScript("arguments[0].click();",item);
		Thread.sleep(3000);
		WebElement size=driver.findElement(By.xpath("(//span[text()='30'])[1]"));
		js.executeScript("arguments[0].click();",size);		
		WebElement addTocart=driver.findElement(By.xpath("//span[text()='Add to Cart']"));
		js.executeScript("arguments[0].scrollIntoView(true);",addTocart);
		js.executeScript("arguments[0].click();",addTocart);;
		
	}

}
