package SeleniumDemo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumRedBus {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","D:\\Sotware tesing\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement from=driver.findElement(By.xpath("//input[@id='src']"));
		WebElement to=driver.findElement(By.xpath("//input[@id='dest']"));
		WebElement date=driver.findElement(By.xpath("//input[@id='onward_cal']"));
		WebElement search=driver.findElement(By.xpath("//button[@id='search_btn']"));
	
		from.sendKeys("pune");
		List<WebElement> fromBusList=driver.findElements(By.xpath("//li[@class='sub-city']"));
		for(int i=0;i<fromBusList.size();i++)
		{
			String list=fromBusList.get(i).getText();
			System.out.println(list);
			if(list.contains("Pimpri Chinchwad, Pune"))
			{
				fromBusList.get(i).click();
				break;
			}
			
		}
		to.sendKeys("Bangalore");
		List<WebElement> toBusList=driver.findElements(By.xpath("//li[@class='sub-city']"));
		for(int i=0;i<toBusList.size();i++)
		{
			String list=toBusList.get(i).getText();
			System.out.println(list);
			if(list.contains("Anand Rao Circle, Bangalore"))
			{
				toBusList.get(i).click();
				break;
			}
			
		}
		date.click();
		WebElement month=driver.findElement(By.xpath("//td[@class='monthTitle']"));
		WebElement next=driver.findElement(By.xpath("//td[@class='next']"));
		Actions act=new Actions(driver);
		act.moveToElement(month).moveToElement(next).click().build().perform();
		List<WebElement> dateNew=driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//tr//td"));
		for(int j=0;j<dateNew.size();j++)
		{
			String date1=dateNew.get(j).getText();
			System.out.println(date1);
			if(date1.contains("1"))
			{
				dateNew.get(j).click();
				break;
			}
		}
		search.click();
		List<WebElement> checkbox=driver.findElements(By.xpath("//div[@class='filter-details f-12 d-color']//ul//li//label[2]"));
		for(int j=0;j<checkbox.size();j++)
		{
			String box=checkbox.get(j).getText();
			System.out.println(box);
			if(box.contains("After 6 pm"))
			{
				checkbox.get(j).click();
				
			}
			if(box.contains("SLEEPER"))
			{
				checkbox.get(j).click();
				break;
			}
		}
		
		WebElement bus=driver.findElement(By.xpath("(//div[text()='View Seats'])[2]"));
		bus.click();
	}

}
