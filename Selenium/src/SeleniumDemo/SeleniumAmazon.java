package SeleniumDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumAmazon {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.opera.driver","D:\\Sotware tesing\\Selenium\\New folder\\operadriver_win64\\operadriver.exe");
	    driver=new OperaDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		
		WebElement search =driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search.sendKeys("mobile");
	    search.sendKeys(Keys.ENTER);
	    JavascriptExecutor js=(JavascriptExecutor) driver;
	    
		WebElement brand =driver.findElement(By.xpath("//span[text()='Samsung']"));
		js.executeScript("arguments[0].scrollIntoView(true);", brand);
		js.executeScript("arguments[0].click();", brand);
		
	    List<WebElement> listofmoile=driver.findElements(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']//span"));
	    for(int i=0;i<listofmoile.size();i++)
	    {
	    	String list=listofmoile.get(i).getText();
	    	System.out.println(list);
	    	if(list.equals("Samsung Galaxy M32 (Light Blue, 4GB RAM, 64GB Storage)"))
	    	{
	    		listofmoile.get(i).click();
	    		break;
	    	}
	    }
		
	    driver.getWindowHandles();
	    ArrayList<String> browser=new ArrayList<String>(driver.getWindowHandles());
	    for(String s:browser)
	    {
	    	System.out.println(s); 	
	    }
	    driver.switchTo().window(browser.get(1));
	    System.out.println(driver.getCurrentUrl());
	    
	    WebElement addTocart =driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
	    Thread.sleep(3000);
	    js.executeScript("arguments[0].scrollIntoView(true);",addTocart);
	    addTocart.click();
	   
	    WebElement cart =driver.findElement(By.xpath("(//input[@class='a-button-input'])[25]"));
	    js.executeScript("arguments[0].click();",cart);
	  		
		
	}

}
